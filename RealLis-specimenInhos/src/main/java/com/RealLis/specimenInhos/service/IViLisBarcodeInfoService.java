package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.SysConfig;
import com.RealLis.specimenInhos.domain.ViLisBarcodeInfo;

import java.util.List;

public interface IViLisBarcodeInfoService {
    public List<ViLisBarcodeInfo> selectBarcodeList(ViLisBarcodeInfo viLisBarcodeInfo);
    public ViLisBarcodeInfo getInfoByBarcode(ViLisBarcodeInfo viLisBarcodeInfo);
}
