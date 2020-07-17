package com.RealLis.dataSync.mapper;

import com.RealLis.dataSync.domain.LTsmx;

import java.util.List;

public interface LTsmxMapper {
    List<LTsmx> queryById(String sampleno);
    List<LTsmx> queryAll(LTsmx lTsmx);
    int insert(LTsmx lTsmx);
    int update(LTsmx lTsmx);
    int deleteById(String sampleno);
}
