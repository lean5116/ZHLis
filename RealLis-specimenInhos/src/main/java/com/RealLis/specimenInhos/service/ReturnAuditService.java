package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.ReturnAudit.auditBody;

import java.util.List;

public interface ReturnAuditService {
    List<auditBody> getAudit();
    int deleteByJlxh(Long jlxh);
}
