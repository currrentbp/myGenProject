package com.currentbp.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author current_bp
 * @createTime 20180509
 */
public class UseScriptEngineManager {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
    /*
     * 字符串转算术表达式
     */
        String str1 = "43*(2 + 1.4)+2*32/(3-2.1)";
        Object result1 = engine.eval(str1);
        System.out.println("结果类型:" + result1.getClass().getName() + ",计算结果:" + result1);
       /*
        * 字符串转条件表达式
        */
        int value = 7;
        String state = "正常";
        boolean flag = true;
        String st = "test";
        String str2 = "value > 5 && st == \"test\" && state == \"正常\" && flag == true";
        engine.put("value", value);
        engine.put("state", state);
        engine.put("flag", flag);
        engine.put("st", st);
        Object result2 = engine.eval(str2);
        System.out.println("结果类型:" + result2.getClass().getName() + ",结果:" + result2);
    }
}
