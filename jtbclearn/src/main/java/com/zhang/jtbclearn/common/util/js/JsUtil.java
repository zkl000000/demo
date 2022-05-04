package com.zhang.jtbclearn.common.util.js;


public class JsUtil {

    public static String getFileContext() {
        String str = "go();\n" +
                "function go()\n" +
                "{\n" +
                "   var DateUtils = Java.type(\"com.zhang.jtbclearn.common.util.DateUtils\");\n" +
                "   var IdUtils = Java.type(\"com.zhang.jtbclearn.common.util.id.IdUtils\");\n" +
                "   var console = Java.type(\"com.zhang.jtbclearn.common.util.js.Console\");\n" +
                "   %s\n" +
                "}";
        return str;
    }
}