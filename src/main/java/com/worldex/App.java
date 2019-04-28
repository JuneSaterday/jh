package com.worldex;

import com.worldex.constant.HTTPConstant;
import com.worldex.service.HTTPService;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.List;

public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws IOException {

        //一次性发送报文
        HTTPService httpService = new HTTPService();
        List<String> account =  httpService.postAccountAuth();
        if(HTTPConstant.SUCCESS.equals(account.get(0))){
            logger.info("获取密钥成功！");
            //post成功，得到currSessionID
            String currSessionID = account.get(1);
            //进行入库单报文推送
            List<String> inResponse = httpService.postSubmitCR(currSessionID);
            if(null == inResponse){
                logger.info("暂时没有入库单需要推送");
            } else {
                logger.info(inResponse);
            }
            //进行出库单报文推送
            List<String> outResponse = httpService.postSubmitLP(currSessionID);
            if(null == outResponse){
                logger.info("暂时没有出库单需要推送");
            } else {
                logger.info(outResponse);
            }
        } else {
            logger.info(account);
        }

    }
}
