package com.worldex.vo;

import java.util.Date;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 24 下午 5:16
 * @Description:传输报文的类
 */
public class DataMessage {
    //进仓编号(必填)
    private String JobNo;
    //主提单号(出库必填)
    private String MasterWaybill;
    //分提单号(非必填)
    private String HouseWaybill;
    //箱型(出库必填)
    private String ContainerType;
    //箱号(出库必填)
    private String ContainerNumber;
    //铅封号(出库必填)
    private String SealNo;
    //发货工厂(非必填)
    private String Factory;
    //起始港(出库必填)
    private String OriginPort;
    //目的港(出库必填)
    private String DestPort;
    //计划出发日期(出库必填)
    private Date ETD;
    //结案时间(必填)
    private Date OutboundDate;
    //备注(非必填)
    private String Remark;
    //分客户(非必填)
    private String FutureUse1;
    //扩展2(非必填)
    private Integer FutureUse2;
    //扩展3(非必填)
    private String FutureUse3;

    public String getJobNo() {
        return JobNo;
    }

    public void setJobNo(String jobNo) {
        JobNo = jobNo;
    }

    public String getMasterWaybill() {
        return MasterWaybill;
    }

    public void setMasterWaybill(String masterWaybill) {
        MasterWaybill = masterWaybill;
    }

    public String getHouseWaybill() {
        return HouseWaybill;
    }

    public void setHouseWaybill(String houseWaybill) {
        HouseWaybill = houseWaybill;
    }

    public String getContainerType() {
        return ContainerType;
    }

    public void setContainerType(String containerType) {
        ContainerType = containerType;
    }

    public String getContainerNumber() {
        return ContainerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        ContainerNumber = containerNumber;
    }

    public String getSealNo() {
        return SealNo;
    }

    public void setSealNo(String sealNo) {
        SealNo = sealNo;
    }

    public String getFactory() {
        return Factory;
    }

    public void setFactory(String factory) {
        Factory = factory;
    }

    public String getOriginPort() {
        return OriginPort;
    }

    public void setOriginPort(String originPort) {
        OriginPort = originPort;
    }

    public String getDestPort() {
        return DestPort;
    }

    public void setDestPort(String destPort) {
        DestPort = destPort;
    }

    public Date getETD() {
        return ETD;
    }

    public void setETD(Date ETD) {
        this.ETD = ETD;
    }

    public Date getOutboundDate() {
        return OutboundDate;
    }

    public void setOutboundDate(Date outboundDate) {
        OutboundDate = outboundDate;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getFutureUse1() {
        return FutureUse1;
    }

    public void setFutureUse1(String futureUse1) {
        FutureUse1 = futureUse1;
    }

    public Integer getFutureUse2() {
        return FutureUse2;
    }

    public void setFutureUse2(Integer futureUse2) {
        FutureUse2 = futureUse2;
    }

    public String getFutureUse3() {
        return FutureUse3;
    }

    public void setFutureUse3(String futureUse3) {
        FutureUse3 = futureUse3;
    }
}
