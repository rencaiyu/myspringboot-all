package com.rcy.test;

import com.rcy.test.bean.UserBean;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rencaiyu
 * @version 1.0
 * @description: TODO
 * @date 2021-08-16 15:25:43
 */
public class TestScriptFunction {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String scriptMsg = "function getListAdd(arr){ " +
                "var len =  arr.length; " +
                "if (len<=0){return 0;};" +
                "var sumValue = 0 ;" +
                " for (var i = 0; i <len; i++ ) {" +
                " sumValue =  sum(age);" +
                "}" +
                "return sumValue;  " +
                "}";
        String replace = scriptMsg.replace("sum(", "sum(arr[i].");

        String scriptMessage = "function sum(age){print(age)}";

        Object eval = engine.eval(replace);
        engine.eval(scriptMessage);

        Invocable in = (Invocable) engine;

        List<UserBean> userBeanList = new ArrayList<>();
        UserBean userBean = new UserBean();
        userBean.setAge(10);

        UserBean userBean1 = new UserBean();
        userBean1.setAge(80);
        userBeanList.add(userBean1);
        userBeanList.add(userBean);

        Object getAdd = in.invokeFunction("getListAdd", userBeanList);
        System.out.println(getAdd);

    }

    /**
     * @Author: rencaiyu
     * @Description: 多方法传递
     * @Date: 8/20/21  5:39 PM
     **/
    private static void getMethodPara() throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String scriptMsg = "function getListAdd(arr){ " +
                "var len =  arr.length; " +
                "if (len<=0){return 0;};" +
                "var sumValue = 0 ;" +
                " for (var i = 0; i <len; i++ ) {" +
//                " sumValue += arr[i].age; " +
                " sumValue =  sum(arr[i].age,sumValue);" +
                "}" +
                "return sumValue;  " +
                "}";
        String scriptMessage = "function sum(a,b){return a+b}";

        Object eval = engine.eval(scriptMsg);
        engine.eval(scriptMessage);

        Invocable in = (Invocable) engine;

        List<UserBean> userBeanList = new ArrayList<>();
        UserBean userBean = new UserBean();
        userBean.setAge(10);

        UserBean userBean1 = new UserBean();
        userBean1.setAge(80);
        userBeanList.add(userBean1);
        userBeanList.add(userBean);

        Object getAdd = in.invokeFunction("getListAdd", userBeanList);
        System.out.println(getAdd);
    }


    /**
     * @Author: rencaiyu
     * @Description: 用来加减乘除
     * @Date: 8/16/21  3:45 PM
     **/
    public static void getScriptSum(BigDecimal valueOne, BigDecimal valueTwo) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        String scriptMsg = "function getAdd(a,b){return a+b}";
        Object eval = engine.eval(scriptMsg);
        Invocable in = (Invocable) engine;

        Object getAdd = in.invokeFunction("getAdd", valueOne, valueTwo);
        System.out.println(getAdd);

    }
}
