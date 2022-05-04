package com.zhang.jtbclearn.controller;

import com.zhang.jtbclearn.common.web.response.R;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/sayHello")
    public R sayHello() {
        return R.ok("hello boy");
    }
}
