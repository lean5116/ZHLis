package com.RealLis.specimenInhos.domain;


import com.RealLis.common.core.domain.BaseEntity;

import java.util.Date;

public class ViLisBarcodeInfo extends BaseEntity {

  private String barcode;
  private String barcode2;
  private String requestmode;
  private String requestdoctor;
  private Date requettime;
  private String department;
  private String bednum;
  private String patienttype;
  private String patientid;
  private String patientname;
  private String patientsex;
  private Date birthday;
  private String patientage;
  private String ageunit;
  private String specimencode;
  private String barclass;
  private String examcode;
  private String examname;
  private String cost;
  private String coststatus;
  private Date samplingtime;
  private String samplingdoctor;
  private Date receivertime;
  private String labdoctor;
  private String barstatus;
  private String canceler;
  private Date canceltime;
  private String diagnostic;
  private Date startRequettime;
  private Date endRequettime;
  private Date startReceivertime;
  private Date endReceivertime;
  private Date startSamplingtime;
  private Date endSamplingtime;
  private String overTime;
  private String sampleState;
  private String searchValue;
  private String tube;
  private String receiveaddr;
  private String hyxm;
  private String departmentName;

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getHyxm() {
    return hyxm;
  }

  public void setHyxm(String hyxm) {
    this.hyxm = hyxm;
  }


  public String getTube() {
    return tube;
  }

  public void setTube(String tube) {
    this.tube = tube;
  }

  public String getReceiveaddr() {
    return receiveaddr;
  }

  public void setReceiveaddr(String receiveaddr) {
    this.receiveaddr = receiveaddr;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getBarcode2() {
    return barcode2;
  }

  public void setBarcode2(String barcode2) {
    this.barcode2 = barcode2;
  }

  public String getRequestmode() {
    return requestmode;
  }

  public void setRequestmode(String requestmode) {
    this.requestmode = requestmode;
  }

  public String getRequestdoctor() {
    return requestdoctor;
  }

  public void setRequestdoctor(String requestdoctor) {
    this.requestdoctor = requestdoctor;
  }

  public Date getRequettime() {
    return requettime;
  }

  public void setRequettime(Date requettime) {
    this.requettime = requettime;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getBednum() {
    return bednum;
  }

  public void setBednum(String bednum) {
    this.bednum = bednum;
  }

  public String getPatienttype() {
    return patienttype;
  }

  public void setPatienttype(String patienttype) {
    this.patienttype = patienttype;
  }

  public String getPatientid() {
    return patientid;
  }

  public void setPatientid(String patientid) {
    this.patientid = patientid;
  }

  public String getPatientname() {
    return patientname;
  }

  public void setPatientname(String patientname) {
    this.patientname = patientname;
  }

  public String getPatientsex() {
    return patientsex;
  }

  public void setPatientsex(String patientsex) {
    this.patientsex = patientsex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getPatientage() {
    return patientage;
  }

  public void setPatientage(String patientage) {
    this.patientage = patientage;
  }

  public String getAgeunit() {
    return ageunit;
  }

  public void setAgeunit(String ageunit) {
    this.ageunit = ageunit;
  }

  public String getSpecimencode() {
    return specimencode;
  }

  public void setSpecimencode(String specimencode) {
    this.specimencode = specimencode;
  }

  public String getBarclass() {
    return barclass;
  }

  public void setBarclass(String barclass) {
    this.barclass = barclass;
  }

  public String getExamcode() {
    return examcode;
  }

  public void setExamcode(String examcode) {
    this.examcode = examcode;
  }

  public String getExamname() {
    return examname;
  }

  public void setExamname(String examname) {
    this.examname = examname;
  }

  public String getCost() {
    return cost;
  }

  public void setCost(String cost) {
    this.cost = cost;
  }

  public String getCoststatus() {
    return coststatus;
  }

  public void setCoststatus(String coststatus) {
    this.coststatus = coststatus;
  }

  public Date getSamplingtime() {
    return samplingtime;
  }

  public void setSamplingtime(Date samplingtime) {
    this.samplingtime = samplingtime;
  }

  public String getSamplingdoctor() {
    return samplingdoctor;
  }

  public void setSamplingdoctor(String samplingdoctor) {
    this.samplingdoctor = samplingdoctor;
  }

  public Date getReceivertime() {
    return receivertime;
  }

  public void setReceivertime(Date receivertime) {
    this.receivertime = receivertime;
  }

  public String getLabdoctor() {
    return labdoctor;
  }

  public void setLabdoctor(String labdoctor) {
    this.labdoctor = labdoctor;
  }

  public String getBarstatus() {
    return barstatus;
  }

  public void setBarstatus(String barstatus) {
    this.barstatus = barstatus;
  }

  public String getCanceler() {
    return canceler;
  }

  public void setCanceler(String canceler) {
    this.canceler = canceler;
  }

  public Date getCanceltime() {
    return canceltime;
  }

  public void setCanceltime(Date canceltime) {
    this.canceltime = canceltime;
  }

  public String getDiagnostic() {
    return diagnostic;
  }

  public void setDiagnostic(String diagnostic) {
    this.diagnostic = diagnostic;
  }

  public Date getStartRequettime() {
    return startRequettime;
  }

  public void setStartRequettime(Date startRequettime) {
    this.startRequettime = startRequettime;
  }

  public Date getEndRequettime() {
    return endRequettime;
  }

  public void setEndRequettime(Date endRequettime) {
    this.endRequettime = endRequettime;
  }

  public Date getStartReceivertime() {
    return startReceivertime;
  }

  public void setStartReceivertime(Date startReceivertime) {
    this.startReceivertime = startReceivertime;
  }

  public Date getEndReceivertime() {
    return endReceivertime;
  }

  public void setEndReceivertime(Date endReceivertime) {
    this.endReceivertime = endReceivertime;
  }

  public Date getStartSamplingtime() {
    return startSamplingtime;
  }

  public void setStartSamplingtime(Date startSamplingtime) {
    this.startSamplingtime = startSamplingtime;
  }

  public Date getEndSamplingtime() {
    return endSamplingtime;
  }

  public void setEndSamplingtime(Date endSamplingtime) {
    this.endSamplingtime = endSamplingtime;
  }

  public String getOverTime() {
    return overTime;
  }

  public void setOverTime(String overTime) {
    this.overTime = overTime;
  }

  public String getSampleState() {
    return sampleState;
  }

  public void setSampleState(String sampleState) {
    this.sampleState = sampleState;
  }


  public ViLisBarcodeInfo(String barcode, String requestmode, String requestdoctor, Date requettime, String department, String bednum, String patienttype, String patientid, String patientname, String patientsex, Date birthday, String patientage, String ageunit, String specimencode, String barclass, String examcode, String examname, String cost, String coststatus, Date samplingtime, String samplingdoctor, Date receivertime, String labdoctor, String barstatus, String canceler, Date canceltime, String diagnostic, Date startRequettime, Date endRequettime, Date startReceivertime, Date endReceivertime, Date startSamplingtime, Date endSamplingtime, String overTime, String sampleState, String searchValue) {
    this.barcode = barcode;
    this.requestmode = requestmode;
    this.requestdoctor = requestdoctor;
    this.requettime = requettime;
    this.department = department;
    this.bednum = bednum;
    this.patienttype = patienttype;
    this.patientid = patientid;
    this.patientname = patientname;
    this.patientsex = patientsex;
    this.birthday = birthday;
    this.patientage = patientage;
    this.ageunit = ageunit;
    this.specimencode = specimencode;
    this.barclass = barclass;
    this.examcode = examcode;
    this.examname = examname;
    this.cost = cost;
    this.coststatus = coststatus;
    this.samplingtime = samplingtime;
    this.samplingdoctor = samplingdoctor;
    this.receivertime = receivertime;
    this.labdoctor = labdoctor;
    this.barstatus = barstatus;
    this.canceler = canceler;
    this.canceltime = canceltime;
    this.diagnostic = diagnostic;
    this.startRequettime = startRequettime;
    this.endRequettime = endRequettime;
    this.startReceivertime = startReceivertime;
    this.endReceivertime = endReceivertime;
    this.startSamplingtime = startSamplingtime;
    this.endSamplingtime = endSamplingtime;
    this.overTime = overTime;
    this.sampleState = sampleState;
    this.searchValue = searchValue;
  }

  public ViLisBarcodeInfo() {
  }

  @Override
  public String toString() {
    return "ViLisBarcodeInfo{" +
            "barcode='" + barcode + '\'' +
            ", requestmode='" + requestmode + '\'' +
            ", requestdoctor='" + requestdoctor + '\'' +
            ", requettime=" + requettime +
            ", department='" + department + '\'' +
            ", bednum='" + bednum + '\'' +
            ", patienttype='" + patienttype + '\'' +
            ", patientid='" + patientid + '\'' +
            ", patientname='" + patientname + '\'' +
            ", patientsex='" + patientsex + '\'' +
            ", birthday=" + birthday +
            ", patientage='" + patientage + '\'' +
            ", ageunit='" + ageunit + '\'' +
            ", specimencode='" + specimencode + '\'' +
            ", barclass='" + barclass + '\'' +
            ", examcode='" + examcode + '\'' +
            ", examname='" + examname + '\'' +
            ", cost='" + cost + '\'' +
            ", coststatus='" + coststatus + '\'' +
            ", samplingtime=" + samplingtime +
            ", samplingdoctor='" + samplingdoctor + '\'' +
            ", receivertime=" + receivertime +
            ", labdoctor='" + labdoctor + '\'' +
            ", barstatus='" + barstatus + '\'' +
            ", canceler='" + canceler + '\'' +
            ", canceltime=" + canceltime +
            ", diagnostic='" + diagnostic + '\'' +
            ", startRequettime=" + startRequettime +
            ", endRequettime=" + endRequettime +
            ", startReceivertime=" + startReceivertime +
            ", endReceivertime=" + endReceivertime +
            ", startSamplingtime=" + startSamplingtime +
            ", endSamplingtime=" + endSamplingtime +
            ", overTime='" + overTime + '\'' +
            ", sampleState='" + sampleState + '\'' +
            ", searchValue='" + searchValue + '\'' +
            '}';
  }
}
