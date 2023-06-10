package com.service;

import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService{
    @Override
    public int resultCaculator(int num1, int num2, String calculations) {
        int result = 0;
        if (calculations.equals("+")){
            result = num1 + num2;
        }else if (calculations.equals("-")){
            result = num1 - num2;
        }else if (calculations.equals("x")){
            result = num1 * num2;
        }else if (calculations.equals("/")){
            result = num1 / num2;
        }
        return result;
    }
}
