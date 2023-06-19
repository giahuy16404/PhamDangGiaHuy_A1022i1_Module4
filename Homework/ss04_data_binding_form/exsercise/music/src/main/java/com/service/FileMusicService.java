package com.service;

import com.model.FileMusicString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileMusicService implements IFileMusicService {
    List<FileMusicString> list = new ArrayList<>();
    @Autowired
    IFileMusicService iFileMusicService;

    @Override
    public boolean checkFile(String file) {
        int index = file.lastIndexOf(".");
        String fileExtension = file.substring(index + 1);
        if (fileExtension.equals("mp3") ||
                fileExtension.equals("wav") ||
                fileExtension.equals("ogg") ||
                fileExtension.equals("m4p")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(FileMusicString fileMusic) {
        list.add(fileMusic);
        return true;
    }

    @Override
    public List<FileMusicString> showList() {
        return list;
    }
}
