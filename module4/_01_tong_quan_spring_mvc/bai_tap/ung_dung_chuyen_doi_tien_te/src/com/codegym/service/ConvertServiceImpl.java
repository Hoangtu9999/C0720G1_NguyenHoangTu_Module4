package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService{
    @Override
    public Double convert(double number1) {
        return number1 * 23000;
    }
}
