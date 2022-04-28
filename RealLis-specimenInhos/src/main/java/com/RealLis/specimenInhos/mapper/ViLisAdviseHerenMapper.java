package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.ViLisAdviseHeren;

import java.util.List;

public interface ViLisAdviseHerenMapper {
    List<ViLisAdviseHeren> queryDistinctAdviseList(ViLisAdviseHeren viLisAdviseHerenis);

    List<ViLisAdviseHeren> queryDistinctAdviseListNew(ViLisAdviseHeren viLisAdviseHerenis);
}
