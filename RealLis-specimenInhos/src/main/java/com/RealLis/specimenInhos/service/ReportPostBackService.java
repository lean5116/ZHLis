package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.PostBack.OBR;
import com.RealLis.specimenInhos.domain.PostBack.ORC;
import com.RealLis.specimenInhos.domain.PostBack.PID;
import com.RealLis.specimenInhos.domain.PostBack.PV1;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.ZMIC;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.germOBX;
import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.*;

import java.util.List;

public interface ReportPostBackService {
    public PID getPIDbySampleno(String sampleno);
    public PV1 getPV1bySampleno(String sampleno);
    public ORC getORCbySampleno(String sampleno);
    public List<OBR> getOBRbySampleno(String sampleno);
    public List<OBX> getOBXbySampleno(String sampleno);

    public List<ZMIC> getGermZMICBySampleno(String sampleno);
    public List<germOBX> getGermOBXBySampleno(String sampleno);
}
