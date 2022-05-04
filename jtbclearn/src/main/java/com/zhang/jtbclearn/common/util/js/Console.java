package com.zhang.jtbclearn.common.util.js;

import com.alibaba.fastjson.JSON;

public class Console {
    public static void log(String key,Object val){
        if (null == val) {
            System.out.println(key + ",null" );
            return;
        }
        System.out.println(key + "," + JSON.toJSONString(val));
    }

    public static void log(Object val){
        if (null == val) {
            System.out.println("null" );
            return;
        }
        System.out.println(JSON.toJSONString(val));
    }
}
