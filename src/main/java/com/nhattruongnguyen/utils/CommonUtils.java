package com.nhattruongnguyen.utils;

import java.util.Map;

public class CommonUtils {
    public static <T> T getParams(String key, Map<String, Object> params, Class<T> tClass) {
        try {
            return tClass.cast(params.getOrDefault(key, null));
        } catch (Exception e) {
            return null;
        }
    }
}
