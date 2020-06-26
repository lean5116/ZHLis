package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.LLogistics;
import com.RealLis.specimenInhos.domain.LLogisticsDetailVO;
import com.RealLis.specimenInhos.mapper.LLoginsticsMapper;
import com.RealLis.specimenInhos.service.LLogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LLogisticsServiceImpl implements LLogisticsService {
    @Autowired
    private LLoginsticsMapper lLoginsticsMapper;
    @Override
    public List<LLogistics> getLlogisticsList(LLogistics lLogistics) {
        return lLoginsticsMapper.queryLlogisticsList(lLogistics);
    }

    @Override
    public List<LLogisticsDetailVO> getLlogisticsDetailByWlbh(String wlbh) {
        return lLoginsticsMapper.queryLlogisticsDetailByWlbh(wlbh);
    }

    @Override
    public LLogistics getLlogistics(LLogistics lLogistics) {
        return lLoginsticsMapper.queryLlogistics(lLogistics);
    }

    @Override
    public int updateLogistics(LLogistics lLogistics) {
        return lLoginsticsMapper.updateLogistics(lLogistics);
    }
}
