package com.RealLis.dataSync.service.impl;

import com.RealLis.common.annotation.DataSource;
import com.RealLis.common.enums.DataSourceType;
import com.RealLis.dataSync.domain.LTsxx;
import com.RealLis.dataSync.mapper.LTsxxMapper;
import com.RealLis.dataSync.service.LTsxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LTsxxServiceImpl implements LTsxxService {
    @Autowired
    private LTsxxMapper lTsxxMapper;
    @Override
    public LTsxx getByHisxh(Long hisxh) {
        return lTsxxMapper.queryById(hisxh);
    }

    @Override
    public LTsxx getByxh(Long xh) {
        return lTsxxMapper.queryByxh(xh);
    }

    @Override
    public int insert(LTsxx lTsxx) {
        return lTsxxMapper.insert(lTsxx);
    }

    @Override
    public int updateByHisxh(LTsxx lTsxx) {
        return lTsxxMapper.update(lTsxx);
    }

    @Override
    public int deleteByHisxh(Long hisxh) {
        return lTsxxMapper.deleteById(hisxh);
    }
}
