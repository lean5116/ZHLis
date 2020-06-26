package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.HisAdvice;
import java.util.List;


public interface HisAdviceMapper {
    public List<HisAdvice> queryDistinctList(HisAdvice hisAdvice);
}
