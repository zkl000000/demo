package com.zhang.jtbclearn.controller;

import com.zhang.jtbclearn.common.web.response.R;
import com.zhang.jtbclearn.service.ReqService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/use")
public class ReqController {

    @Resource
    private ReqService service;

    @PostMapping("/getSqlResopnse/{path}")
    public R getSqlResopnse(@PathVariable("path") String path,@RequestBody Map<String,Object> map) throws IOException, ScriptException {
        return R.ok(service.execute(path,map));
    }
}
