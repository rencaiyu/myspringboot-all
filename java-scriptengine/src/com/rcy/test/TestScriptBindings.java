package com.rcy.test;

import javax.script.*;
import java.util.HashSet;

/**
 * @author rencaiyu
 * @version 1.0
 * @description: 脚本语言支持API使用语言绑定对象实现Java语言编写的程序与脚本语言间的数据传递。
 * 语言绑定对象实际上就是一个简单的哈希表，用来存放和获取需要共享的数据，
 * 其定义的接口为javax.script.Bindings，继承自java.util.Map接口。
 * 一个脚本引擎在执行过程中可能会使用多个语言绑定对象，不同语言绑定对象的作用域不同。
 * ScriptEngine类提供out和get方法对脚本引擎中特定作用域的默认语言绑定对象进行操作。
 * @date 2021-08-18 11:20:06
 */
public class TestScriptBindings {

    public static void main(String[] args) throws Exception {



        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        String scriptText = "function getGreeting(name) { return 'Hello, ' + name; } ";
        engine.eval(scriptText);
        Invocable invocable = (Invocable) engine;

    }

    /**
     * @Author: rencaiyu
     * @Description: 如语言绑定对象中包含程序自己独有的数据等情形……
     * @Date: 8/18/21  3:06 PM
     **/
    private static void customBindings(String message) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");


        Bindings bindings = new SimpleBindings();
        bindings.put("message", message);
        engine.eval("print('hello ' + message);", bindings);
    }

    /**
     * @Author: rencaiyu
     * @Description: 默认的传参数使用
     * @Date: 8/18/21  3:04 PM
     **/
    private static void defaultBindings(String message) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        engine.put("name", message);
        engine.eval("var message = 'Hello, ' + name;");
        Object obj = engine.get("message");
        System.out.println(obj);
    }
}
