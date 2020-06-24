package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.LLogistics;
import com.RealLis.specimenInhos.domain.LLogisticsDetailVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LLoginsticsMapper {
    public List<LLogistics> getLlogistics(LLogistics lLogistics);
    public List<LLogisticsDetailVO> getLlogisticsDetail(String wlbh);
}
