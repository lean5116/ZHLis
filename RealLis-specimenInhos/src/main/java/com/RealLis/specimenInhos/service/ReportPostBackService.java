package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.PostBack.*;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.ZMIC;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.germOBX;
import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.*;

import java.util.List;
import java.util.Map;

public interface ReportPostBackService {
    PID getPIDbySampleno(String sampleno);
    PV1 getPV1bySampleno(String sampleno);
    ORC getORCbySampleno(String sampleno);
    List<OBR> getOBRbySampleno(String sampleno);
    List<OBX> getOBXbySampleno(String sampleno);

    List<ZMIC> getGermZMICBySampleno(String sampleno);
    List<germOBX> getGermOBXBySampleno(String sampleno);

    List<PostList> getPostList();
    List<PostList> getPostListAll();
    List<PostList> getPostListHistory(Map<String,Object> param);
    int deletePostList(Long jlxh);
    int updateTransfer(Long jlxh);
    List<String> querySampleNoByPatientId(String patientId);
}
