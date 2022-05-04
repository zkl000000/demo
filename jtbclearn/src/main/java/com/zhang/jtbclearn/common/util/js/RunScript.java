package com.zhang.jtbclearn.common.util.js;

import com.zhang.jtbclearn.common.util.DateUtils;
import com.zhang.jtbclearn.common.util.FileUtil;
import com.zhang.jtbclearn.common.util.sql.JtbcUtil;
import com.zhang.jtbclearn.common.web.http.Response;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

/**
 * 运行脚本
 *
 */
@Service
public class RunScript {

    private ScriptEngineManager manager = new ScriptEngineManager();
    private ScriptEngine engine;
    private String fileName;


    public RunScript(){
         engine = manager.getEngineByName("nashorn");
    }


    public RunScript(String fileName){
        engine = manager.getEngineByName("nashorn");
        this.fileName = fileName;
    }
    
    /**
     * 设置变量
     * @param varName
     * @param obj
     */
    public void setVar(String varName, Object obj){
        engine.put(varName, obj);
    }

    /**
     * 启动脚本
     * @throws FileNotFoundException
     * @throws ScriptException
     */
    public Response start() throws IOException, ScriptException {
        InputStreamReader  fileReader = new InputStreamReader(new FileInputStream(fileName) ,"UTF-8");
        String content = FileUtil.getContent(fileReader);
       // System.out.println(content);
        String fileContent = JsUtil.getFileContext();
        String info = String.format(fileContent,content);
        Object eval = engine.eval(info);
        Response response = new Response();
        response.put("body",eval);
        return response;
    }

    /**
     * 启动脚本
     * @throws FileNotFoundException
     * @throws ScriptException
     */
    public Object start2() throws IOException, ScriptException{
        InputStreamReader  fileReader = new InputStreamReader(new FileInputStream(fileName) ,"UTF-8");
        String content = FileUtil.getContent(fileReader);
        System.out.println(content);
        String fileContent = JsUtil.getFileContext();
        String info = String.format(fileContent,content);
        Object eval = engine.eval(info);
        return eval;
    }


    public static void main(String[] args) throws IOException, ScriptException {
        RunScript runScript = new RunScript();
        String path = "C:\\Users\\sharewin\\Desktop\\index.js";
        runScript.setFileName(path);
        Object start = runScript.start();
        System.out.println(start);
    }


    public ScriptEngineManager getManager() {
        return manager;
    }

    public void setManager(ScriptEngineManager manager) {
        this.manager = manager;
    }

    public ScriptEngine getEngine() {
        return engine;
    }

    public void setEngine(ScriptEngine engine) {
        this.engine = engine;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}