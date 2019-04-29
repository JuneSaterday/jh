package com.worldex.service;

import com.worldex.constant.HTTPStatusCode;
import com.worldex.util.HTTPUtil;
import com.worldex.util.PropertyUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 下午 2:06
 * @Description:
 */
public class HTTPService {
    private static final Logger logger = Logger.getLogger(HTTPService.class);
    private String[] httpProprties = PropertyUtil.loadHttpProperties();
    private String userUrl = httpProprties[2];
    private String messageUrl = httpProprties[3];
    private String id = httpProprties[0];
    private String password = httpProprties[1];
    private String accountValue = "{\"id\":\"" + id + "\",\"password\":\"" + password + "\"}";

    private MessageService messageService = new MessageService();
    private BoundService boundService = new BoundService();

    //POST请求获取密钥
    public Map<String,String> postAccountAuth(){
        return HTTPUtil.doPostParam("account", userUrl, accountValue);
    }

    //post请求提交报文,type取值为Inbound,Outbound
    public boolean postSubmit(String currSessionID,String type){
        //生成调用的URL
        String url = new StringBuilder().append(messageUrl).
                append(currSessionID).append("/WHS").append(type).append(".csfe").toString();
        //生成报文
        List<String> messageList = new ArrayList<>();
        if("Inbound".equals(type)){
            messageList = messageService.createMessage(type,0);
        } else {
            int gap = boundService.getBound("Inbound").size();
            messageList = messageService.createMessage(type,gap);
        }
        if(messageList.size() == 0){
            logger.info("现在没有" + type + "报文需要发送");
            return false;
        }
        //对每条报文，POST请求发送
        for (int i = 0; i < messageList.size(); i++) {
            Map<String,String> messageMap = HTTPUtil.doPostParam(type,url,messageList.get(i));
            //密钥失效，重新获取密钥
            if(HTTPStatusCode.FAIL.equals(messageMap.get("status"))){
                Map<String,String> accountMap = postAccountAuth();
                //重新获取密钥成功
                if(HTTPStatusCode.SUCCESS.equals(accountMap.get("status"))){
                    currSessionID = accountMap.get("result");
                    url = new StringBuilder().append(messageUrl).
                            append(currSessionID).append("/WHS").append(type).append(".csfe").toString();
                    i = i - 1;
                }else {
                    //获取密钥失败
                    logger.info(accountMap);
                    return false;
                }
            } else if(HTTPStatusCode.INCORRECT.equals(messageMap.get("status")) || HTTPStatusCode.UNPROCESSD.
                    equals(messageMap.get("status"))){
                logger.info(messageMap);
                return false;
            }
        }
        return true;
    }
}
