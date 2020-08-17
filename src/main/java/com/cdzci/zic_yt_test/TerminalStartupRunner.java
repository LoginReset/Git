package com.cdzci.zic_yt_test;

import com.aliyun.datahub.DatahubClient;
import com.aliyun.datahub.DatahubConfiguration;
import com.aliyun.datahub.auth.AliyunAccount;
import com.cdzci.zic_yt_test.cache.ObtainEventHandle;
import com.cdzci.zic_yt_test.service.DataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TerminalStartupRunner implements CommandLineRunner {
    private static final Logger LOGGER= LogManager.getLogger(TerminalStartupRunner.class);
    @Autowired
    private DataService dataService;
    @Value("${ali.datahub}")
    private String dataHubUrl;
    @Value("${ali.accessId}")
    private String accessId;
    @Value("${ali.accessKey}")
    private String accessKey;
    @Value("${ali.projectName}")
    private String projectName;
    @Value("${ali.topicName}")
    private String topicName;
    @Value("${ali.shardId}")
    private String shardId;

    @Override
    public void run(String... args) throws Exception {
        try {
            AliyunAccount account = new AliyunAccount(accessId, accessKey);
            DatahubConfiguration conf = new DatahubConfiguration(account, dataHubUrl);
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.submit(new ObtainEventHandle(dataService,new DatahubClient(conf),projectName,topicName,shardId));
            LOGGER.error("执行任务成功");
        }catch (Exception e){
            LOGGER.error("执行任务异常，case:"+e.toString());
        }

    }
}
