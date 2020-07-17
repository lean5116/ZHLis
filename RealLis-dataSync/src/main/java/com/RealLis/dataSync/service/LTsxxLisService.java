package com.RealLis.dataSync.service;

import com.RealLis.dataSync.domain.LTsxxLis;

public interface LTsxxLisService {
    LTsxxLis getByHisxh(Long hisxh);
    LTsxxLis getByxh(Long xh);
    int insert(LTsxxLis lTsxxLis);
    int updateByHisxh(LTsxxLis lTsxxLis);
    int deleteByHisxh(Long hisxh);
}
