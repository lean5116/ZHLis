package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.ReturnAudit.auditBody;
import com.RealLis.specimenInhos.mapper.ReturnAuditMapper;
import com.RealLis.specimenInhos.service.ReturnAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnAuditServiceImpl implements ReturnAuditService {
    @Autowired
    private ReturnAuditMapper returnAuditMapper;

    @Override
    public List<auditBody> getAudit() {
        return returnAuditMapper.queryAll();
    }

    @Override
    public int deleteByJlxh(Long jlxh) {
        return returnAuditMapper.delete(jlxh);
    }
}
