package com.codegym.service.impl;

import com.codegym.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public double calculate(double number1, double number2, String calculate) {
        double result = 0;
        switch (calculate){
            case "+":
                result = plus(number1,number2);
                break;
            case "-":
                result = minus(number1,number2);
                break;
            case "*":
                result = multiply(number1,number2);
                break;
            case "/":
                result = share(number1,number2);
                break;
        }
        return result;
    }

    private double plus(double number1, double number2) {
        return number1 + number2;
    }
    private double minus(double number1, double number2) {
        return number1 - number2;
    }
    private double multiply(double number1, double number2) {
        return number1 * number2;
    }
    private double share(double number1, double number2) {
        return number1 / number2;
    }
}
