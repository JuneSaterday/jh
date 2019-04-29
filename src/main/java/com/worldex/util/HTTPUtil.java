package com.worldex.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 22 下午 4:58
 * @Description:
 */
public class HTTPUtil {

    private static final Logger logger = Logger.getLogger(HTTPUtil.class);
    /**
     * post请求调用接口
     *
     * @param
     */
    public static Map<String,String> doPostParam(String messageType, String url, String data){
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type","application/json");
        try {
            httpPost.setEntity(new StringEntity(data,"application/json","UTF-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("报文转换为实体异常",e);
        }
        CloseableHttpResponse response = null;
        try {
            try {
                response = httpclient.execute(httpPost);
            } catch (IOException e) {
                logger.error("报文推送的POST请求执行失败",e);
            }
            String content = null;
            try {
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
            } catch (IOException e) {
                logger.error("POST请求的响应结果转换为字符串失败",e);
            }
            System.out.println(content);
            Map<String,String> responseMap = JsonUtil.getResponse(content, messageType);
            return responseMap;
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("POST请求响应流关闭异常",e);
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error("POST请求响应流关闭异常",e);
            }
        }
    }

}
