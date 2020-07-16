package com.RealLis.dataSync.service.impl;

import com.RealLis.common.annotation.DataSource;
import com.RealLis.common.enums.DataSourceType;
import com.RealLis.dataSync.domain.LTsxxHis;
import com.RealLis.dataSync.mapper.LTsxxHisMapper;
import com.RealLis.dataSync.service.LTsxxHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource(value = DataSourceType.HIS)
public class LTsxxHisServiceImpl implements LTsxxHisService {
    @Autowired
    LTsxxHisMapper lTsxxHisMapper;
    @Override
    public LTsxxHis getByXh(Long xh) {
        return lTsxxHisMapper.queryById(xh);
    }

    @Override
    public LTsxxHis getByLisxh(Long lisxh) {
        return lTsxxHisMapper.queryByLisxh(lisxh);
    }

    @Override
    public int updateByLisxh(LTsxxHis lTsxxHis) {
        return lTsxxHisMapper.update(lTsxxHis);
    }

    @Override
    public int insert(LTsxxHis lTsxxHis) {
        return lTsxxHisMapper.insert(lTsxxHis);
    }

    @Override
    public int deleteByLisxh(Long lisxh) {
        return lTsxxHisMapper.deleteById(lisxh);
    }
}
