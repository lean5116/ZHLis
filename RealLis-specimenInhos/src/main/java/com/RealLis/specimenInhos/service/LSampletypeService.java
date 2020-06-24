package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.Formatter;
import com.RealLis.specimenInhos.domain.LSampletype;

import java.util.List;

public interface LSampletypeService {
    public List<Formatter> getLSampleTypeFormatter(LSampletype lSampletype);
}
