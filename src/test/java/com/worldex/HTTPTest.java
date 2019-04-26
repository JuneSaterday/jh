package com.worldex;

import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 下午 2:56
 * @Description:
 */
public class HTTPTest {

    @Test
    public void jsonToStringBody() throws UnsupportedEncodingException {
        String account = "{\n" +
                "\t\"client\": \"Chinex\",\n" +
                "\t\"client_id\": 100000,\n" +
                "\t\"client_key\": \"CEVA20181220021503\",\n" +
                "\t\"version\": 1,\n" +
                "\t\"CFSData\": {\n" +
                "\t\t\"createdOn\": \"2018-12-20 02:15:03\",\n" +
                "\t\t\"Type\": \"Out\",\n" +
                "\t\t\"JobNo\": \"ESOA115-0553555\",\n" +
                "\t\t\"MasterWaybill\": \"ACBW011926\",\n" +
                "\t\t\"HouseWaybill\": \"\",\n" +
                "\t\t\"ContainerType\": \"40GP\",\n" +
                "\t\t\"ContainerNumber\": \"TCLU4053368\",\n" +
                "\t\t\"SealNo\": \"K7986459\",\n" +
                "\t\t\"Factory\": \"\",\n" +
                "\t\t\"OriginPort\": \"WGQ\",\n" +
                "\t\t\"DestPort\": \"LAEM CHABANG\",\n" +
                "\t\t\"ETD\": \"2018-12-25\",\n" +
                "\t\t\"OutboundDate\": \"2018-12-20 02:12:43\",\n" +
                "\t\t\"Remark\": \"1156011(13211)这个款号40托装TCLU4053368这个箱子里。  1156011(13211)6托、1153021(13219)13托、1153505(16205)1托这3个款号共20托装在TCLU7613492这个箱号里。 1241988(16203)9托、1156024(17201)22托、1154505(17203)8托这3个款号共39托装在APZU4281712这个箱号里。\",\n" +
                "\t\t\"PODetails\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"001\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:56:05\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308611\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"002\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:56:12\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308612\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"003\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:56:28\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308625\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"004\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:56:37\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308626\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"005\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:57:12\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308623\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"006\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:57:16\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308624\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"008\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:57:25\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308622\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"009\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:57:33\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308621\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"011\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:57:42\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308620\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"012\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:57:52\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308619\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"013\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:58:36\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492275\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"014\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:58:41\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492276\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"015\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:58:47\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308614\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"016\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:58:50\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308613\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"017\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:59:01\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308617\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"018\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:59:09\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308618\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"019\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:59:14\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492302\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"020\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 21:59:27\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492301\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"021\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:00:26\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308603\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"022\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:00:55\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308604\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"023\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:01:18\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308610\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"024\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:01:22\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308609\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"025\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:01:30\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308608\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"026\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:01:38\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308607\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"028\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:01:50\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308606\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"029\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:02:01\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308605\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"030\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:02:05\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308615\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"031\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.159\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"100*122*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:02:08\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"308616\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"032\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:02:22\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492241\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"033\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:02:27\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492242\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"034\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:02:42\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492239\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"035\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:02:46\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492274\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"036\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:03:04\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492259\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"037\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:03:10\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492260\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"038\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:03:25\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492297\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"039\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:03:30\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492298\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"040\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:03:34\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492295\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"041\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:03:37\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492296\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"042\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:03:42\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492261\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"043\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:03:46\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492262\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"044\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:04:27\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492258\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"045\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:04:31\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492257\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"046\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:04:44\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492264\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"047\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:04:48\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492263\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"048\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:04:55\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492272\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"049\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:01\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492271\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"050\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:10\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492256\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"051\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:15\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492255\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"052\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:20\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492289\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"053\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:25\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492290\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"054\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:38\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492281\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"055\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:42\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492282\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"056\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:45\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492280\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"057\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:52\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492279\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"058\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:05:56\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492292\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"059\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:06:03\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492291\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"060\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:06:14\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492244\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"061\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:06:21\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492248\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"062\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.051\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*86\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:06:27\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492247\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"063\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.051\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*86\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:06:36\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492230\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"064\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:06:51\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492294\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"065\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:06:59\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492293\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"066\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:04\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492299\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"067\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:08\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492300\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"068\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:12\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492304\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"069\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:16\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492303\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"070\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:22\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492273\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"071\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:34\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492285\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"072\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:39\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492287\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"073\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.051\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*86\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:48\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492228\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"074\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.051\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*86\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:54\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492254\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"075\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.051\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*86\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:07:58\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492231\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"076\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:08:06\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492278\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"077\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:08:11\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492284\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"078\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:08:23\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492237\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"079\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:08:26\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492238\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"080\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:08:30\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492235\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"081\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:08:33\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492236\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"082\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:08:42\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492240\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"083\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:09:09\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492245\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"084\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:09:12\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492246\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"085\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:09:23\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492232\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"086\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:09:32\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492251\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"087\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:09:38\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492250\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"088\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:09:45\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492277\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"089\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:09:50\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492268\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"090\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:09:57\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492267\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"091\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:03\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492243\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"092\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:09\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492233\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"093\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:13\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492234\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"094\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:21\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492288\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"095\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:26\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492286\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"096\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:31\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492253\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"097\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:36\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492252\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"098\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.1\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*90\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:46\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492283\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"099\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:50\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492266\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"100\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:53\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492265\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"101\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:10:58\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492270\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"PurchaseOrderNumber\": \"102\",\n" +
                "\t\t\t\t\"SKUNumber\": \"\",\n" +
                "\t\t\t\t\"GoodsName\": \"\",\n" +
                "\t\t\t\t\"ActPOQty\": \"1\",\n" +
                "\t\t\t\t\"ActPOGW\": \"0\",\n" +
                "\t\t\t\t\"ActPOCBM\": \"1.161\",\n" +
                "\t\t\t\t\"ActPOMeasurement\": \"121*101*95\",\n" +
                "\t\t\t\t\"ActPO_InOutDate\": \"2018-12-19 22:11:02\",\n" +
                "\t\t\t\t\"DetailFutureUse1\": \"492269\",\n" +
                "\t\t\t\t\"DetailFutureUse2\": \"\",\n" +
                "\t\t\t\t\"DetailFutureUse3\": \"\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"FutureUse1\": \"非PRIMARK\",\n" +
                "\t\t\"FutureUse2\": \"\",\n" +
                "\t\t\"FutureUse3\": \"\"\n" +
                "\t}\n" +
                "}";
        StringEntity entity = new StringEntity(account,"utf-8");
        System.out.println(entity);
        try {
            String s = EntityUtils.toString(entity);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
