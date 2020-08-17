package com.cdzci.zic_yt_test.service;

import com.cdzci.zic_yt_test.vo.svo.DataSVO;

import java.util.List;

public interface DataService {
    int insert(String uid,String content,String tt);
    List<DataSVO> select(String uid, Integer year, Integer month, Integer day);
}
