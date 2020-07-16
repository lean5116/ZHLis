package com.RealLis.dataSync.service;

import com.RealLis.dataSync.domain.LTsxxHis;

import java.util.List;

public interface LTsxxHisService {
    LTsxxHis getByXh(Long xh);
    LTsxxHis getByLisxh(Long lisxh);
    int updateByLisxh(LTsxxHis lTsxxHis);
    int insert(LTsxxHis lTsxxHis);
    int deleteByLisxh(Long lisxh);
}
