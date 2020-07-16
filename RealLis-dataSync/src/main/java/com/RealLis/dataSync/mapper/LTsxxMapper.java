package com.RealLis.dataSync.mapper;

import com.RealLis.dataSync.domain.LTsxx;

import java.util.List;

public interface LTsxxMapper {
    LTsxx queryById(Long hisxh);
    LTsxx queryByxh(Long xh);
    List<LTsxx> queryAllByLimit(Long offset,Long limit);
    List<LTsxx>queryAll(LTsxx lTsxx);
    int insert(LTsxx lTsxx);
    int update(LTsxx lTsxx);
    int deleteById(Long hisxh);
}
