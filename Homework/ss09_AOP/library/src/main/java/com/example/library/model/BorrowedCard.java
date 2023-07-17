package com.example.library.model;

import javax.persistence.*;

@Entity
public class BorrowedCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowed_card_id")
    private int id;
    private String codeBorrowedCard;
    @Column(columnDefinition = "DATE")
    private String starBorrowed;
    private int quantityBorrowedBooks;

    public BorrowedCard(int id, String codeBorrowedCard, String starBorrowed, int quantityBorrowedBooks) {
        this.id = id;
        this.codeBorrowedCard = codeBorrowedCard;
        this.starBorrowed = starBorrowed;
        this.quantityBorrowedBooks = quantityBorrowedBooks;
    }

    public BorrowedCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeBorrowedCard() {
        return codeBorrowedCard;
    }

    public void setCodeBorrowedCard(String codeBorrowedCard) {
        this.codeBorrowedCard = codeBorrowedCard;
    }

    public String getStarBorrowed() {
        return starBorrowed;
    }

    public void setStarBorrowed(String starBorrowed) {
        this.starBorrowed = starBorrowed;
    }

    public int getQuantityBorrowedBooks() {
        return quantityBorrowedBooks;
    }

    public void setQuantityBorrowedBooks(int quantityBorrowedBooks) {
        this.quantityBorrowedBooks = quantityBorrowedBooks;
    }
}
