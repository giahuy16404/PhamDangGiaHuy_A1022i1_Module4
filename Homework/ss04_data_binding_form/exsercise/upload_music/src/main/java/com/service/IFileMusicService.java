package com.service;

import com.model.FileMusic;

import java.util.List;

public interface IFileMusicService {
    boolean checkFile(String file);
    boolean add(FileMusic fileMusic);
    List<FileMusic> showList();
}
