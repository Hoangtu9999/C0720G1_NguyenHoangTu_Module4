package com.codegym.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    private static Map<String, String> stringMap;

    static {
        stringMap = new HashMap<>();
        stringMap.put("hello", "Xin chào");
        stringMap.put("1", "One");
        stringMap.put("2", "Two");
        stringMap.put("Red", "Màu đỏ");
        stringMap.put("Black", "Màu đen");
    }

    @Override
    public String search(String english) {
        return stringMap.get(english);
    }
}
