package com.RealLis.specimenInhos.service;

import com.RealLis.specimenInhos.domain.GyHyxm;
import com.RealLis.specimenInhos.domain.GyKsdm;
import com.RealLis.specimenInhos.domain.ViLisBarcodeInfo;

import java.util.List;

public interface IViLisBarcodeInfoService {
    List<ViLisBarcodeInfo> getInfoList(ViLisBarcodeInfo viLisBarcodeInfo);
    List<ViLisBarcodeInfo> getInfoListWard(ViLisBarcodeInfo viLisBarcodeInfo);
    List<ViLisBarcodeInfo> getInfoInfect(ViLisBarcodeInfo viLisBarcodeInfo);
    ViLisBarcodeInfo getInfo(String barcode);
    List<GyHyxm> queryHyxm();
    GyKsdm getKsdmByKsdm(String ksdm);
}
