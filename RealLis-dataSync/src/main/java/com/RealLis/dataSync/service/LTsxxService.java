package com.RealLis.dataSync.service;

import com.RealLis.dataSync.domain.LTsxx;

public interface LTsxxService {
    LTsxx getByHisxh(Long hisxh);
    LTsxx getByxh(Long xh);
    int insert(LTsxx lTsxx);
    int updateByHisxh(LTsxx lTsxx);
    int deleteByHisxh(Long hisxh);
}
