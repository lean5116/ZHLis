package com.RealLis.dataSync.domain;


import java.util.Date;
public class LTsxxTr {

  private Long jlxh;
  private Long xh;
  private String eventype;
  private Date jlsj;

  public Long getJlxh() {
    return jlxh;
  }

  public void setJlxh(Long jlxh) {
    this.jlxh = jlxh;
  }

  public Long getXh() {
    return xh;
  }

  public void setXh(Long xh) {
    this.xh = xh;
  }

  public String getEventype() {
    return eventype;
  }

  public void setEventype(String eventype) {
    this.eventype = eventype;
  }

  public Date getJlsj() {
    return jlsj;
  }

  public void setJlsj(Date jlsj) {
    this.jlsj = jlsj;
  }

  public LTsxxTr(Long jlxh, Long xh, String eventype, Date jlsj) {
    this.jlxh = jlxh;
    this.xh = xh;
    this.eventype = eventype;
    this.jlsj = jlsj;
  }

  public LTsxxTr() {
  }
}
