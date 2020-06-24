package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.LLogistics;
import com.RealLis.specimenInhos.domain.LLogisticsDetailVO;

import java.util.List;

public interface LLogisticsService {
    public List<LLogistics> getLlogistics(LLogistics lLogistics);
    public List<LLogisticsDetailVO> getLlogisticsDetail(String wlbh);
}
