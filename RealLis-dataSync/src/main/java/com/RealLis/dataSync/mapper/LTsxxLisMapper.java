package com.RealLis.dataSync.mapper;

import com.RealLis.dataSync.domain.LTsxxLis;

import java.util.List;

public interface LTsxxLisMapper {
    LTsxxLis queryByHisxh(Long hisxh);
    LTsxxLis queryByxh(Long xh);
    List<LTsxxLis>queryAll(LTsxxLis lTsxxLis);
    int insert(LTsxxLis lTsxxLis);
    int update(LTsxxLis lTsxxLis);
    int deleteByHisxh(Long hisxh);
}
