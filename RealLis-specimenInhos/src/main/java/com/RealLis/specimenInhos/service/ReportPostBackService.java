package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.PostBack.*;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.ZMIC;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.germOBX;
import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.*;

import java.util.List;

public interface ReportPostBackService {
    PID getPIDbySampleno(String sampleno);
    PV1 getPV1bySampleno(String sampleno);
    ORC getORCbySampleno(String sampleno);
    List<OBR> getOBRbySampleno(String sampleno);
    List<OBX> getOBXbySampleno(String sampleno);

    List<ZMIC> getGermZMICBySampleno(String sampleno);
    List<germOBX> getGermOBXBySampleno(String sampleno);

    List<PostList> getPostList();
    int deletePostList(Long jlxh);
    int updateTransfer(Long jlxh);
}
