package com.hubo.json.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubo.json.common.model.Order;
import com.hubo.json.common.util.JsonFileUtils;

import java.io.IOException;

public class JackSonTest {
    public static void main(String[] args) throws IOException {
        String json = JsonFileUtils.readJsonFile("order.json");
        ObjectMapper mapper=new ObjectMapper();
        Order order = mapper.readValue(json, new TypeReference<Order>() {
        });
        System.out.println(order);
    }
}
