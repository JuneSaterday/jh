package com.worldex.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 22 下午 4:58
 * @Description:
 */
public class HTTPUtil {

    private String userUrl = "https://ebusiness.cargofe.com/api/AccountAuth.csfe";

    private String getSessionId(String userUrl){

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(userUrl);


        return null;
    }


}
