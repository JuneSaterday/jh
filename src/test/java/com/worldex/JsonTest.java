package com.worldex;

import com.worldex.service.MessageService;
import org.junit.Test;

/**
 * @Author: zhangwei
 * @Date: Created in 2019 04 25 下午 4:23
 * @Description:
 */
public class JsonTest {

    @Test
    public void test(){
        MessageService messageService = new MessageService();
        messageService.createMessage();
    }
}
