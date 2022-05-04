package com.zhang.jtbclearn.common.util.sql;

import com.zhang.jtbclearn.common.web.http.Response;

import java.util.List;
import java.util.Map;

public interface SqlExcute {

    List<Map<String, Object>> excuteSelect(String sql, Map<String,Object> map);

    Response excuteDelete(String sql, Map<String,Object> map);

    Response excuteUpdate(String sql, Map<String,Object> map);

    Response excuteInsert(String sql, Map<String,Object> map);

}
