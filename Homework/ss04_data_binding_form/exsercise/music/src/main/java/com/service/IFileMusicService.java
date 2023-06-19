package com.service;

import com.model.FileMusicString;

import java.util.List;

public interface IFileMusicService {
    boolean checkFile(String file);
    boolean add(FileMusicString fileMusic);
    List<FileMusicString> showList();
}
