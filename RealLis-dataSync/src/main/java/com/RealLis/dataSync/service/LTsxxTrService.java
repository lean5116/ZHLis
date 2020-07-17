package com.RealLis.dataSync.service;

import com.RealLis.dataSync.domain.LTsxxTr;

import java.util.List;

public interface LTsxxTrService {
    List<LTsxxTr> getAll();
    int deleteByJlxh(Long jlxh);
}
