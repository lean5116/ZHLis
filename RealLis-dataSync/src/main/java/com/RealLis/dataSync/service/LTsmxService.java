package com.RealLis.dataSync.service;

import com.RealLis.dataSync.domain.LTsmx;

import java.util.List;

public interface LTsmxService {
    List<LTsmx> getBySampleno(String sampleno);
    List<LTsmx> getAll(LTsmx lTsmx);
    int insert(LTsmx lTsmx);
    int update(LTsmx lTsmx);
    int deleteBySampleno(String sampleno);
}
