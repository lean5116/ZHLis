package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.LLogistics;
import com.RealLis.specimenInhos.domain.LLogisticsDetailVO;

import java.util.List;

public interface LLogisticsService {
    List<LLogistics> getLlogisticsList(LLogistics lLogistics);
    List<LLogisticsDetailVO> getLlogisticsDetailByWlbh(String wlbh);
    LLogistics getLlogistics(LLogistics lLogistics);
    int updateLogistics(LLogistics lLogistics);
}
