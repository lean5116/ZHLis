package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.PostBack.*;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.ZMIC;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.germOBX;
import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.*;
import com.RealLis.specimenInhos.mapper.ReportPostBackMapper;
import com.RealLis.specimenInhos.service.ReportPostBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<ZMIC> getGermZMICBySampleno(String sampleno) {
        return reportPostBackMapper.queryGermZMIC(sampleno);
    }

    @Override
    public List<germOBX> getGermOBXBySampleno(String sampleno) {
        return reportPostBackMapper.queryGermOBX(sampleno);
    }

    @Override
    public List<PostList> getPostList() {
        return reportPostBackMapper.queryPostList();
    }

    @Override
    public List<PostList> getPostListAll() {
        return reportPostBackMapper.queryPostListAll();
    }

    @Override
    public List<PostList> getPostListHistory(Map<String,Object> param){
        return reportPostBackMapper.queryPostListHistory( param);
    }
    @Override
    public int deletePostList(Long jlxh) {
        return reportPostBackMapper.deletePostList(jlxh);
    }

    @Override
    public int updateTransfer(Long jlxh) {
        return reportPostBackMapper.updateTransfer(jlxh);
    }

    @Override
    public List<String> querySampleNoByPatientId(String patientId) {
        return reportPostBackMapper.querySampleNoByPatientId(patientId);
    }
}
