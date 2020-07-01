package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.PostBack.OBR;
import com.RealLis.specimenInhos.domain.PostBack.ORC;
import com.RealLis.specimenInhos.domain.PostBack.PID;
import com.RealLis.specimenInhos.domain.PostBack.PV1;
import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportPostBackMapper {
    public PID queryPID(String sampleno);
    public PV1 queryPV1(String sampleno);
    public ORC queryORC(String sampleno);
    public List<OBR> queryOBR(String sampleno);
    public List<OBX> queryOBX(String sampleno);
}
