package com.RealLis.dataSync.service.impl;

import com.RealLis.dataSync.domain.LTsxxLis;
import com.RealLis.dataSync.mapper.LTsxxLisMapper;
import com.RealLis.dataSync.service.LTsxxLisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LTsxxLisServiceImpl implements LTsxxLisService {
    @Autowired
    private LTsxxLisMapper lTsxxLisMapper;
    @Override
    public LTsxxLis getByHisxh(Long hisxh) {
        return lTsxxLisMapper.queryByHisxh(hisxh);
    }

    @Override
    public LTsxxLis getByxh(Long xh) {
        return lTsxxLisMapper.queryByxh(xh);
    }

    @Override
    public int insert(LTsxxLis lTsxxLis) {
        return lTsxxLisMapper.insert(lTsxxLis);
    }

    @Override
    public int updateByXh(LTsxxLis lTsxxLis) {
        return lTsxxLisMapper.update(lTsxxLis);
    }

    @Override
    public int deleteByHisxh(Long hisxh) {
        return lTsxxLisMapper.deleteByHisxh(hisxh);
    }
}
