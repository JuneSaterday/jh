package com.worldex;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.worldex.service.MessageService;
import org.junit.Test;

import java.util.List;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 25 下午 4:23
 * @Description:
 */
public class JsonTest {

    @Test
    public void test(){
        MessageService messageService = new MessageService();
        List<String> inBoundList = messageService.createMessage("Inbound",0);
        messageService.createMessage("Outbound",inBoundList.size());
    }

    @Test
    public void jsonToObject(){
        String content = "{\n" +
                "    \"status\": \"200\",\n" +
                "    \"result\": {\n" +
                "        \"id\": \"***\",\n" +
                "        \"currSessionID\": \"423f176b-ed71-492f-b0b7-2d3eac443d5f99876b94-4cbd-\"\n" +
                "        \n" +
                "    }\n" +
                "}";
//        String s = JsonUtil.getCurrSessionID(content,"status");
//        System.out.println(s);
//        s = JsonUtil.getCurrSessionID(content,"currSessionID");
//        System.out.println(s);
//        s = JsonUtil.getCurrSessionID(content,"");
//        System.out.println(s);
    }

    @Test
    public void gsonTest(){
        String content = "{\n" +
                "    \"status\": \"200\",\n" +
                "    \"result\": {\n" +
                "        \"id\": \"***\",\n" +
                "        \"currSessionID\": \"423f176b-ed71-492f-b0b7-2d3eac443d5f99876b94-4cbd-\"\n" +
                "        \n" +
                "    }\n" +
                "}";
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(content).getAsJsonObject();
        String status = jsonObject.get("status").getAsString();
        System.out.println("status:"+status);
        String id = jsonObject.get("result").getAsJsonObject().get("id").getAsString();
        String currSessionID = jsonObject.get("result").getAsJsonObject().get("currSessionID").getAsString();
        System.out.println("result:{" + "id:" + id + ","+ "\n" + "currSessionID:" +currSessionID + "}");
    }
}
