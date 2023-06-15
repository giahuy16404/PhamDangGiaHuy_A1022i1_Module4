package com.model;

import java.io.File;

public class FileMusic {
    private int id;
    private String nameMusic;
    private String author;
    private String musicGenres;
    private String fileMusic;

    public FileMusic(int id, String nameMusic, String author, String musicGenres, String fileMusic) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.author = author;
        this.musicGenres = musicGenres;
        this.fileMusic = fileMusic;
    }

    public FileMusic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMusicGenres() {
        return musicGenres;
    }

    public void setMusicGenres(String musicGenres) {
        this.musicGenres = musicGenres;
    }

    public String getFileMusic() {
        return fileMusic;
    }

    public void setFileMusic(String fileMusic) {
        this.fileMusic = fileMusic;
    }
}
