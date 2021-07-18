package com.white.daily.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Jackson序列化和反序列化
 *
 * @author yifeng
 */
@Slf4j
public class JacksonUtil {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    static {
        JavaTimeModule timeModule = new JavaTimeModule();
        JSON_MAPPER.registerModule(timeModule);
        // 不将date转化成timestamp
        JSON_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // 不将空转化为null
        JSON_MAPPER.disable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    /**
     * 获取默认的jackson mapper
     */
    public static ObjectMapper getNewDefaultMapper() {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule timeModule = new JavaTimeModule();
        mapper.registerModule(timeModule);
        // 不将date转化成timestamp
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // 不将空转化为null
        mapper.disable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        return mapper;
    }

    /**
     * 使用默认的序列化mapper进行json序列化
     */
    public static String serialize(Object obj) {
        return serialize(obj, null);
    }

    /**
     * 自定义jackson mapper的序列化方法
     */
    public static String serialize(Object obj, ObjectMapper jacksonMapper) {
        if (obj == null) {
            return null;
        }
        try {
            return jacksonMapper == null ? JSON_MAPPER.writeValueAsString(obj) : jacksonMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
           // LogUtils.error(log, LogLevelEnum.P1, "JacksonUtil.serialize,{}", obj, e);
        }
        return null;
    }

    /**
     * 自定义jackson mapper的序列化方法 序列化成byte数组
     */
    public static byte[] serialize2Array(Object obj, ObjectMapper jacksonMapper) {
        if (obj == null) {
            return null;
        }
        try {
            return jacksonMapper == null ? JSON_MAPPER.writeValueAsBytes(obj) : jacksonMapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
           // LogUtils.error(log, LogLevelEnum.P1, "JacksonUtil.serialize,{}", obj, e);
        }
        return null;
    }

    /**
     * 使用默认的序列化mapper进行json反序列化
     */
    public static <T> T fastSerialize(String json, Class<T> clazz) {
        return deserialize(json, clazz, null);
    }


    /**
     * 使用默认的序列化mapper进行json反序列化
     */
    public static <T> T deserialize(String json, Class<T> clazz) {
        return deserialize(json, clazz, null);
    }

    /**
     * 自定义jackson mapper的反序列化方法
     */
    public static <T> T deserialize(String json, Class<T> clazz, ObjectMapper jacksonMapper) {
        if (json == null || "".equals(json)) {
            return null;
        }
        try {
            return jacksonMapper == null ? JSON_MAPPER.readValue(json, clazz) : jacksonMapper.readValue(json, clazz);
        } catch (IOException e) {
           // LogUtils.error(log, LogLevelEnum.P1, "JacksonUtil.serialize,{}", json, e);
        }
        return null;
    }


    /**
     * 自定义jackson mapper的反序列化方法
     */
    public static <T> T deserializeWithBytes(byte[] json, Class<T> clazz, ObjectMapper jacksonMapper) {
        if (json == null || json.length == 0) {
            return null;
        }
        try {
            return jacksonMapper == null ? JSON_MAPPER.readValue(json, clazz) : jacksonMapper.readValue(json, clazz);
        } catch (IOException e) {
          //  LogUtils.error(log, LogLevelEnum.P1, "JacksonUtil.serialize,{}", json, e);
        }
        return null;
    }

    /**
     * 反序列化数组，默认mapper
     */
    public static <T> List<T> deserializeArray(String json, Class<T> clazz) {
        return deserializeArray(json, clazz, null);
    }

    /**
     * 反序列化数组，给定mapper
     */
    public static <T> List<T> deserializeArray(String json, Class<T> clazz, ObjectMapper jacksonMapper) {
        ObjectMapper objectMapper = (jacksonMapper == null ? JSON_MAPPER : jacksonMapper);
        JavaType listType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
        try {
            return objectMapper.readValue(json, listType);
        } catch (Exception e) {
            //LogUtils.error(log, LogLevelEnum.P1, "JacksonUtil.deserializeArray exception: ", e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 引用类型（容器类型）的反序列化，默认mapper
     */
    public static <T> T deserializeReference(String json, TypeReference<T> typeReference) {
        return deserializeReference(json, typeReference, null);
    }

    /**
     * 引用类型（容器类型）的反序列化，给定mapper
     */
    public static <T> T deserializeReference(String json, TypeReference<T> typeReference, ObjectMapper jacksonMapper) {
        try {
            return jacksonMapper == null ? JSON_MAPPER.readValue(json, typeReference) : jacksonMapper.readValue(json, typeReference);
        } catch (IOException e) {
           // LogUtils.error(log, LogLevelEnum.P1, "JacksonUtil.deserializeArray exception: ", e);
        }
        return null;
    }
}
