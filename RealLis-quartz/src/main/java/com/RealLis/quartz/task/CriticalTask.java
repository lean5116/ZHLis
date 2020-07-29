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
import org.junit.Test;
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

    @Test
    public void criticalHis2Lis() {
        List<LTsxxTr> lTsxxTrList = lTsxxTrHisService.getAll();
        logger.info("检索his库tr表得到~" + lTsxxTrList.toArray().toString());
        if (lTsxxTrList != null) {                                                                                         //如果tr中间表不为空
            for (LTsxxTr ltsxxTr : lTsxxTrList                                                                          //开始轮循
            ) {
                logger.info("中间表：" + "~" + ltsxxTr.toString() +"操作开始~");
                //通过his'xh关联 tr表xh即是lis表 his'xh
                LTsxxHis lTsxxHis = lTsxxHisService.getByXh(ltsxxTr.getXh());

                if (lTsxxHis == null) {                                                                                     //若his表检索不到该xh信息，则为无效数据，删除
                    if (lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                        logger.info(ltsxxTr.getXh() + "his 未检索到 TR表 记录删除成功");
                    }
                    continue;
                }
                logger.info("xh检索his库tsxx表，入参：" + ltsxxTr.getXh() + "~出参：" + lTsxxHis.toString());
                LTsxxLis lTsxxLisParam = new LTsxxLis();                                                                                          //确保该xh存在数据
                BeanUtils.copyBeanProp(lTsxxLisParam, lTsxxHis);                                                    //实体类数据复制 从his到lis入参类
                lTsxxLisParam.setHisxh(lTsxxHis.getXh());
                logger.info("组装lis入参：" + lTsxxLisParam.toString());
                //region 如果his表的lisxh = -1  执行插入操作
                if ( -1==lTsxxHis.getLisxh() ) {
                    LTsxxLis judge = lTsxxLisService.getByHisxh(lTsxxHis.getXh());
                    if (judge == null) {
                        int i = 0;
                        try {
                            logger.info("lis库不存在该his记录，执行插入操作；lis插入入参:" + lTsxxLisParam.toString());
                            i = lTsxxLisService.insert(lTsxxLisParam);
                        } catch (Exception e) {
                            logger.info("lis库插入异常");
                        }
                        if (i > 0) {
                            logger.info(lTsxxLisParam.getHisxh() + "记录插入成功 lis");
                            if (lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                                logger.info(lTsxxLisParam.getHisxh() + " TR表 记录删除成功 his");
                            }
                        }
                    } else {
                        logger.info("his库lisxh为-1,通过his的xh查询lis的hisxh;检索条件 getByHisxh;lis入参：" + lTsxxHis.getXh() + "~lis出参:" + judge.toString());
                        logger.info("lis中已经存在hisxh为" + lTsxxHis.getXh() + "的记录，执行update");
                        lTsxxLisParam.setXh(judge.getXh());
                        if (lTsxxHis.toString().equals(judge.toString())) {
                            logger.info("his数据与lis数据完全相同，不执行update~" + lTsxxHis.toString()+"但是由于lisxh为-1,update lisxh");
                            if (lTsxxLisService.updateByXh(lTsxxLisParam) > 0) {
                                logger.info(lTsxxLisParam.getHisxh() + "记录修改成功 lis入参"+lTsxxLisParam.toString());
                                if (lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {                                   //操作成功删删除tr表数据
                                    logger.info(lTsxxLisParam.getHisxh() + " TR表 记录删除成功 his");
                                }
                            }
                        } else {
                            logger.info("his数据与lis数据不完全完全相同，执行update~；his数据:" + lTsxxHis.toString() + "~lis数据:" + judge.toString());
                            if (lTsxxLisService.updateByXh(lTsxxLisParam) > 0) {
                                logger.info(lTsxxLisParam.getHisxh() + "记录修改成功 lis入参"+lTsxxLisParam.toString());
                                if (lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {                                   //操作成功删删除tr表数据
                                    logger.info(lTsxxLisParam.getHisxh() + " TR表 记录删除成功 his");
                                }
                            }
                        }
                    }
                } else {
                    LTsxxLis lTsxxLis = lTsxxLisService.getByxh(lTsxxHis.getLisxh());
                    lTsxxLisParam.setXh(lTsxxHis.getLisxh());
                    logger.info("his库lisxh不为-1,通过his的lisxh查询lis的xh;检索条件 getxh;lis入参：" + lTsxxHis.getLisxh() + "~lis出参:" + lTsxxLis.toString());
                    if (lTsxxLis != null) {
                        logger.info("lis出参不为空，开始执行相关操作");
                        if ("INSERT".equals(ltsxxTr.getEventype()) || "UPDATE".equals(ltsxxTr.getEventype())) {
                            logger.info("中间表参数" + ltsxxTr.getEventype() + "，执行" + ltsxxTr.getEventype() + "操作");
                            if (lTsxxHis.toString().equals(lTsxxLis.toString())) {
                                logger.info("his数据与lis数据完全相同，不执行update~" + lTsxxHis.toString());
                                if(-1==lTsxxLis.getHisxh()){
                                    if (lTsxxLisService.updateByXh(lTsxxLisParam) > 0) {
                                        logger.info(lTsxxLisParam.getHisxh() + "记录修改成功 lis");
                                        if (lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {                                   //操作成功删删除tr表数据
                                            logger.info(lTsxxLisParam.getHisxh() + " TR表 记录删除成功 his");
                                        }
                                    }
                                }
                                if (lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {                                   //操作成功删删除tr表数据
                                    logger.info(lTsxxLisParam.getHisxh() + " TR表 记录删除成功 his");
                                }
                            } else {
                                logger.info("his数据与lis数据不完全完全相同，执行update~；his数据:" + lTsxxHis.toString() + "~lis数据:" + lTsxxLis.toString());
                                if (lTsxxLisService.updateByXh(lTsxxLisParam) > 0) {
                                    logger.info(lTsxxLisParam.getHisxh() + "记录修改成功 lis");
                                    if (lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {                                   //操作成功删删除tr表数据
                                        logger.info(lTsxxLisParam.getHisxh() + " TR表 记录删除成功 his");
                                    }
                                }
                            }
                        } else if ("DELETE".equals(ltsxxTr.getEventype())) {
                            logger.info("中间表参数delete，执行delete操作");
                            if (lTsxxLisService.deleteByHisxh(lTsxxLisParam.getHisxh()) > 0) {
                                logger.info(lTsxxLisParam.getHisxh() + "记录删除成功 lis");
                                if (lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                                    logger.info(lTsxxLisParam.getHisxh() + " TR表 记录删除成功 his");
                                }
                            }
                        }
                        List<LTsmx> lTsmxHisList = lTsmxHisService.getBySampleno(lTsxxHis.getBbbh());
                        if (lTsmxHisList != null) {
                            if (lTsmxHisList.size() > 0) {
                                logger.info(lTsmxLisService.deleteBySampleno(lTsxxHis.getBbbh()) + "~lis表tsmx 删除数据");
                                for (LTsmx lTsmx : lTsmxHisList
                                ) {
                                    if (lTsmxLisService.insert(lTsmx) > 0) {
                                        logger.info(lTsmx.toString() + "~lis表tsmx数据插入成功");
                                    }
                                }
                            }
                        }
                    } else {
                        logger.info("lis出参为空，开始执行默认insert操作~" +lTsxxLisParam.toString());
                        int i = 0;
                        try {
                            i = lTsxxLisService.insert(lTsxxLisParam);
                        } catch (Exception e) {
                            logger.info("lis插入出错"+lTsxxLisParam.toString());
                        }
                        if (i > 0) {
                            logger.info(lTsxxLisParam.getHisxh() + "记录插入成功 lis");
                            if (lTsxxTrHisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                                logger.info(lTsxxLisParam.getHisxh() + " TR表 记录删除成功 his");
                            }
                        }
                    }
                }
                logger.info("中间表：" + "~" + ltsxxTr.toString() +"操作结束~");
            }
        }
    }

    @Test
    public void criticalLis2His() {
        List<LTsxxTr> lTsxxTrList = lTsxxTrLisService.getAll();
        logger.info("检索his库tr表得到~" + lTsxxTrList.toArray().toString());
        if (lTsxxTrList != null) {                                                                                         //如果tr中间表不为空
            for (LTsxxTr ltsxxTr : lTsxxTrList                                                                          //开始轮循
            ) {
                logger.info("中间表：" + "~" + ltsxxTr.toString() +"操作开始~");
                LTsxxLis lTsxxLis = lTsxxLisService.getByxh(ltsxxTr.getXh());
                logger.info("xh检索lis库tsxx表，入参：" + ltsxxTr.getXh() + "~出参：" + lTsxxLis.toString());
                if (lTsxxLis == null) {                                                                                    //若lis表检索不到该xh信息，则为无效数据，删除
                    if (lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                        logger.info(ltsxxTr.getXh() + " lis 未检索到 ，TR表 记录删除成功");
                    }
                    continue;
                }
                LTsxxHis lTsxxHisParam = new LTsxxHis();
                BeanUtils.copyBeanProp(lTsxxHisParam, lTsxxLis);                                                    //实体类复制从lis到his入参类
                lTsxxHisParam.setLisxh(lTsxxLis.getXh());
                logger.info("组装his入参：" + lTsxxHisParam.toString());
                if  (-1==lTsxxLis.getHisxh() ) {
                    LTsxxHis judge = lTsxxHisService.getByLisxh(lTsxxLis.getXh());

                    if (judge == null) {
                        int i = 0;
                        try {
                            logger.info("His库不存在该lis记录，执行插入操作；his插入入参:" + lTsxxHisParam.toString());
                            i = lTsxxHisService.insert(lTsxxHisParam);
                        } catch (Exception e) {
                            logger.info("his库插入异常");
                        }
                        if (i > 0) {
                            logger.info(lTsxxHisParam.getLisxh() + "记录插入成功 his");
                            if (lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                                logger.info(lTsxxHisParam.getLisxh() + " TR表 记录删除成功 lis");
                            }
                        }
                    } else {
                        logger.info("lis库hisxh为-1,通过lis的xh查询his的lisxh;检索条件 getByLisxh;His入参：" + lTsxxLis.getXh() + "~His出参:" + judge.toString());
                        logger.info("his中已经存在lisxh为" + lTsxxLis.getXh() + "的记录，执行update");
                        lTsxxHisParam.setXh(judge.getXh());
                        if (lTsxxLis.toString().equals(judge.toString())) {
                            logger.info("lis表数据与his完全相同，不执行update~" + lTsxxLis.toString());
                            if (lTsxxHisService.updateByXh(lTsxxHisParam) > 0) {
                                logger.info(lTsxxHisParam.getLisxh() + "记录修改成功 his入参~" + lTsxxHisParam.toString());
                                if (lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {                                   //操作成功删删除tr表数据
                                    logger.info(lTsxxHisParam.getLisxh() + " TR表 记录删除成功 his");
                                }
                            }
                        } else {
                            logger.info("lis数据与his数据不完全完全相同，执行update~；lis数据:" + lTsxxLis.toString() + "~his数据:" + judge.toString());
                            if (lTsxxHisService.updateByXh(lTsxxHisParam) > 0) {
                                logger.info(lTsxxHisParam.getLisxh() + "记录修改成功 his入参~" + lTsxxHisParam.toString());
                                if (lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {                                   //操作成功删删除tr表数据
                                    logger.info(lTsxxHisParam.getLisxh() + " TR表 记录删除成功 his");
                                }
                            }
                        }
                    }
                } else {
                    LTsxxHis lTsxxHis = lTsxxHisService.getByXh(lTsxxLis.getHisxh());
              //      logger.info("lis库lisxh不为-1,通过lis的hisxh查询his的xh;检索条件 getByXh;his入参：" + lTsxxLis.getHisxh() + "~his出参:" + lTsxxHis.toString());
                    lTsxxHisParam.setXh(lTsxxLis.getHisxh());
                    if (lTsxxHis != null) {
                        logger.info("his出参不为空，开始执行相关操作");
                        if ("INSERT".equals(ltsxxTr.getEventype()) || "UPDATE".equals(ltsxxTr.getEventype())) {
                            logger.info("中间表参数" + ltsxxTr.getEventype() + "，执行" + ltsxxTr.getEventype() + "操作");
                            if (lTsxxLis.toString().equals(lTsxxHis.toString())) {
                                logger.info("lis数据与his完全相同不执行update~"+lTsxxHis.toString());
                                if(-1==lTsxxHis.getLisxh()){
                                    if (lTsxxHisService.updateByXh(lTsxxHisParam) > 0) {
                                        logger.info(lTsxxHisParam.getLisxh() + "记录修改成功  his");
                                        if (lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                                            logger.info(lTsxxHisParam.getLisxh() + " TR表 记录删除成功 lis");
                                        }
                                    }
                                }
                                if (lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                                    logger.info(lTsxxHisParam.getLisxh() + " TR表 记录删除成功 lis");
                                }
                            } else {
                                logger.info("his数据与lis数据不完全完全相同，执行update~；his数据:" + lTsxxHis.toString() + "~lis数据:" + lTsxxLis.toString());
                                if (lTsxxHisService.updateByXh(lTsxxHisParam) > 0) {
                                    logger.info(lTsxxHisParam.getLisxh() + "记录修改成功  his");
                                    if (lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                                        logger.info(lTsxxHisParam.getLisxh() + " TR表 记录删除成功 lis");
                                    }
                                }
                            }
                        } else if ("DELETE".equals(ltsxxTr.getEventype())) {
                            logger.info("中间表参数delete，执行delete操作");
                            if (lTsxxHisService.deleteByLisxh(lTsxxHisParam.getLisxh()) > 0) {
                                logger.info(lTsxxHisParam.getLisxh() + "记录删除成功 his");
                                if (lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                                    logger.info(lTsxxHisParam.getLisxh() + " TR表 记录删除成功 lis");
                                }
                            }
                        }
                        List<LTsmx> lTsmxLisList = lTsmxLisService.getBySampleno(lTsxxHis.getBbbh());
                        if (lTsmxLisList != null) {
                            if (lTsmxLisList.size() > 0) {
                                logger.info(lTsmxHisService.deleteBySampleno(lTsxxHis.getBbbh()) + "~his表tsmx 删除数据");
                                for (LTsmx lTsmx : lTsmxLisList
                                ) {
                                    if (lTsmxHisService.insert(lTsmx) > 0) {
                                        logger.info(lTsmx.toString() + "~his表tsmx数据插入成功");
                                    }
                                }
                            }
                        }
                    } else {
                        logger.info("his出参为空，开始执行默认insert操作~"+lTsxxHisParam.toString());
                        int i = 0;
                        try {
                            i = lTsxxHisService.insert(lTsxxHisParam);
                        } catch (Exception e) {
                            logger.info("his插入出错"+lTsxxHisParam.toString());
                        }
                        if (i > 0) {
                            logger.info(lTsxxHisParam.getLisxh() + "记录插入成功 his");
                            if (lTsxxTrLisService.deleteByJlxh(ltsxxTr.getJlxh()) > 0) {
                                logger.info(lTsxxHisParam.getLisxh() + " TR表 记录删除成功 lis");
                            }
                        }
                    }
                }
                logger.info("中间表：" + "~" + ltsxxTr.toString() +"操作结束~");

            }
        }
    }
}
