package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.LLogistics;
import com.RealLis.specimenInhos.domain.LLogisticsDetailVO;

import java.util.List;

public interface LLogisticsService {
    public List<LLogistics> getLlogisticsList(LLogistics lLogistics);
    public List<LLogisticsDetailVO> getLlogisticsDetailByWlbh(String wlbh);
    public LLogistics getLlogistics(LLogistics lLogistics);
    public int updateLogistics(LLogistics lLogistics);
}
