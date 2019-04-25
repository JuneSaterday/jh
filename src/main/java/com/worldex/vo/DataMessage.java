package com.worldex.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 24 下午 5:16
 * @Description:传输报文的类
 */
public class DataMessage {
    //vc_no
    @JSONField(serialize = false)
    private String vc_no;
    //进仓编号(必填)
    @JSONField(ordinal = 1,name = "JobNo")
    private String JobNo;
    //主提单号(出库必填)
    @JSONField(ordinal = 2,name = "MasterWaybill")
    private String MasterWaybill;
    //分提单号(非必填)
    @JSONField(ordinal = 3,name = "HouseWaybill")
    private String HouseWaybill;
    //箱型(出库必填)
    @JSONField(ordinal = 4,name = "ContainerType")
    private String ContainerType;
    //箱号(出库必填)
    @JSONField(ordinal = 5,name = "ContainerNumber")
    private String ContainerNumber;
    //铅封号(出库必填)
    @JSONField(ordinal = 6,name = "SealNo")
    private String SealNo;
    //发货工厂(非必填)
    @JSONField(ordinal = 7,name = "Factory")
    private String Factory;
    //起始港(出库必填)
    @JSONField(ordinal = 8,name = "OriginPort")
    private String OriginPort;
    //目的港(出库必填)
    @JSONField(ordinal = 9,name = "DestPort")
    private String DestPort;
    //计划出发日期(出库必填)
    @JSONField(ordinal = 10,name = "ETD")
    private Date ETD;
    //结案时间(必填)
    @JSONField(ordinal = 11,name = "OutboundDate",format = "yyyy-MM-dd HH:mm:ss")
    private Date OutboundDate;
    //备注(非必填)
    @JSONField(ordinal = 12,name = "Remark")
    private String Remark;
    //报文明细
    @JSONField(ordinal = 13,name = "PODetails")
    private List<MessageDetail> PODetails;
    //分客户(非必填)
    @JSONField(ordinal = 14,name = "FutureUse1")
    private String FutureUse1;
    //扩展2(非必填)
    @JSONField(ordinal = 15,name = "FutureUse2")
    private Integer FutureUse2;
    //扩展3(非必填)
    @JSONField(ordinal = 16,name = "FutureUse3")
    private String FutureUse3;

    public String getVc_no() {
        return vc_no;
    }

    public void setVc_no(String vc_no) {
        this.vc_no = vc_no;
    }

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

    public List<MessageDetail> getPODetails() {
        return PODetails;
    }

    public void setPODetails(List<MessageDetail> PODetails) {
        this.PODetails = PODetails;
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

    @Override
    public String toString() {
        return "DataMessage{" +
                "vc_no='" + vc_no + '\'' +
                ", JobNo='" + JobNo + '\'' +
                ", MasterWaybill='" + MasterWaybill + '\'' +
                ", HouseWaybill='" + HouseWaybill + '\'' +
                ", ContainerType='" + ContainerType + '\'' +
                ", ContainerNumber='" + ContainerNumber + '\'' +
                ", SealNo='" + SealNo + '\'' +
                ", Factory='" + Factory + '\'' +
                ", OriginPort='" + OriginPort + '\'' +
                ", DestPort='" + DestPort + '\'' +
                ", ETD=" + ETD +
                ", OutboundDate=" + OutboundDate +
                ", Remark='" + Remark + '\'' +
                ", PODetails=" + PODetails +
                ", FutureUse1='" + FutureUse1 + '\'' +
                ", FutureUse2=" + FutureUse2 +
                ", FutureUse3='" + FutureUse3 + '\'' +
                '}';
    }
}
