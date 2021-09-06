package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.LJytmxx;
import com.RealLis.specimenInhos.mapper.LjytmxxMapper;
import com.RealLis.specimenInhos.service.LJytmxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LJytmxxServiceImpl implements LJytmxxService {
    @Autowired
    private LjytmxxMapper ljytmxxMapper;
    @Override
    public int updateByBarcode(LJytmxx lJytmxx) {
        if(!lJytmxx.getParams().containsKey("confirmCancel")) {
            try {
                ljytmxxMapper.updateHisAdvice(lJytmxx);
            }catch (Exception e ){}
            return ljytmxxMapper.update(lJytmxx);
        }else{
            return ljytmxxMapper.removeExecutTime(lJytmxx);
        }
    }

}
