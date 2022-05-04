package com.zhang.jtbclearn.common.web.http;

import java.util.HashMap;

/**
 * 返回值封装类
 */
public class Response extends HashMap<String,Object> {
    public Response put(String key,Object value) {
        super.put(key, value);
        return this;
    }
}
