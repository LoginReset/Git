package com.cdzci.zic_yt_test.cache;

import com.aliyun.datahub.DatahubClient;
import com.aliyun.datahub.common.data.Field;
import com.aliyun.datahub.common.data.FieldType;
import com.aliyun.datahub.common.data.RecordSchema;
import com.aliyun.datahub.exception.DatahubClientException;
import com.aliyun.datahub.exception.InvalidCursorException;
import com.aliyun.datahub.model.GetCursorResult;
import com.aliyun.datahub.model.GetRecordsResult;
import com.aliyun.datahub.model.RecordEntry;
import com.cdzci.zic_yt_test.service.DataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ObtainEventHandle implements Runnable {
    private static final Logger LOGGER= LogManager.getLogger(ObtainEventHandle.class);
    private DataService dataService;
    private DatahubClient datahubClient;
    private String projectName;
    private String topicName;
    private String shardId;
    private int limit = 100;

    public ObtainEventHandle(DataService dataService, DatahubClient datahubClient, String projectName, String topicName, String shardId) {
        this.dataService = dataService;
        this.datahubClient = datahubClient;
        this.projectName = projectName;
        this.topicName = topicName;
        this.shardId = shardId;
    }

    public ObtainEventHandle(DataService dataService, DatahubClient datahubClient, String projectName, String topicName, String shardId, int limit) {
        this.dataService = dataService;
        this.datahubClient = datahubClient;
        this.projectName = projectName;
        this.topicName = topicName;
        this.shardId = shardId;
        this.limit = limit;
    }

    @Override
    public void run() {
        try {
            GetCursorResult cursorRs = datahubClient.getCursor(projectName, topicName, shardId, System.currentTimeMillis()-10000);
            String cursor = cursorRs.getCursor();
            RecordSchema schema = new RecordSchema();
            schema.addField(new Field("fd", FieldType.STRING));
            schema.addField(new Field("data", FieldType.STRING));
            schema.addField(new Field("tt", FieldType.STRING));
            LOGGER.error("启动执行线程成功");
            while (true) {
                try {
                    GetRecordsResult recordRs = datahubClient.getRecords(projectName, topicName, shardId, cursor, limit, schema);
                    List<RecordEntry> recordEntries = recordRs.getRecords();
                    if (recordEntries.size() == 0) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            LOGGER.error(e.getMessage());
                        }
                    } else {
                        for (RecordEntry recordEntry : recordEntries) {
                            String fd = recordEntry.getString("fd");
                            String data = recordEntry.getString("data");
                            String tt = recordEntry.getString("tt");
                            dataService.insert(fd,data,tt);
                        }
                    }
                    // 拿到下一个游标
                    cursor = recordRs.getNextCursor();
                } catch (InvalidCursorException ex) {
                    // 非法游标或游标已过期
                    cursorRs = datahubClient.getCursor(projectName, topicName, shardId,System.currentTimeMillis()-10000);
                    cursor = cursorRs.getCursor();
                    LOGGER.error("非法游标或游标已过期" + ex.toString());
                } catch (DatahubClientException ex) {
                    // 发生异常，需要重试
                    LOGGER.error(ex.toString());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("启动执行线程失败，case："+e.toString());
        }

    }
}
