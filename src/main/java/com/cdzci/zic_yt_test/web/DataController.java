package com.cdzci.zic_yt_test.web;

import com.cdzci.zic_yt_test.domain.ResponseObj;
import com.cdzci.zic_yt_test.service.DataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataController {
    private static final Logger LOGGER= LogManager.getLogger(DataController.class);
    @Autowired
    private DataService dataService;
    @GetMapping(value = {"/data"})
    public ResponseObj data1(String uid, Integer year, Integer month, Integer day){
        ResponseObj responseObj=new ResponseObj(ResponseObj.ERROR_CODE_FAIL);
        try {
            responseObj.setRespObj(dataService.select(uid, year, month, day));
            responseObj.setErrorCode(ResponseObj.ERROR_CODE_SUCCESS);
        } catch (Exception e) {
            LOGGER.error("查询记录失败"+e.toString());
            responseObj.setErrorMsg("查询记录失败,case:"+e.toString());
        }
        return responseObj;
    }
}
