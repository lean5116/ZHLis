package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.Formatter;
import com.RealLis.specimenInhos.domain.LSampletype;

import java.util.List;

public interface LSampletypeService {
    List<Formatter> getLSampleTypeFormatter(LSampletype lSampletype);
}
