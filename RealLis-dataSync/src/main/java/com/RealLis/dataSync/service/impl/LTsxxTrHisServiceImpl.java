package com.RealLis.dataSync.service.impl;

import com.RealLis.common.annotation.DataSource;
import com.RealLis.common.enums.DataSourceType;
import com.RealLis.dataSync.domain.LTsxxTr;
import com.RealLis.dataSync.mapper.LTsxxTrMapper;
import com.RealLis.dataSync.service.LTsxxTrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LTsxxTrHisService")
@DataSource(value = DataSourceType.HIS)
public class LTsxxTrHisServiceImpl implements LTsxxTrService {
    @Autowired
    private LTsxxTrMapper lTsxxTrMapper;
    @Override
    public List<LTsxxTr> getAll() {
        return lTsxxTrMapper.queryAll(null);
    }

    @Override
    public int deleteByJlxh(Long jlxh) {
        return lTsxxTrMapper.deleteById(jlxh);
    }
}
