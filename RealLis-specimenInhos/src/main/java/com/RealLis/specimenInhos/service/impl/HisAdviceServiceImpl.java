package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.HisAdvice;
import com.RealLis.specimenInhos.mapper.HisAdviceMapper;
import com.RealLis.specimenInhos.service.HisAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HisAdviceServiceImpl implements HisAdviceService {
    @Autowired
    private HisAdviceMapper hisAdviceMapper;
    @Override
    public List<HisAdvice> getDisPatientIdList(HisAdvice hisAdvice) {
        return hisAdviceMapper.queryDistinctList(hisAdvice);
    }
}
