package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.LJytmxx;
import org.springframework.stereotype.Repository;

@Repository
public interface LjytmxxMapper {
    int update(LJytmxx lJytmxx);
    int removeExecutTime(LJytmxx lJytmxx);
    int updateHisAdvice(LJytmxx lJytmxx);
}
