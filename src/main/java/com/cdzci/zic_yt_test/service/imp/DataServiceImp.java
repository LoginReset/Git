package com.cdzci.zic_yt_test.service.imp;

import com.cdzci.zic_yt_test.dao.DataMapper;
import com.cdzci.zic_yt_test.dao.sql.DataSQL;
import com.cdzci.zic_yt_test.service.DataService;
import com.cdzci.zic_yt_test.vo.svo.DataSVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataServiceImp implements DataService {
    @Autowired
    private DataMapper dataMapper;
    @Override
    public int insert(String uid, String content, String tt) {
        return dataMapper.insert(uid, content, tt);
    }

    @Override
    public List<DataSVO> select(String uid, Integer year, Integer month, Integer day) {
        return dataMapper.select(uid, year, month, day);
    }
}
