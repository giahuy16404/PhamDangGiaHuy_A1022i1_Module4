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
    private Long viewBlog;
    private LocalDate timeViewBlog;

    public StatusBlog() {
    }

    public StatusBlog(int idStatusBlog, LocalDate timeCreateBlog, Long likeBlog, Long viewBlog, LocalDate timeViewBlog) {
        this.idStatusBlog = idStatusBlog;
        this.timeCreateBlog = timeCreateBlog;
        this.likeBlog = likeBlog;
        this.viewBlog = viewBlog;
        this.timeViewBlog = timeViewBlog;
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

    public Long getViewBlog() {
        return viewBlog;
    }

    public void setViewBlog(Long viewBlog) {
        this.viewBlog = viewBlog;
    }

    public LocalDate getTimeViewBlog() {
        return timeViewBlog;
    }

    public void setTimeViewBlog(LocalDate timeViewBlog) {
        this.timeViewBlog = timeViewBlog;
    }
}
