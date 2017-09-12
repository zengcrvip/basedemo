package demo.utils;

import java.lang.reflect.Type;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.inject.util.Types;

public class JsonUtils {
    
    private static Gson gson = new Gson();

    public static String toJson(Object obj) throws Exception {
        return gson.toJson(obj);
    }

    public static String toJsonUseObjectMapper(Object obj) throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.writeValueAsString(obj);
    }

    public static Object fromJson(String json, Class<?> clazz) throws Exception {
        if (json.startsWith("[")) {
            return gson.fromJson(json, getType(clazz));
        }
        return gson.fromJson(json, clazz);
    }

    public static <T> T fromJsonUseObjectMapper(String json, Class<T> clazz) throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
//        objMapper.configure(org.codehaus.jackson.JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        return objMapper.readValue(json, clazz);
    }

    public static <T> T fromJsonWithoutArray(String json, Class<T> clazz) throws Exception {
        return gson.fromJson(json, clazz);
    }

    private static Type getType(Class<?> clazz) throws Exception {
        return Types.newParameterizedTypeWithOwner(null, List.class, new Type[] { clazz });
    }

    public static String formatJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }
    
}
