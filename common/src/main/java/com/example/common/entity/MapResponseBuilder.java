package com.example.common.entity;

import javafx.util.Builder;

import java.util.HashMap;
import java.util.Map;

/**
 * com.example.common.entity
 *
 * @author zhouke
 * 2022/4/29
 * 21:03
 * 多返回结果时,可以使用这个封装
 */
public class MapResponseBuilder implements Builder<Map<String,Object>> {
    Map<String,Object> map;
    
    public MapResponseBuilder() {
        map = new HashMap<>();
    }

    @Override
    public Map<String, Object> build() {
        return map;
    }

    public MapResponseBuilder data(String key,Object value){
        map.put(key,value);
        return this;
    }
    
    public MapResponseBuilder data(Map<String,Object> map){
        this.map.putAll(map);
        return this;    }
}
