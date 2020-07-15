package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.ViLisAdviseHeren;

import java.util.List;

public interface ViLisAdviseHerenService {
    List<ViLisAdviseHeren> getDistinctAdviseList(ViLisAdviseHeren viLisAdviseHerenis);
}
