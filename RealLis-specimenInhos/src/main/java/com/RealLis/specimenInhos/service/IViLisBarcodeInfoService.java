package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.ViLisBarcodeInfo;

import java.util.List;

public interface IViLisBarcodeInfoService {
    public List<ViLisBarcodeInfo> getInfoList(ViLisBarcodeInfo viLisBarcodeInfo);
    public ViLisBarcodeInfo getInfo(ViLisBarcodeInfo viLisBarcodeInfo);
}
