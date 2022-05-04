package com.zhang.jtbclearn.service.http;

import java.util.Map;

public interface LINHttpService {
    Object service(String url, Map<String,Object> params,String type) throws Exception;

    Object service(String url, Map<String,Object> params) throws Exception;

    Object service(String url, Map<String,Object> params,Map<String, String> headers,String type) throws Exception;

    Object get(String url, Map<String,Object> params) throws Exception;

    Object get(String url, Map<String,Object> params,Map<String, String> headers) throws Exception;

    Object post(String url, Map<String,Object> params,Map<String, String> headers) throws Exception;

    Object post(String url, Map<String,Object> params) throws Exception;
}
