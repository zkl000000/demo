package com.zhang.jtbclearn.common.exception;

import com.zhang.jtbclearn.common.exception.base.BaseException;

import java.security.NoSuchAlgorithmException;

/**
 * 工具类异常
 * 
 * @author ruoyi
 */
public class UtilException extends BaseException
{


    public UtilException(String module, String code, Object[] args, String defaultMessage) {
        super(module, code, args, defaultMessage);
    }

    public UtilException(String module, String code, Object[] args) {
        super(module, code, args);
    }

    public UtilException(String module, String defaultMessage) {
        super(module, defaultMessage);
    }

    public UtilException(String code, Object[] args) {
        super(code, args);
    }

    public UtilException(String defaultMessage) {
        super(defaultMessage);
    }

    public UtilException(NoSuchAlgorithmException e) {
        super(e);
    }
}
