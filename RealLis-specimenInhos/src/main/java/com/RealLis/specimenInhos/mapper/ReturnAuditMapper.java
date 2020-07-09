package com.RealLis.specimenInhos.mapper;


import com.RealLis.specimenInhos.domain.ReturnAudit.auditBody;

import java.util.List;


public interface ReturnAuditMapper {
    List<auditBody> queryAll();
    int delete(Long jlxh);
}
