package com.nhattruongnguyen.utils;

public class CommonUtils {
    public static <T> T getParams(Object value, Class<T> tClass) {
        try {
            return tClass.cast(value);
        } catch (Exception e) {
            return null;
        }
    }
}
