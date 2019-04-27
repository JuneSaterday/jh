package com.worldex.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 22 下午 4:58
 * @Description:
 */
public class HTTPUtil {

    /**
     * post请求调用接口
     *
     * @param
     */
    public static List<String> doPostParam(String messageType, String url, String[] paramName, String[] paramValue) throws IOException {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
//        httpPost.setHeader("Content-Type","application/json");
//        httpPost.setEntity(new StringEntity(account,"application/json","UTF-8"));
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        if("account".equals(messageType)){
            // 设置参数，参数名User,参数值account
            parameters.add(new BasicNameValuePair(paramName[0], paramValue[0]));
        } else {
            parameters.add(new BasicNameValuePair(paramName[0], paramValue[0]));
            parameters.add(new BasicNameValuePair(paramName[1], paramValue[1]));
        }
//        // 设置参数，参数名User,参数值account
//        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
//        parameters.add(new BasicNameValuePair(paramName, paramValue));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
//            if (response.getStatusLine().getStatusCode() == 200) {
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                System.out.println(content);
//            }
            String content = EntityUtils.toString(response.getEntity(), "UTF-8");
            List<String> responseList = JsonUtil.getResponse(content, messageType);
            return responseList;
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
    }

}
