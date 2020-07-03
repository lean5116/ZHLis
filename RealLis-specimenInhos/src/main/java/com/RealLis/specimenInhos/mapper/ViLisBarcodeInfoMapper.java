package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.ViLisBarcodeInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViLisBarcodeInfoMapper {
    List<ViLisBarcodeInfo> queryInfoList(ViLisBarcodeInfo viLisBarcodeInfo);
    ViLisBarcodeInfo queryInfo(ViLisBarcodeInfo viLisBarcodeInfo);
}
