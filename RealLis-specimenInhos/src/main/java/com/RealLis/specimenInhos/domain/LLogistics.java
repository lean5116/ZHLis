package com.RealLis.specimenInhos.domain;


import com.RealLis.common.core.domain.BaseEntity;
import java.util.Date;

public class LLogistics extends BaseEntity {

  private String wlbh;
  private Date cjsj;
  private Date dbsj;
  private String cjr;
  private String dbr;
  private Date yssj;
  private String ysr;
  private String bqdm;
  private Date ddsj;
  private String bbsl;
  private String wlzt;
  private String bqmc;
  private String qsr;
  private String cjrxm;

  public LLogistics(String wlbh, Date cjsj, Date dbsj, String cjr, String dbr, Date yssj, String ysr, String bqdm, Date ddsj, String bbsl, String wlzt, String bqmc, String qsr) {
    this.wlbh = wlbh;
    this.cjsj = cjsj;
    this.dbsj = dbsj;
    this.cjr = cjr;
    this.dbr = dbr;
    this.yssj = yssj;
    this.ysr = ysr;
    this.bqdm = bqdm;
    this.ddsj = ddsj;
    this.bbsl = bbsl;
    this.wlzt = wlzt;
    this.bqmc = bqmc;
    this.qsr = qsr;
  }

  public LLogistics() {
  }

  public String getWlbh() {
    return wlbh;
  }

  public void setWlbh(String wlbh) {
    this.wlbh = wlbh;
  }

  public Date getCjsj() {
    return cjsj;
  }

  public void setCjsj(Date cjsj) {
    this.cjsj = cjsj;
  }

  public Date getDbsj() {
    return dbsj;
  }

  public void setDbsj(Date dbsj) {
    this.dbsj = dbsj;
  }

  public String getCjr() {
    return cjr;
  }

  public void setCjr(String cjr) {
    this.cjr = cjr;
  }

  public String getDbr() {
    return dbr;
  }

  public void setDbr(String dbr) {
    this.dbr = dbr;
  }

  public Date getYssj() {
    return yssj;
  }

  public void setYssj(Date yssj) {
    this.yssj = yssj;
  }

  public String getYsr() {
    return ysr;
  }

  public void setYsr(String ysr) {
    this.ysr = ysr;
  }

  public String getBqdm() {
    return bqdm;
  }

  public void setBqdm(String bqdm) {
    this.bqdm = bqdm;
  }

  public Date getDdsj() {
    return ddsj;
  }

  public void setDdsj(Date ddsj) {
    this.ddsj = ddsj;
  }

  public String getBbsl() {
    return bbsl;
  }

  public void setBbsl(String bbsl) {
    this.bbsl = bbsl;
  }

  public String getWlzt() {
    return wlzt;
  }

  public void setWlzt(String wlzt) {
    this.wlzt = wlzt;
  }

  public String getBqmc() {
    return bqmc;
  }

  public void setBqmc(String bqmc) {
    this.bqmc = bqmc;
  }

  public String getQsr() {
    return qsr;
  }

  public void setQsr(String qsr) {
    this.qsr = qsr;
  }

  public String getCjrxm() {
    return cjrxm;
  }

  public void setCjrxm(String cjrxm) {
    this.cjrxm = cjrxm;
  }
}
