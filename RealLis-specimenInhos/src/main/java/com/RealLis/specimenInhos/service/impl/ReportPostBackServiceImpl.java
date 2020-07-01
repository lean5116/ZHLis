package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.PostBack.OBR;
import com.RealLis.specimenInhos.domain.PostBack.ORC;
import com.RealLis.specimenInhos.domain.PostBack.PID;
import com.RealLis.specimenInhos.domain.PostBack.PV1;
import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.*;
import com.RealLis.specimenInhos.mapper.ReportPostBackMapper;
import com.RealLis.specimenInhos.service.ReportPostBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportPostBackServiceImpl implements ReportPostBackService {
    @Autowired
    private ReportPostBackMapper reportPostBackMapper;
    @Override
    public PID getPIDbySampleno(String sampleno) {
        return reportPostBackMapper.queryPID(sampleno);
    }

    @Override
    public PV1 getPV1bySampleno(String sampleno) {
        return reportPostBackMapper.queryPV1(sampleno);
    }

    @Override
    public ORC getORCbySampleno(String sampleno) {
        return reportPostBackMapper.queryORC(sampleno);
    }

    @Override
    public List<OBR> getOBRbySampleno(String sampleno) {
        return reportPostBackMapper.queryOBR(sampleno);
    }

    @Override
    public List<OBX> getOBXbySampleno(String sampleno) {
        return reportPostBackMapper.queryOBX(sampleno);
    }
}
