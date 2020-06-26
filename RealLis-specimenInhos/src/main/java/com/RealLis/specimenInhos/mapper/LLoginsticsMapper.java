package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.LLogistics;
import com.RealLis.specimenInhos.domain.LLogisticsDetailVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LLoginsticsMapper {
    public List<LLogistics> queryLlogisticsList(LLogistics lLogistics);
    public List<LLogisticsDetailVO> queryLlogisticsDetailByWlbh(String wlbh);
    public LLogistics queryLlogistics(LLogistics lLogistics);
    public int updateLogistics(LLogistics lLogistics);
}
