package com.RealLis.specimenInhos.service.impl;

import com.RealLis.common.utils.DateUtils;
import com.RealLis.specimenInhos.domain.GyHyxm;
import com.RealLis.specimenInhos.domain.GyKsdm;
import com.RealLis.specimenInhos.domain.ViLisBarcodeInfo;
import com.RealLis.specimenInhos.mapper.ViLisBarcodeInfoMapper;
import com.RealLis.specimenInhos.service.IViLisBarcodeInfoService;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ViLisBarcodeInfoServiceImpl implements IViLisBarcodeInfoService {
    @Autowired
    private ViLisBarcodeInfoMapper viLisBarcodeInfoMapper;
    @Override
    public List<ViLisBarcodeInfo> getInfoList(ViLisBarcodeInfo viLisBarcodeInfo) {
        return viLisBarcodeInfoMapper.queryInfoList(viLisBarcodeInfo);
    }

    @Override
    public List<ViLisBarcodeInfo> getInfoListWard(ViLisBarcodeInfo viLisBarcodeInfo) {
        return viLisBarcodeInfoMapper.queryInfoListWard(viLisBarcodeInfo);
    }

    @Override
    public List<ViLisBarcodeInfo> getInfoInfect(ViLisBarcodeInfo viLisBarcodeInfo) {
        return viLisBarcodeInfoMapper.queryInfoListInfect(viLisBarcodeInfo);
    }

    @Override
    public ViLisBarcodeInfo getInfo(String barcode) {
        ViLisBarcodeInfo params = new ViLisBarcodeInfo();
        String bar = (DateUtils.dateTimeNow()).substring(2);
        params.setBarcode2(bar + barcode);
        ViLisBarcodeInfo viLisBarcodeInfo = viLisBarcodeInfoMapper.queryInfo(params);
        if(viLisBarcodeInfo!=null){
            return viLisBarcodeInfo;
        }else{
            String lastYear = DateUtils.parseDateToStr(DateUtils.YYYYMMDDHHMMSS,DateUtils.addDays(DateUtils.getNowDate(),-1));
            bar = lastYear.substring(2);
            params.setBarcode2(bar + barcode);
            viLisBarcodeInfo = viLisBarcodeInfoMapper.queryInfo(params);
            return viLisBarcodeInfo;
        }

    }

    @Override
    public List<GyHyxm> queryHyxm() {
        return viLisBarcodeInfoMapper.queryHyxm();
    }

    @Override
    public GyKsdm getKsdmByKsdm(String ksdm) {
        return viLisBarcodeInfoMapper.queryKsdmByKsdm(ksdm);
    }
}
