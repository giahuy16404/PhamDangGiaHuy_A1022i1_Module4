package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class StatusBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatusBlog;
    private LocalDate timeCreateBlog;
    private Long likeBlog;
    private LocalDate timeLikeBlog;

    public StatusBlog(int idStatusBlog, LocalDate timeCreateBlog, Long likeBlog, LocalDate timeLikeBlog) {
        this.idStatusBlog = idStatusBlog;
        this.timeCreateBlog = timeCreateBlog;
        this.likeBlog = likeBlog;
        this.timeLikeBlog = timeLikeBlog;
    }

    public StatusBlog() {
    }

    public int getIdStatusBlog() {
        return idStatusBlog;
    }

    public void setIdStatusBlog(int idStatusBlog) {
        this.idStatusBlog = idStatusBlog;
    }

    public LocalDate getTimeCreateBlog() {
        return timeCreateBlog;
    }

    public void setTimeCreateBlog(LocalDate timeCreateBlog) {
        this.timeCreateBlog = timeCreateBlog;
    }

    public Long getLikeBlog() {
        return likeBlog;
    }

    public void setLikeBlog(Long likeBlog) {
        this.likeBlog = likeBlog;
    }

    public LocalDate getTimeLikeBlog() {
        return timeLikeBlog;
    }

    public void setTimeLikeBlog(LocalDate timeLikeBlog) {
        this.timeLikeBlog = timeLikeBlog;
    }
}
