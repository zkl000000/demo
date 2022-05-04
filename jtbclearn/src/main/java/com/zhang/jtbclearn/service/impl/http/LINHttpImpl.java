package com.zhang.jtbclearn.service.impl.http;

import com.alibaba.fastjson.JSONObject;
import com.zhang.jtbclearn.common.constant.Http;
import com.zhang.jtbclearn.common.util.SpringUtils;
import com.zhang.jtbclearn.common.util.http.HttpUtil;
import com.zhang.jtbclearn.common.util.string.StringUtils;
import com.zhang.jtbclearn.service.ReqService;
import com.zhang.jtbclearn.service.http.LINHttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LINHttpImpl implements LINHttpService {

    private static final Logger LOG = LoggerFactory.getLogger(LINHttpImpl.class);

    @Override
    public Object service(String url, Map<String, Object> params, String type) throws Exception {
        LOG.info("LINHttpImpl::service: url -> " + url + "; type -> " + type + "; params ->" + JSONObject.toJSONString(params));
        if (StringUtils.isEmpty(type)) {
            throw new RuntimeException("url类型为空");
        }

        if (type.equalsIgnoreCase(Http._GET)) {
            return get(url,params);
        } else if (type.equalsIgnoreCase(Http._POST)) {
            return post(url,params);
        }

        throw new RuntimeException("url类型异常: " + type);
    }

    @Override
    public Object service(String url, Map<String, Object> params) throws Exception {
        ReqService service = SpringUtils.getBean("reqServiceImpl");
        return service.execute(url,params);
    }

    @Override
    public Object service(String url, Map<String, Object> params, Map<String, String> headers, String type) throws Exception {
        LOG.info("LINHttpImpl::service: url -> " + url + "; type -> " + type + "; params ->" + JSONObject.toJSONString(params) + "; header -> " + JSONObject.toJSONString(headers));
        if (StringUtils.isEmpty(type)) {
            throw new RuntimeException("url类型为空");
        }

        if (type.equalsIgnoreCase(Http._GET)) {
            return get(url,params,headers);
        } else if (type.equalsIgnoreCase(Http._POST)) {
            return post(url,params,headers);
        }

        throw new RuntimeException("url类型异常: " + type);
    }

    @Override
    public Object get(String url, Map<String, Object> params) throws Exception {
        LOG.info("LINHttpImpl::get: url -> " + url + "; params->" + JSONObject.toJSONString(params) );
        String response = HttpUtil.get(url, params);

        LOG.info("LINHttpImpl::get: response -> " + response );
        Object json = JSONObject.toJSON(response);
        return json;
    }

    @Override
    public Object get(String url, Map<String, Object> params, Map<String, String> headers) throws Exception {
        LOG.info("LINHttpImpl::get: url -> " + url +  "; params->" + JSONObject.toJSONString(params) + "; header -> " + JSONObject.toJSONString(headers));
        String response = HttpUtil.get(url,params,headers);
        LOG.info("LINHttpImpl::get: response -> " + response );
        Object json = JSONObject.toJSON(response);
        return json;
    }

    @Override
    public Object post(String url, Map<String, Object> params, Map<String, String> headers) throws Exception {
        LOG.info("LINHttpImpl::post: url -> " + url  + "; params->" + JSONObject.toJSONString(params) + "; header -> " + JSONObject.toJSONString(headers));
        params= (params == null? new HashMap<String, Object>():params);
        String response = HttpUtil.post(url,JSONObject.toJSONString(params),headers);
        LOG.info("LINHttpImpl::get: response -> " + response );
        Object json = JSONObject.toJSON(response);
        return json;
    }

    @Override
    public Object post(String url, Map<String, Object> params) throws Exception {
        LOG.info("LINHttpImpl::post: url -> " + url + "; params->" + JSONObject.toJSONString(params) );
        params= (params == null? new HashMap<String, Object>():params);
        String response =  HttpUtil.post(url,JSONObject.toJSONString(params));
        LOG.info("LINHttpImpl::get: response -> " + response );
        Object json = JSONObject.toJSON(response);
        return json;
    }
}
