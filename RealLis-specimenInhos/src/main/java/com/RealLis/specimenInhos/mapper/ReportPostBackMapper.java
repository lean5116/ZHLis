package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.PostBack.*;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.ZMIC;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.germOBX;
import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportPostBackMapper {
    PID queryPID(String sampleno);
    PV1 queryPV1(String sampleno);
    ORC queryORC(String sampleno);
    List<OBR> queryOBR(String sampleno);
    List<OBX> queryOBX(String sampleno);

    List<ZMIC> queryGermZMIC(String sampleno);
    List<germOBX> queryGermOBX(String sampleno);

    List<PostList> queryPostList();
    int deletePostList(Long jlxh);
}
