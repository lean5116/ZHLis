package com.RealLis.dataSync.mapper;


import com.RealLis.dataSync.domain.LTsxxHis;

import java.util.List;

public interface LTsxxHisMapper {
    LTsxxHis queryById(Long xh);
    LTsxxHis queryByLisxh(Long lisxh);
    List<LTsxxHis> queryAllByLimit(Long offset, Long limit);
    List<LTsxxHis>queryAll(LTsxxHis lTsxxHis);
    int insert(LTsxxHis lTsxxHis);
    int update(LTsxxHis lTsxxHis);
    int deleteById(Long xh);
}
