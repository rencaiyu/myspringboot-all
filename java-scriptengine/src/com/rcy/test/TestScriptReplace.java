package com.rcy.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rencaiyu
 * @version 1.0
 * @description: TODO
 * @date 2021-08-19 15:08:18
 */
public class TestScriptReplace {
    public static final ScriptEngineManager SCRIPT_ENGINE_MANAGER = new ScriptEngineManager();
    public static final ScriptEngine ENGINE;

    static {
        ENGINE = SCRIPT_ENGINE_MANAGER.getEngineByName("JavaScript");
    }

    public static void main(String[] args) {

        Map valuesMap = new HashMap(5);
        valuesMap.put("A", "2");
        valuesMap.put("B", "3");
        valuesMap.put("C", "4");
        valuesMap.put("D", "5");
        valuesMap.put("F", "24");



    }
}
