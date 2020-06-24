package com.RealLis.specimenInhos.service.impl;

import com.RealLis.specimenInhos.domain.ViLisBarcodeInfo;
import com.RealLis.specimenInhos.mapper.ViLisBarcodeInfoMapper;
import com.RealLis.specimenInhos.service.IViLisBarcodeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ViLisBarcodeInfoServiceImpl implements IViLisBarcodeInfoService {
    @Autowired
    private ViLisBarcodeInfoMapper viLisBarcodeInfoMapper;
    @Override
    public List<ViLisBarcodeInfo> selectBarcodeList(ViLisBarcodeInfo viLisBarcodeInfo) {
        return viLisBarcodeInfoMapper.queryAll(viLisBarcodeInfo);
    }

    @Override
    public ViLisBarcodeInfo getInfoByBarcode(ViLisBarcodeInfo viLisBarcodeInfo) {
        return viLisBarcodeInfoMapper.getInfoByBarcode(viLisBarcodeInfo);
    }
}
