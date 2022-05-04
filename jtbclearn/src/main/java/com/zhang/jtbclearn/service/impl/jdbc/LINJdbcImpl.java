package com.zhang.jtbclearn.service.impl.jdbc;

import com.alibaba.fastjson.JSONObject;
import com.zhang.jtbclearn.common.util.sql.SqlExcute;
import com.zhang.jtbclearn.common.web.http.Response;
import com.zhang.jtbclearn.service.jdbc.LINJdbcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LINJdbcImpl implements LINJdbcService {

    private static final Logger LOG = LoggerFactory.getLogger(LINJdbcImpl.class);
    @Resource(name = "jtbcUtil")
    private SqlExcute sqlExcute;

    @Override
    public List<Map<String, Object>> excuteSelect(String sql, Map<String, Object> map) {
        LOG.info("LINJdbcImpl::excuteSelect:sql -> " + sql + " ;param -> " + JSONObject.toJSONString(map)) ;
        return sqlExcute.excuteSelect(sql,map);
    }

    @Override
    public Response excuteDelete(String sql, Map<String, Object> map) {
        LOG.info("LINJdbcImpl::excuteDelete:sql -> " + sql + " ;param -> " + JSONObject.toJSONString(map));
        return sqlExcute.excuteDelete(sql,map);
    }

    @Override
    public Response excuteUpdate(String sql, Map<String, Object> map) {
        LOG.info("LINJdbcImpl::excuteUpdate:sql -> " + sql + " ;param -> " + JSONObject.toJSONString(map));
        return sqlExcute.excuteUpdate(sql,map);
    }

    @Override
    public Response excuteInsert(String sql, Map<String, Object> map) {
        LOG.info("LINJdbcImpl::excuteUpdate:sql -> " + sql + " ;param -> " +  JSONObject.toJSONString(map));
        return sqlExcute.excuteInsert(sql,map);
    }
}
