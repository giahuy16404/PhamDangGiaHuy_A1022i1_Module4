package com.service;

import org.springframework.stereotype.Service;

@Service
public class SwapService implements ISwapService{

    @Override
    public String swap(String english) {
        String[] englishArr = {"hello","goodbye","see you","thank you"};
        String[] vietNamArr = {"Xin chào","Tạm Biệt","Hẹn Gặp Lại","Cảm Ơn"};
        String result = null;
        for (int i = 0; i < englishArr.length ; i++) {

            if (englishArr[i].equals(english)){
                result =  vietNamArr[i];
                break;
            }else {
                result = "Không có từ này trong từ điển!";
            }
        }
        return result;
    }
}
