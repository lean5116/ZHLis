package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.GyHyxm;
import com.RealLis.specimenInhos.domain.GyKsdm;
import com.RealLis.specimenInhos.domain.ViLisBarcodeInfo;

import java.util.List;

public interface IViLisBarcodeInfoService {
    List<ViLisBarcodeInfo> getInfoList(ViLisBarcodeInfo viLisBarcodeInfo);
    List<ViLisBarcodeInfo> getInfoListWard(ViLisBarcodeInfo viLisBarcodeInfo);
    ViLisBarcodeInfo getInfo(ViLisBarcodeInfo viLisBarcodeInfo);
    List<GyHyxm> queryHyxm();
    GyKsdm getKsdmByKsdm(String ksdm);
}
