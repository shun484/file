package com.order_server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();


    /**
     *  json字符串转jsonNode对象方法
     * @param object
     * @return
     */
    public static JsonNode str2JsonNode(String object){
        try {
            return objectMapper.readTree(object);
        } catch (JsonProcessingException e) {
           return null;
        }
    }
}
