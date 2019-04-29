package com.worldex;

import com.worldex.constant.HTTPStatusCode;
import com.worldex.service.HTTPService;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.Map;

public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws IOException {

        HTTPService httpService = new HTTPService();
        Map<String,String> account =  httpService.postAccountAuth();
        if(HTTPStatusCode.SUCCESS.equals(account.get("status"))){
            logger.info("获取密钥成功！");
            //post成功，得到currSessionID
            String currSessionID = account.get("result");
            //进行入库单报文推送
            boolean isInSuccess = httpService.postSubmit(currSessionID,"Inbound");
            if(isInSuccess){
                logger.info("入库单报文发送成功！");
            } else {
                logger.info("入库单报文发送失败！");
            }
            //进行出库单报文推送
            boolean isOutSuccess = httpService.postSubmit(currSessionID,"Outbound");
            if(isOutSuccess){
                logger.info("出库单报文发送成功！");
            } else {
                logger.info("出库单报文发送失败！");
            }
        } else {
            logger.info(account);
        }
    }
}
