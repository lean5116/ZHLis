package com.RealLis.dataSync.controller;

import com.RealLis.common.core.controller.BaseController;
import com.RealLis.common.utils.bean.BeanUtils;
import com.RealLis.dataSync.domain.LTsxx;
import com.RealLis.dataSync.domain.LTsxxHis;
import com.RealLis.dataSync.domain.LTsxxTr;
import com.RealLis.dataSync.service.LTsxxHisService;
import com.RealLis.dataSync.service.LTsxxService;
import com.RealLis.dataSync.service.LTsxxTrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ltsxx")
public class LTsxxController extends BaseController {
    @Autowired
    private LTsxxHisService lTsxxHisService;
    @Autowired
    @Qualifier("LTsxxTrHisService")
    private LTsxxTrService lTsxxTrHisService;
    @Autowired
    @Qualifier("LTsxxTrLisService")
    private LTsxxTrService lTsxxTrLisService;
    @Autowired
    private LTsxxService lTsxxService;
    @GetMapping("/criticalHis2Lis")
    @ResponseBody
    public String criticalHis2Lis(){
        List<LTsxxTr> lTsxxTrList = lTsxxTrHisService.getAll();
        if(lTsxxTrList!=null) {
            for (LTsxxTr ltsxxTr : lTsxxTrList
            ) {
                LTsxx lTsxx  = lTsxxService.getByHisxh(ltsxxTr.getXh());
                LTsxxHis lTsxxHis = lTsxxHisService.getByXh(ltsxxTr.getXh());
                if(lTsxxHis==null){
                    if(lTsxxTrHisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                        logger.info(ltsxxTr.getXh() +" TR表 记录删除成功");
                    }
                }
                LTsxx ltSxxParam =  new LTsxx();
                if(lTsxxHis!=null) {
                    BeanUtils.copyBeanProp(ltSxxParam, lTsxxHis);
                    ltSxxParam.setHisxh(lTsxxHis.getXh());
                }
                if(lTsxx!=null){
                    switch (ltsxxTr.getEventype()){
                        case "INSERT":
                            int k = lTsxxService.updateByHisxh(ltSxxParam);
                            if(k>0){
                                logger.info(ltSxxParam.getHisxh() +"记录修改成功");
                                if(lTsxxTrHisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                                    logger.info(ltSxxParam.getHisxh() +" TR表 记录删除成功");
                                }
                            }
                            break;
                        case "UPDATE":
                            int i = lTsxxService.updateByHisxh(ltSxxParam);
                            if(i>0){
                                logger.info(ltSxxParam.getHisxh() +"记录修改成功");
                                if(lTsxxTrHisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                                    logger.info(ltSxxParam.getHisxh() +" TR表 记录删除成功");
                                }
                            }
                            break;
                        case "DELETE":
                            int j = lTsxxService.deleteByHisxh(ltSxxParam.getHisxh());
                            if(j>0){
                                logger.info(ltSxxParam.getHisxh() +"记录删除成功");
                                if(lTsxxTrHisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                                    logger.info(ltSxxParam.getHisxh() +" TR表 记录删除成功");
                                }
                            }
                            break;
                    }
                }else {
                    int i=0;
                    try{
                    lTsxxService.insert(ltSxxParam);}
                    catch (Exception e){
                    }
                    if(i>0){
                        logger.info(ltSxxParam.getHisxh() +"记录插入成功");
                        if(lTsxxTrHisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                            logger.info(ltSxxParam.getHisxh() +" TR表 记录删除成功");
                        }
                    }
                }
            }
        }
        return "同步完成";
    }

    @GetMapping("/criticalLis2His")
    @ResponseBody
    public String criticalLis2His(){
        List<LTsxxTr> lTsxxTrList = lTsxxTrLisService.getAll();
        if(lTsxxTrList!=null) {
            for (LTsxxTr ltsxxTr : lTsxxTrList
            ) {
                LTsxx lTsxx  = lTsxxService.getByxh(ltsxxTr.getXh());
                LTsxxHis lTsxxHis = lTsxxHisService.getByLisxh(ltsxxTr.getXh());
                if(lTsxx==null){
                    if(lTsxxTrLisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                        logger.info(ltsxxTr.getXh() +" lis 未检索到 ，TR表 记录删除成功");
                    }
                }
                LTsxxHis ltSxxParam =  new LTsxxHis();
                if(lTsxx!=null) {
                    BeanUtils.copyBeanProp(ltSxxParam, lTsxx);
                    ltSxxParam.setLisxh(lTsxx.getXh());
                }
                if(lTsxxHis!=null){
                    switch (ltsxxTr.getEventype()){
                        case "INSERT":
                            int k = lTsxxHisService.updateByLisxh(ltSxxParam);
                            if(k>0){
                                logger.info(ltSxxParam.getLisxh() +"记录修改成功");
                                if(lTsxxTrLisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                                    logger.info(ltSxxParam.getLisxh() +" TR表 记录删除成功");
                                }
                            }
                            break;
                        case "UPDATE":
                            int i = lTsxxHisService.updateByLisxh(ltSxxParam);
                            if(i>0){
                                logger.info(ltSxxParam.getLisxh() +"记录修改成功");
                                if(lTsxxTrLisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                                    logger.info(ltSxxParam.getLisxh() +" TR表 记录删除成功");
                                }
                            }
                            break;
                        case "DELETE":
                            int j = lTsxxHisService.deleteByLisxh(ltSxxParam.getLisxh());
                            if(j>0){
                                logger.info(ltSxxParam.getLisxh() +"记录删除成功");
                                if(lTsxxTrLisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                                    logger.info(ltSxxParam.getLisxh() +" TR表 记录删除成功");
                                }
                            }
                            break;
                    }
                }else {
                    int i=0;
                    try{
                        lTsxxHisService.insert(ltSxxParam);}
                    catch (Exception e){
                    }
                    if(i>0){
                        logger.info(ltSxxParam.getLisxh() +"记录插入成功");
                        if(lTsxxTrLisService.deleteByHisxh(ltsxxTr.getJlxh())>0) {
                            logger.info(ltSxxParam.getLisxh() +" TR表 记录删除成功");
                        }
                    }
                }
            }
        }
        return "同步完成";
    }
}