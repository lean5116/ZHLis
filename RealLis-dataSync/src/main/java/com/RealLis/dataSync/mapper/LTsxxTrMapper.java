package com.RealLis.dataSync.mapper;

import com.RealLis.dataSync.domain.LTsxxTr;

import java.util.List;

public interface LTsxxTrMapper {
    LTsxxTr queryById(Long xh);
    List<LTsxxTr> queryAllByLimit(Long offset, Long limit);
    List<LTsxxTr>queryAll(LTsxxTr lTsxxTr);
    int insert(LTsxxTr lTsxxTr);
    int update(LTsxxTr lTsxxTr);
    int deleteById(Long jlxh);
}
