package com.cdzci.zic_yt_test.dao;


import com.cdzci.zic_yt_test.dao.sql.DataSQL;
import com.cdzci.zic_yt_test.domain.Data;
import com.cdzci.zic_yt_test.vo.svo.DataSVO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataMapper{
    @Insert("insert into data(uid,content,year,month,day,create_date) value(#{uid},#{content},year(#{tt})," +
            "month(#{tt}),day(#{tt}),#{tt})")
    int insert(@Param("uid")String uid,@Param("content")String content,@Param("tt")String tt);

    @SelectProvider(type = DataSQL.class,method = "select")
    @Results({
            @Result(column ="uid",property = "uid"),
            @Result(column ="content",property = "content"),
            @Result(column ="create_date",property = "createDate")
    })
    List<DataSVO> select(@Param("uid")String uid, @Param("year")Integer year, @Param("month")Integer month, @Param("day")Integer day);
}
