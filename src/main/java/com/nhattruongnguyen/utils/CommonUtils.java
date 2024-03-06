package com.nhattruongnguyen.utils;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public class CommonUtils {
    public static <T> T getParams(String key, Map<String, Object> params, Class<T> tClass) {
        try {
            return tClass.cast(params.getOrDefault(key, null));
        } catch (Exception e) {
            return null;
        }
    }

    public static String getBaseUrl(HttpServletRequest request) {
        String requestUrl = String.valueOf(request.getRequestURL());
        String contextPath = request.getRequestURI();
        if (contextPath.startsWith("/")) {
            contextPath = contextPath.substring(1, contextPath.length());
        }
        return requestUrl.replace(contextPath, "");
    }
}
