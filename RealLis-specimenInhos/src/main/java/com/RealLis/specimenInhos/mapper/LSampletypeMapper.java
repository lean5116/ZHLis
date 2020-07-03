package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.LSampletype;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LSampletypeMapper {
    List<LSampletype> queryLSampleType(LSampletype lSampletype);
}
