package com.RealLis.specimenInhos.mapper;

import com.RealLis.specimenInhos.domain.ViLisBarcodeInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViLisBarcodeInfoMapper {
    public List<ViLisBarcodeInfo> queryAll(ViLisBarcodeInfo viLisBarcodeInfo);
    public ViLisBarcodeInfo getInfoByBarcode(ViLisBarcodeInfo viLisBarcodeInfo);
}
