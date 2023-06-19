package com.repository;

public class QueryDB {

    public static String SELECT_BOOK = "SELECT * FROM fs_demo_01_library.book;";
    public static String SELECT_STUDENT = "SELECT * FROM fs_demo_01_library.student;";
    public static String INSERT_INTO_BORROWING = "INSERT INTO borrowing(id_Book,id_student," +
            "status_borrowing,star_borrowing,end_borrowing) VALUES (?,?,?,?,?);";

    public static String SELECT_BORROWING = "SELECT  borrowing.id_borrowing,book.name_book,book.author_book,student.name_student,student.class_student,borrowing.star_borrowing,borrowing.end_borrowing\n" +
            "FROM borrowing JOIN book ON  borrowing.id_Book = book.id_Book \n" +
            "JOIN student ON borrowing.id_student = student.id_student;";
}
