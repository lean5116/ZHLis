package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.Formatter;
import com.RealLis.specimenInhos.domain.LSampletype;
import com.RealLis.specimenInhos.mapper.LSampletypeMapper;
import com.RealLis.specimenInhos.service.LSampletypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LSampletypeServiceImpl implements LSampletypeService {
    @Autowired
    private LSampletypeMapper lSampletypeMapper;
    @Override
    public List<Formatter> getLSampleTypeFormatter(LSampletype lSampletype) {
        List<LSampletype> lSampletypes= lSampletypeMapper.queryLSampleType(lSampletype);
        List<Formatter> formatters = new ArrayList<>();
        for (LSampletype lSampletyp:lSampletypes
             ) {
            Formatter formatter = new Formatter();
            formatter.setValue(lSampletyp.getSampletype());
            formatter.setText(lSampletyp.getSampledescribe());
            formatters.add(formatter);
        }
        return formatters;
    }
}
