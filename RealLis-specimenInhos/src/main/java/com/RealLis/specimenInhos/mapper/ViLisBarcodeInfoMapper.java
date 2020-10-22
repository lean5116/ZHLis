package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.GyHyxm;
import com.RealLis.specimenInhos.domain.GyKsdm;
import com.RealLis.specimenInhos.domain.ViLisBarcodeInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViLisBarcodeInfoMapper {
    List<ViLisBarcodeInfo> queryInfoList(ViLisBarcodeInfo viLisBarcodeInfo);
    List<ViLisBarcodeInfo> queryInfoListWard(ViLisBarcodeInfo viLisBarcodeInfo);
    ViLisBarcodeInfo queryInfo(ViLisBarcodeInfo viLisBarcodeInfo);
    List<GyHyxm> queryHyxm();
    GyKsdm queryKsdmByKsdm(String ksdm);
}
