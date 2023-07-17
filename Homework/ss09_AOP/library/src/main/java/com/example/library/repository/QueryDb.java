package com.example.library.repository;

public class QueryDb {
    public static final String SHOW_MAX_ID_BORROWED = "SELECT MAX(borrowed_card_id) FROM borrowed_card";
    public static final String SHOW_BY_CODE_DETAIL_CARD = "SELECT * FROM detail_borrowed_card \n" +
            "JOIN borrowed_card ON detail_borrowed_card.borrowed_card_id = borrowed_card.borrowed_card_id\n" +
            "JOIN book ON detail_borrowed_card.book_id = book.book_id WHERE borrowed_card.code_borrowed_card LIKE :code";
    public static final String REMOVE_BORROWED_BOOKS = "DELETE FROM detail_borrowed_card WHERE borrowed_card_id Like :borrowedCard AND book_id LIKE :idBooks";
    public static final String BORROWED_QUANTITY_MINUS_ONE = "UPDATE borrowed_card SET quantity_borrowed_books = quantity_borrowed_books - 1 " +
            "WHERE borrowed_card.borrowed_card_id = :idBorrowed";
    public static final String BORROWED_BOOK_MINUS_ONE = "UPDATE book SET book.quantity = book.quantity - 1 WHERE book.book_id = :idBook";
    public static final String BORROWED_BOOK_INCREASE = "UPDATE book SET book.quantity = book.quantity + 1 WHERE book.book_id = :idBook";
    public static final String CHECK_QUANTITY_BOOK = "SELECT book.quantity FROM book WHERE book.book_id = :idBook";
    public static final String CHECK_CODE_CARD = "SELECT borrowed_card.code_borrowed_card FROM borrowed_card WHERE borrowed_card.code_borrowed_card = :code";
}
