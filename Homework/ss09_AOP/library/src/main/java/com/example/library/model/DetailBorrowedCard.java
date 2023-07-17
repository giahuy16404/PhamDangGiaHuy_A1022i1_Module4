package com.example.library.model;

import javax.persistence.*;

@Entity
public class DetailBorrowedCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_borrowed_card_id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "book_id",nullable = false,referencedColumnName = "book_id")
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "borrowed_card_id",nullable = false,referencedColumnName = "borrowed_card_id")
    private BorrowedCard borrowedCard;

    public DetailBorrowedCard() {
    }

    public DetailBorrowedCard(int id, Book book, BorrowedCard borrowedCard) {
        this.id = id;
        this.book = book;
        this.borrowedCard = borrowedCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BorrowedCard getBorrowedCard() {
        return borrowedCard;
    }

    public void setBorrowedCard(BorrowedCard borrowedCard) {
        this.borrowedCard = borrowedCard;
    }
}
