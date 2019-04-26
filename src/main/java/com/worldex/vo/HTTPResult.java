package com.worldex.vo;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 26 下午 4:01
 * @Description:
 */

public class HTTPResult {
    //响应状态码
    private Integer status;
    //响应的内容
    private String result;

    public HTTPResult() {
    }

    public HTTPResult(Integer status, String result) {
        this.status = status;
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HTTPResult{" +
                "status=" + status +
                ", result='" + result + '\'' +
                '}';
    }
}


