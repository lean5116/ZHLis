package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.HisAdvice;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface HisAdviceMapper {
    public List<HisAdvice> queryDistinct(HisAdvice hisAdvice);
}
