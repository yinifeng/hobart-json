package com.hubo.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hubo.json.common.model.Order;
import com.hubo.json.common.util.JsonFileUtils;


public class FastJsonTest {

    public static void main(String[] args) {
        //读取json文件
        String json = JsonFileUtils.readJsonFile("order1.json");
        System.out.println(json);
        System.out.println(System.getProperty("user.dir"));
        JSONObject jsonObject = JSONObject.parseObject(json);
        Order order = JSONObject.toJavaObject(jsonObject, Order.class);
        System.out.println("order->"+order);
        System.out.println("---------------------");
        Order order1 = JSON.parseObject(json, Order.class);
        System.out.println("order1->"+order1);
    }
}
