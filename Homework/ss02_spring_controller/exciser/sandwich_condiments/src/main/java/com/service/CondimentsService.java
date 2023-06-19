package com.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CondimentsService implements ICondimentsService {
    @Override
    public List<String> showCondiments(String[] condiments) {
        List<String> list = new ArrayList<>();
        String result = null;
        for (String s : condiments) {
            if (s.equals("1")) {
                result = "Lettuce";
                list.add(result);
            } else if (s.equals("2")) {
                result = "Tomato";
                list.add(result);
            } else if (s.equals("3")) {
                result = "Mustard";
                list.add(result);
            } else if (s.equals("4")) {
                result = "Sprouts";
                list.add(result);
            }
        }
        return list;
    }
}
