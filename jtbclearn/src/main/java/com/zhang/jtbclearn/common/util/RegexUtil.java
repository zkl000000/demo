package com.zhang.jtbclearn.common.util;


import java.util.regex.Pattern;

public class RegexUtil {

    static String str = "var sql = \"select * from tbstudent where stuid = '$stuid'\";\n" +
            "\n" +
            "var params = {\n" +
            "\tstuid : param.get(\"id\")\n" +
            "};\n" +
            "\n" +
            "// 注释代码\n" +
            "\n" +
            "/**\n" +
            "/** asdas \n" +
            "var obj = LINJdbc.excuteSelect(sql,params);\n" +
            "// qaaa\n" +
            "*/\n" +
            "\n" +
            "if (obj && obj.length > 0) {\n" +
            "\treturn obj[0];\n" +
            "}\n" +
            " \n" +
            "return  obj;\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n";

   public static String cleanCommons(String content) {
       Pattern pattern = Pattern.compile("/\\*.+?\\*/", Pattern.DOTALL);
       String all = content.replaceAll("//.+\\r\\n", "");
       return pattern.matcher(all).replaceAll("");
   }

    public static void main(String[] args) {
        System.out.println(cleanCommons(str));
    }
}

