package com.zhang.jtbclearn.common.exception.exceptionHandler;


import com.zhang.jtbclearn.common.web.response.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R errorHandler(Exception e) {
        e.printStackTrace();
        return R.fail(e.getMessage());
    }
}
