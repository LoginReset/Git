package com.cdzci.zic_yt_test.dao.sql;

import com.cdzci.zic_yt_test.domain.Data;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class DataSQL {
    public String select(Map<String,Object> map) {
        return new SQL() {
            {
                SELECT("uid,content,create_date");
                FROM("data");
                if (map.get("uid") != null) {
                    WHERE("uid=#{uid}");
                }
                if (map.get("year")!=null){
                    WHERE("year=#{year}");
                }
                if (map.get("month")!=null){
                    WHERE("month=#{month}");
                }
                if (map.get("day")!=null){
                    WHERE("day=#{day}");
                }
            }
        }.toString();
    }
}
