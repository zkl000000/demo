package com.zhang.jtbclearn.service;

import com.zhang.jtbclearn.common.web.http.Response;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.Map;

public interface ReqService {

    Response execute();

    Object execute(String path, Map<String,Object> map) throws IOException, ScriptException;
}
