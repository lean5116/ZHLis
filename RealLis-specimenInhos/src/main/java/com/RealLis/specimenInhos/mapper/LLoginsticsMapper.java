package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.LLogistics;
import com.RealLis.specimenInhos.domain.LLogisticsDetailVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LLoginsticsMapper {
    List<LLogistics> queryLlogisticsList(LLogistics lLogistics);
    List<LLogisticsDetailVO> queryLlogisticsDetailByWlbh(String wlbh);
    LLogistics queryLlogistics(LLogistics lLogistics);
    int updateLogistics(LLogistics lLogistics);
}
