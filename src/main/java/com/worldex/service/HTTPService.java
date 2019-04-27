package com.worldex.service;

import com.worldex.util.HTTPUtil;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 下午 2:06
 * @Description:
 */
public class HTTPService {
    private String userUrl = "https://ebusiness.cargofe.com/api/AccountAuth.csfe";
    private String inMessageUrl = "https://ebusiness.cargofe.com/api/{:currSessionID:}/SubmitCR.csfe";
    private String outMessageUrl = "https://ebusiness.cargofe.com/api/{:currSessionID:}/SubmitLP.csfe";

    private String accountKey = "User";
    private String accountValue = "{\"id\":\"...\",\"password\":\"...\"}";

    private MessageService messageService = new MessageService();

    public List<String> postAccountAuth() throws IOException {
        String type = "account";
        String url = userUrl;
        String[] paramName = new String[]{accountKey};
        String[] paramValue = new String[]{accountValue};
        return HTTPUtil.doPostParam(type,url,paramName,paramValue);
    }

    public List<String> postSubmitCR(String currSessionID) throws IOException {
        String type = "SubmitCR";
        String url = inMessageUrl;
        String[] paramName = new String[2];
        String[] paramValue = new String[2];
        paramName[0] = "currSessionID";
        paramValue[0] = currSessionID;
        paramName[1] = "Inbound CR";
        List<String> paramValues = messageService.createMessage("Inbound");
        for (int i = 0; i < paramValues.size(); i++) {
            paramValue[1] = paramValues.get(i);
            List<String> list = HTTPUtil.doPostParam(type,url,paramName,paramValue);
            if(!"200".equals(list.get(0))){
                paramValue[0] = postAccountAuth().get(1);
                i = i - 1;
            }
        }
        return HTTPUtil.doPostParam(type,url,paramName,paramValue);
    }

    public List<String> postSubmitLP(String currSessionID) throws IOException {
        String type = "SubmitLP";
        String url = outMessageUrl;
        String[] paramName = new String[2];
        String[] paramValue = new String[2];
        paramName[0] = "currSessionID";
        paramValue[0] = currSessionID;
        paramName[1] = "Inbound CR";
        List<String> paramValues = messageService.createMessage("Outbound");
        for (int i = 0; i < paramValues.size(); i++) {
            paramValue[1] = paramValues.get(i);
            List<String> list = HTTPUtil.doPostParam(type,url,paramName,paramValue);
            if(!"200".equals(list.get(0))){
                paramValue[0] = postAccountAuth().get(1);
                i = i - 1;
            }
        }
        return HTTPUtil.doPostParam(type,url,paramName,paramValue);
    }
}
