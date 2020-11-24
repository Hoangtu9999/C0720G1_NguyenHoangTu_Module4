package com.codegym.service.impl;

import com.codegym.service.SandwichService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SandwichServiceImpl implements SandwichService {

    private static Map<Integer,String> stringMap;

    static {
        stringMap = new TreeMap<>();
        stringMap.put(1,"Lettuce");
        stringMap.put(2,"Tomato");
        stringMap.put(3,"Mustard");
        stringMap.put(4,"Sprouts");
    }

    @Override
    public ArrayList findAll() {
        return new ArrayList(stringMap.values());
    }
}
