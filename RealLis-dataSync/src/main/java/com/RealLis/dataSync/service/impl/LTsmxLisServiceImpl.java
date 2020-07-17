package com.RealLis.dataSync.service.impl;

import com.RealLis.dataSync.domain.LTsmx;
import com.RealLis.dataSync.mapper.LTsmxMapper;
import com.RealLis.dataSync.service.LTsmxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LTsmxLisService")
public class LTsmxLisServiceImpl implements LTsmxService {
    @Autowired
    private LTsmxMapper lTsmxMapper;
    @Override
    public List<LTsmx> getBySampleno(String sampleno) {
        return lTsmxMapper.queryById(sampleno);
    }

    @Override
    public List<LTsmx> getAll(LTsmx lTsmx) {
        return lTsmxMapper.queryAll(lTsmx);
    }

    @Override
    public int insert(LTsmx lTsmx) {
        return lTsmxMapper.insert(lTsmx);
    }

    @Override
    public int update(LTsmx lTsmx) {
        return lTsmxMapper.update(lTsmx);
    }

    @Override
    public int deleteBySampleno(String sampleno) {
        return lTsmxMapper.deleteById(sampleno);
    }
}
