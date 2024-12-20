package com.group11.moviebooking.util;


import java.util.Map;

public class MapUtil {
    public static <T> T getObject(Map<String, Object> params, String Key, Class<T> tClass) {
        Object obj = params.getOrDefault(Key, null);
        if (obj != null) {//Long
            if (tClass.getTypeName().equals("java.lang.Long")) {
                obj = obj != "" ? Long.valueOf(obj.toString()) : null;
            } else if (tClass.getTypeName().equals("java.lang.Interger")) {
                obj = obj != "" ? Long.valueOf(obj.toString()) : null;
            } else if (tClass.getTypeName().equals("java.lang.String")) {
                obj = obj.toString();
            }
            return tClass.cast(obj);
        }
        return null;
    }
}
