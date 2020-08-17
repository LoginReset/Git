package com.cdzci.zic_yt_test;

import com.cdzci.zic_yt_test.dao.DataMapper;
import com.cdzci.zic_yt_test.dao.sql.DataSQL;
import com.cdzci.zic_yt_test.domain.Data;
import com.cdzci.zic_yt_test.service.DataService;
import com.cdzci.zic_yt_test.vo.svo.DataSVO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ZicYtTestApplicationTests {
//	@Autowired
//	private DataMapper dataService;
	RestTemplate restTemplate=new RestTemplate();
	@Test
	public void contextLoads() {

//		Map<String,Object> mapCondition=new HashMap<>();
//		mapCondition.put("month",1);
//        String forObject = restTemplate.getForObject("http://localhost:8080/zic_yg_test/data?month=1", String.class);
//        System.out.println(forObject);
//	    dataService.insert("666666","jsalfjsadfas","2018-08-02 11:41:32");
//		Map<String,Object> mapCondition=new HashMap<>();
//		mapCondition.put("uid","666666");
//		mapCondition.put("year",2018);
//		mapCondition.put("month",8);
//		mapCondition.put("day",1);
//        Data data=new Data();
//        List<DataSVO> select = dataService.select(null,2018,null,1);
//        System.out.println(select+"***"+select.size());
//        for (int i = 0; i <select.size(); i++) {
//            System.out.println(select.get(i));
//        }
    }





}
