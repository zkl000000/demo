package com.zhang.jtbclearn.common.util.sql;

import com.zhang.jtbclearn.common.web.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

@Component
public class JtbcUtil implements SqlExcute{

    private static final Logger LOG = LoggerFactory.getLogger(JtbcUtil.class);

    @Resource
    private JdbcTemplate template;

    public void show() {
        System.out.println("测试");
    }

    @Override
    public List<Map<String, Object>> excuteSelect(String sql, Map<String, Object> map) {
        String sqlStr = this.formatSql(sql,map);

        LOG.info("JtbcUtil::excuteSelect:sql -> " + sqlStr);
        List<Map<String, Object>> maps = template.queryForList(sqlStr);
        return maps;
    }

    @Override
    public Response excuteDelete(String sql, Map<String, Object> map) {
        String sqlStr = this.formatSql(sql,map);

        LOG.info("JtbcUtil::excuteDelete:sql -> " + sqlStr);
        template.execute(sqlStr);
        Response response = new Response();
        response.put("result",true);
        return response;
    }

    @Override
    public Response excuteUpdate(String sql, Map<String, Object> map) {
        String sqlStr = this.formatSql(sql,map);

        LOG.info("JtbcUtil::excuteUpdate:sql -> " + sqlStr);
        template.execute(sqlStr);
        Response response = new Response();
        response.put("result",true);
        return response;
    }

    @Override
    public Response excuteInsert(String sql, Map<String, Object> map) {
        String sqlStr = this.formatSql(sql,map);
        LOG.info("JtbcUtil::excuteSelect:sql -> " + sqlStr);

        template.execute(sqlStr);
        Response response = new Response();
        response.put("result",true);
        return response;
    }


    private String formatSql(String sql, Map<String, Object> map) {
        if (CollectionUtils.isEmpty(map)) {
            return sql;
        }

        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String replace = "'$" + key + "'";
            Object value = map.get(key);

            String appendVal = "'null'";
            if (null != value) {
                appendVal ="'" + value + "'";
            }

            sql = sql.replace(replace,appendVal);
        }
        return sql;
    }

    public static void main(String[] args) {
        JtbcUtil util = new JtbcUtil();
        String sql = "select * from abc where id = '$id' and bane = '$name2' and 123 = '$name23'";
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name2","陈卓");
        System.out.println(util.formatSql(sql,map));
    }
}
