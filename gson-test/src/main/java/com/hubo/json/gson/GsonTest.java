package com.hubo.json.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hubo.json.common.model.Order;
import com.hubo.json.common.util.JsonFileUtils;

public class GsonTest {
    public static void main(String[] args) {
        String json = JsonFileUtils.readJsonFile("order1.json");
        Gson gson=new Gson();
        Order order = gson.fromJson(json, new TypeToken<Order>() {
        }.getType());
        System.out.println(order);

    }
}
