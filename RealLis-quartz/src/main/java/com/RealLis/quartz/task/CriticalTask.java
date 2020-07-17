package com.RealLis.quartz.task;

import com.RealLis.common.utils.bean.BeanUtils;
import com.RealLis.dataSync.domain.LTsmx;
import com.RealLis.dataSync.domain.LTsxxLis;
import com.RealLis.dataSync.domain.LTsxxHis;
import com.RealLis.dataSync.domain.LTsxxTr;
import com.RealLis.dataSync.service.LTsmxService;
import com.RealLis.dataSync.service.LTsxxHisService;
import com.RealLis.dataSync.service.LTsxxLisService;
import com.RealLis.dataSync.service.LTsxxTrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component("CriticalTask")
public class CriticalTask {
    private static final Logger logger = LoggerFactory.getLogger(CriticalTask.class);
    @Autowired
    private LTsxxHisService lTsxxHisService;
    @Autowired
    @Qualifier("LTsxxTrHisService")
    private LTsxxTrService lTsxxTrHisService;
    @Autowired
    @Qualifier("LTsxxTrLisService")
    private LTsxxTrService lTsxxTrLisService;
    @Autowired
    private LTsxxLisService lTsxxLisService;
    @Autowired
    @Qualifier("LTsmxHisService")
    private LTsmxService lTsmxHisService;
    @Autowired
    @Qualifier("LTsmxLisService")
    private LTsmxService lTsmxLisService;

    public void criticalHis2Lis(){
        List<LTsxxTr> lTsxxTrList = lTsxxTrHisService.getAll();                                                         //获取his中间表tr所有数据
        if(lTsxxTrList!=null) {                                                                                         //如果tr中间表不为空
            for (LTsxxTr ltsxxTr : lTsxxTrList                                                                          //开始轮循
            ) {
                LTsxxLis lTsxxLis = lTsxxLisService.getByHisxh(ltsxxTr.getXh());                                        //通过his'xh关联 tr表xh即是lis表 his'xh
                LTsxxHis lTsxxHis = lTsxxHisService.getByXh(ltsxxTr.getXh());                                           //通过xh关联 tr表xh即是his表xh
                if(lTsxxHis==null){                                                                                     //若his表检索不到该xh信息，则为无效数据，删除
                    if(lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh())>0) {
                        logger.info(ltsxxTr.getXh() +"his 未检索到 TR表 记录删除成功");
                    }
                }
                LTsxxLis lTsxxLisParam =  new LTsxxLis();                                                               //拼装lis表入参
                if(lTsxxHis!=null) {                                                                                    //确保该xh存在数据
                    BeanUtils.copyBeanProp(lTsxxLisParam, lTsxxHis);                                                    //实体类数据复制 从his到lis入参类
                    lTsxxLisParam.setHisxh(lTsxxHis.getXh());                                                           //设置lis表his'xh 为his表 xh
                }
                logger.info(lTsxxLisParam.toString());
                if(lTsxxLis !=null){                                                                                    //若lis表检索不到该序号信息则直接插入，否则根据eventType操作
                    if("INSERT".equals(ltsxxTr.getEventype()) || "UPDATE".equals(ltsxxTr.getEventype())){
                        if(lTsxxLisService.updateByHisxh(lTsxxLisParam)>0){
                            logger.info(lTsxxLisParam.getHisxh() +"记录修改成功 lis");
                            if(lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh())>0) {                                   //操作成功删删除tr表数据
                                logger.info(lTsxxLisParam.getHisxh() +" TR表 记录删除成功 his");
                            }
                        }
                    }else if("DELETE".equals(ltsxxTr.getEventype())){
                        if(lTsxxLisService.deleteByHisxh(lTsxxLisParam.getHisxh())>0){
                            logger.info(lTsxxLisParam.getHisxh() +"记录删除成功 lis");
                            if(lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh())>0) {
                                logger.info(lTsxxLisParam.getHisxh() +" TR表 记录删除成功 his");
                            }
                        }
                    }
                    List<LTsmx> lTsmxHisList = lTsmxHisService.getBySampleno(lTsxxHis.getBbbh());
                    if(lTsmxHisList!=null){
                        if(lTsmxHisList.size()>0){
                            logger.info(lTsmxLisService.deleteBySampleno(lTsxxHis.getBbbh())+"~lis表tsmx 删除数据");
                            for (LTsmx lTsmx:lTsmxHisList
                                 ) {
                                if(lTsmxLisService.insert(lTsmx)>0){
                                    logger.info(lTsmx.toString() +"~lis表tsmx数据插入成功");
                                }
                            }
                        }
                    }
                }else {
                    int i=0;
                    try{
                       i= lTsxxLisService.insert(lTsxxLisParam);}
                    catch (Exception e){
                    }
                    if(i>0){
                        logger.info(lTsxxLisParam.getHisxh() +"记录插入成功 lis");
                        if(lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh())>0) {
                            logger.info(lTsxxLisParam.getHisxh() +" TR表 记录删除成功 his");
                        }
                    }
                }
            }
        }
    }


    public void criticalLis2His(){
        List<LTsxxTr> lTsxxTrList = lTsxxTrLisService.getAll();                                                         //获取lis中间表tr所有数据
        if(lTsxxTrList!=null) {                                                                                         //如果tr中间表不为空
            for (LTsxxTr ltsxxTr : lTsxxTrList                                                                          //开始轮循
            ) {
                LTsxxLis lTsxxLis = lTsxxLisService.getByxh(ltsxxTr.getXh());                                           //tr表xh即是lis表xh
                LTsxxHis lTsxxHis = lTsxxHisService.getByLisxh(ltsxxTr.getXh());                                        //tr表xh即是his表lisxh
                if(lTsxxLis ==null){                                                                                    //若lis表检索不到该xh信息，则为无效数据，删除
                    if(lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh())>0) {
                        logger.info(ltsxxTr.getXh() +" lis 未检索到 ，TR表 记录删除成功");
                    }
                }
                LTsxxHis lTsxxHisParam =  new LTsxxHis();
                if(lTsxxLis !=null) {
                    BeanUtils.copyBeanProp(lTsxxHisParam, lTsxxLis);                                                    //实体类复制从lis到his入参类
                    lTsxxHisParam.setLisxh(lTsxxLis.getXh());
                }
                logger.info(lTsxxHisParam.toString());
                if(lTsxxHis!=null){
                    if("INSERT".equals(ltsxxTr.getEventype())||"UPDATE".equals(ltsxxTr.getEventype())){
                        if(lTsxxHisService.updateByLisxh(lTsxxHisParam)>0){
                            logger.info(lTsxxHisParam.getLisxh() +"记录修改成功  his");
                            if(lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh())>0) {
                                logger.info(lTsxxHisParam.getLisxh() +" TR表 记录删除成功 lis");
                            }
                        }
                    }else if("DELETE".equals(ltsxxTr.getEventype())){
                        if(lTsxxHisService.deleteByLisxh(lTsxxHisParam.getLisxh())>0){
                            logger.info(lTsxxHisParam.getLisxh() +"记录删除成功 his");
                            if(lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh())>0) {
                                logger.info(lTsxxHisParam.getLisxh() +" TR表 记录删除成功 lis");
                            }
                        }
                    }
                    List<LTsmx> lTsmxLisList = lTsmxLisService.getBySampleno(lTsxxHis.getBbbh());
                    if(lTsmxLisList!=null){
                        if(lTsmxLisList.size()>0){
                            logger.info(lTsmxHisService.deleteBySampleno(lTsxxHis.getBbbh())+"~his表tsmx 删除数据");
                            for (LTsmx lTsmx:lTsmxLisList
                            ) {
                                if(lTsmxHisService.insert(lTsmx)>0){
                                    logger.info(lTsmx.toString() +"~his表tsmx数据插入成功");
                                }
                            }
                        }
                    }
                }else {
                    int i=0;
                    try{
                        lTsxxHisService.insert(lTsxxHisParam);}
                    catch (Exception e){
                    }
                    if(i>0){
                        logger.info(lTsxxHisParam.getLisxh() +"记录插入成功 his");
                        if(lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh())>0) {
                            logger.info(lTsxxHisParam.getLisxh() +" TR表 记录删除成功 lis");
                        }
                    }
                }
            }
        }
    }
}
