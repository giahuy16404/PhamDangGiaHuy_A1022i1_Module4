package com.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class ShowTime implements IShowTimeService{
    @Override
    public String showTime(String word) {
        String timeWord = null;
        Date date = new Date();
        if (word.equals("vn")){
            TimeZone timeZone = TimeZone.getDefault();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            simpleDateFormat.setTimeZone(timeZone);
            timeWord = simpleDateFormat.format(date);
        } else if (word.equals("usa")) {
            TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            simpleDateFormat.setTimeZone(timeZone);
            timeWord = simpleDateFormat.format(date);
        }else if (word.equals("trung")){
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            simpleDateFormat.setTimeZone(timeZone);
            timeWord = simpleDateFormat.format(date);
        }
        return timeWord;
    }
}
