package com.worldex;

import com.worldex.service.HTTPService;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        HTTPService httpService = new HTTPService();
        List<String> list = httpService.postAccountAuth();
        if("200".equals(list.get(0))){
//            httpService.postSubmitCR(String list.get(1));
        }

    }
}
