package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.ViLisAdviseHeren;
import com.RealLis.specimenInhos.mapper.ViLisAdviseHerenMapper;
import com.RealLis.specimenInhos.service.ViLisAdviseHerenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ViLisAdviseHerenServiceImpl implements ViLisAdviseHerenService {
    @Autowired
    private ViLisAdviseHerenMapper viLisAdviseHerenMapper;
    @Override
    public List<ViLisAdviseHeren> getDistinctAdviseList(ViLisAdviseHeren viLisAdviseHerenis) {
        return viLisAdviseHerenMapper.queryDistinctAdviseList(viLisAdviseHerenis);
    }

    @Override
    public List<ViLisAdviseHeren> getDistinctAdviseListNew(ViLisAdviseHeren viLisAdviseHerenis) {
        return viLisAdviseHerenMapper.queryDistinctAdviseListNew(viLisAdviseHerenis);
    }
}
