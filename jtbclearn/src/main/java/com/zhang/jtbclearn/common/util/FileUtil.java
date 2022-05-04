package com.zhang.jtbclearn.common.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {

    public static String getContent(InputStreamReader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine() )!=null) {
            sb.append(s).append("\n");
        }
        if(null != reader) {
            reader.close();
        }

        return  sb.toString();
    }
}
