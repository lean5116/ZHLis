package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.LJytmxx;
import com.RealLis.specimenInhos.mapper.LjytmxxMapper;
import com.RealLis.specimenInhos.service.LJytmxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LJytmxxServiceImpl implements LJytmxxService {
    @Autowired
    private LjytmxxMapper ljytmxxMapper;
    @Override
    public int updateByBarcode(LJytmxx lJytmxx) {
        if(!lJytmxx.getParams().containsKey("confirmCancel")) {
            return ljytmxxMapper.update(lJytmxx);
        }else{
            return ljytmxxMapper.removeExecutTime(lJytmxx);
        }
    }
}
