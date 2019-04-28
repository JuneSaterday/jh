package com.worldex.service;

import com.worldex.util.HTTPUtil;
import com.worldex.util.PropertyUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 下午 2:06
 * @Description:
 */
public class HTTPService {
    private static final Logger logger = Logger.getLogger(HTTPService.class);


    String[] httpProprties = PropertyUtil.loadHttpProperties();

    private String userUrl = httpProprties[2];
    private String messageUrl = httpProprties[3];

    private String id = httpProprties[0];
    private String password = httpProprties[1];
    private String accountKey = "User";
    private String accountValue = "{\"id\":\"" + id + "\",\"password\":\"" + password + "...\"}";

    private MessageService messageService = new MessageService();

    public List<String> postAccountAuth() throws IOException {
        String type = "account";
        String url = userUrl;
        String[] paramName = new String[]{accountKey};
        String[] paramValue = new String[]{accountValue};
        System.out.println(userUrl);
        return HTTPUtil.doPostParam(type,url,paramName,paramValue);
    }

    public List<String> postSubmitCR(String currSessionID) throws IOException {
        String type = "Inbound data";
        String url = new StringBuilder().append(messageUrl).append("{:").
                        append(currSessionID).append(":}").append("/WHSInbound.csfe").toString();
        String[] paramName = new String[2];
        String[] paramValue = new String[2];
        paramName[0] = "currSessionID";
        paramValue[0] = currSessionID;
        paramName[1] = "Inbound data";
//        //报文一条一条地发送
//        List<String> paramValues = messageService.createMessage("Inbound",0);
//        for (int i = 0; i < paramValues.size(); i++) {
//            paramValue[1] = paramValues.get(i);
//            List<String> list = HTTPUtil.doPostParam(type,url,paramName,paramValue);
//            if(!"200".equals(list.get(0))){
//                paramValue[0] = postAccountAuth().get(1);
//                i = i - 1;
//            }
//        }
//        return HTTPUtil.doPostParam(type,url,paramName,paramValue);

        //报文一下全部发送
        List<String> paramValues = messageService.createMessage("Inbound",0);
        if(null == paramValues){
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paramValues.size(); i++) {
            if(i != paramValues.size() - 1){
                builder.append(paramValues.get(i) + ",");
            }else{
                builder.append(paramValues.get(i));
            }
        }
        paramValue[1] = builder.toString();
        List<String> response = HTTPUtil.doPostParam(type,url,paramName,paramValue);
        return response;
    }

    public List<String> postSubmitLP(String currSessionID) throws IOException {
        String type = "Outbound data";
        String url = messageUrl + currSessionID + "SubmitLP.csfe";
        String[] paramName = new String[2];
        String[] paramValue = new String[2];
        paramName[0] = "currSessionID";
        paramValue[0] = currSessionID;
        paramName[1] = "Outbound data";
//        报文一条条发送
//        List<String> paramValues = messageService.createMessage("Outbound",0);
//        for (int i = 0; i < paramValues.size(); i++) {
//            paramValue[1] = paramValues.get(i);
//            List<String> list = HTTPUtil.doPostParam(type,url,paramName,paramValue);
//            if(!"200".equals(list.get(0))){
//                paramValue[0] = postAccountAuth().get(1);
//                i = i - 1;
//            }
//        }
//        return HTTPUtil.doPostParam(type,url,paramName,paramValue);

        //报文一次性发送
        int gap = messageService.createMessage("Inbound",0).size();
        List<String> paramValues = messageService.createMessage("Outbound",gap);
        if(null == paramValues){
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paramValues.size(); i++) {
            if(i != paramValues.size() - 1){
                builder.append(paramValues.get(i) + ",");
            }else{
                builder.append(paramValues.get(i));
            }
        }
        paramValue[1] = builder.toString();
        List<String> response = HTTPUtil.doPostParam(type,url,paramName,paramValue);
        return response;
    }


//    //一次只传一个
//    public List<String> postSubmitCRSingle(String currSessionID){
//        String type = "SubmitCR";
//        String url = messageUrl + currSessionID + "SubmitCR.csfe";
//        String[] paramName = new String[2];
//        String[] paramValue = new String[2];
//        paramName[0] = "currSessionID";
//        paramValue[0] = currSessionID;
//        paramName[1] = "Inbound CR";
//        //报文一条一条地发送
//        List<String> paramValues = messageService.createMessage("Inbound",0);
//        for (int i = 0; i < paramValues.size(); i++) {
//            paramValue[1] = paramValues.get(i);
//            List<String> list = null;
//            try {
//                list = HTTPUtil.doPostParam(type,url,paramName,paramValue);
//            } catch (IOException e) {
//                logger.info("调用入库报文接口异常" + e);
//            }
//            //密钥currSessionID失效，需重新获取
//            if("403".equals(list.get(0))){
//                try {
//                    paramValue[0] = postAccountAuth().get(1);
//                } catch (IOException e) {
//                    logger.info("调用验证接口异常" + e);
//                }
//                i = i - 1;
//            } else if("400".equals(list.get(0)) || "422".equals(list.get(0))){
//                logger.info(list.get(1));
//            }
//        }
//        return HTTPUtil.doPostParam(type,url,paramName,paramValue);
//
//    }
}
