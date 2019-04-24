package com.worldex.vo;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 24 下午 6:05
 * @Description:
 */
public class MessageDetail {
    //PO号(必填)
    private String PurchaseOrderNumber;
    //SKU号(非必填)
    private String SKUNumber;
    //品名(非必填)
    private String GoodsName;
    //数量(必填)
    private Integer ActPOQty;
    //重量(非必填)
    private Double ActPOGW;
    //体积(必填)
    private Double ActPOCBM;
    //长宽高(必填)
    private String ActPOMeasurement;

    public String getPurchaseOrderNumber() {
        return PurchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        PurchaseOrderNumber = purchaseOrderNumber;
    }

    public String getSKUNumber() {
        return SKUNumber;
    }

    public void setSKUNumber(String SKUNumber) {
        this.SKUNumber = SKUNumber;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public Integer getActPOQty() {
        return ActPOQty;
    }

    public void setActPOQty(Integer actPOQty) {
        ActPOQty = actPOQty;
    }

    public Double getActPOGW() {
        return ActPOGW;
    }

    public void setActPOGW(Double actPOGW) {
        ActPOGW = actPOGW;
    }

    public Double getActPOCBM() {
        return ActPOCBM;
    }

    public void setActPOCBM(Double actPOCBM) {
        ActPOCBM = actPOCBM;
    }

    public String getActPOMeasurement() {
        return ActPOMeasurement;
    }

    public void setActPOMeasurement(String actPOMeasurement) {
        ActPOMeasurement = actPOMeasurement;
    }

    public String getActPO_InOutDate() {
        return ActPO_InOutDate;
    }

    public void setActPO_InOutDate(String actPO_InOutDate) {
        ActPO_InOutDate = actPO_InOutDate;
    }

    public String getDetailFutureUse1() {
        return DetailFutureUse1;
    }

    public void setDetailFutureUse1(String detailFutureUse1) {
        DetailFutureUse1 = detailFutureUse1;
    }

    public String getDetailFutureUse2() {
        return DetailFutureUse2;
    }

    public void setDetailFutureUse2(String detailFutureUse2) {
        DetailFutureUse2 = detailFutureUse2;
    }

    public String getDetailFutureUse3() {
        return DetailFutureUse3;
    }

    public void setDetailFutureUse3(String detailFutureUse3) {
        DetailFutureUse3 = detailFutureUse3;
    }

    //入库时间/结案时间(必填)
    private String ActPO_InOutDate;
    //托盘号(非必填)
    private String DetailFutureUse1;
    //扩展2(非必填)
    private String DetailFutureUse2;
    //扩展3(非必填)
    private String DetailFutureUse3;
}
