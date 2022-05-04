package com.zhang.jtbclearn.service.impl;

import com.zhang.jtbclearn.common.util.js.JsParam;
import com.zhang.jtbclearn.common.util.js.RunScript;
import com.zhang.jtbclearn.common.util.string.StringUtils;
import com.zhang.jtbclearn.common.web.http.Response;
import com.zhang.jtbclearn.service.ReqService;
import com.zhang.jtbclearn.service.http.LINHttpService;
import com.zhang.jtbclearn.service.jdbc.LINJdbcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.Map;

@Service
public class ReqServiceImpl implements ReqService {
    private static final Logger LOG = LoggerFactory.getLogger(ReqServiceImpl.class);
    private final static  ThreadLocal<Map<String,Integer>> guard = new ThreadLocal<>();

    @Resource
    private LINHttpService linHttpService;

    @Resource
    private LINJdbcService linJdbc;


    @Value("${lin.path}")
    private String initPath;

    @Resource
    private RunScript runScript;



    @Override
    public Response execute() {
        return null;
    }

    @Override
    public Object execute(String path, Map<String, Object> map) throws IOException, ScriptException {
        String fullPath = getfullPath(path);
        JsParam param = new JsParam();
        param.putAll(map);

        runScript.setFileName(fullPath);
        runScript.getEngine().put("LINJdbc",linJdbc);
        runScript.getEngine().put("LINService", linHttpService);
        runScript.getEngine().put("param",param);
        runScript.getEngine().put("logger",LOG);

        Object start = runScript.start2();
        return start;
    }

    private String getfullPath(String path) {
        String init = "./";
        if(StringUtils.isNotEmpty(initPath)) {
            init = initPath;
        }
        if (path.contains(".")) {
            path = path.replace(".","/");
        }
        return init + path + ".js";
    }
}
