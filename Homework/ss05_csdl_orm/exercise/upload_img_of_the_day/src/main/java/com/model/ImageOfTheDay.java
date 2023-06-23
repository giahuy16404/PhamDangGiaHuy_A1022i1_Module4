package com.model;

import org.hibernate.annotations.Persister;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ImageOfTheDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    @ManyToOne()
    @JoinColumn(name = "idSco", nullable = false, referencedColumnName = "idSco")
    private ScoringScale scoringScale;
    private String feedback;
    private LocalDate startDate;
    private int likeComment;

    public ImageOfTheDay(int id, String author, ScoringScale scoringScale, String feedback, LocalDate startDate, int likeComment) {
        this.id = id;
        this.author = author;
        this.scoringScale = scoringScale;
        this.feedback = feedback;
        this.startDate = startDate;
        this.likeComment = likeComment;
    }

    public ImageOfTheDay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ScoringScale getScoringScale() {
        return scoringScale;
    }

    public void setScoringScale(ScoringScale scoringScale) {
        this.scoringScale = scoringScale;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getLikeComment() {
        return likeComment;
    }

    public void setLikeComment(int likeComment) {
        this.likeComment = likeComment;
    }
}
