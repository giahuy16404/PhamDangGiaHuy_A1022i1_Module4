package com.service;

import org.springframework.stereotype.Service;

@Service
public class SwapMoney implements ISwapMoney {
    @Override
    public double swap(double usd) {
        return usd * 23;
    }
}