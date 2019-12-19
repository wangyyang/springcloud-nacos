package com.cloud.yanger.commons.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONUtils {
    private static ObjectMapper objectMapper;

    static {
        init();
    }

    private static void init() {
        if (objectMapper == null)
            objectMapper = new CustomObjectMapper();
    }

    /**
     * 对象转json
     */
    public static String toJson(Object obj) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * json 转对象
     */
    public static <T> T toObject(String json, Class c) {
        try {
            return (T) objectMapper.readValue(json, c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
