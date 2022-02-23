package com.rcy.test;

import com.rcy.test.utils.RunScript;

import javax.script.*;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author rencaiyu
 * @version 1.0
 * @description: TODO
 * @date 2021-08-13 17:19:53
 */
public class TestScriptEngine {

    public static void main(String[] args) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        String script = "function (name){print(name)}";
        Object eval = engine.eval(script);

        Invocable inv = (Invocable) engine;




    }


}
