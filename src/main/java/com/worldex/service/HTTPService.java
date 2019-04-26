package com.worldex.service;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 下午 2:06
 * @Description:
 */
public class HTTPService {
    private String userUrl = "https://ebusiness.cargofe.com/api/AccountAuth.csfe";
    private String inMessageUrl = "https://ebusiness.cargofe.com/api/{:currSessionID:}/SubmitCR.csfe";
    private String outMessageUrl = "https://ebusiness.cargofe.com/api/{:currSessionID:}/SubmitLP.csfe";
}
