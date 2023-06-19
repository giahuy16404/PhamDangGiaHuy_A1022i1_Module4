CREATE DATABASE fs_demo_01_library;
USE fs_demo_01_library;

CREATE TABLE book(
	id_Book INT AUTO_INCREMENT PRIMARY KEY,
    name_book NVARCHAR(45) NOT NULL,
    author_book NVARCHAR(45) NOT NULL,
    describe_book NVARCHAR(45) NOT NULL,
    quanlity INT NOT NULL
);

INSERT INTO book(name_book,author_book,describe_book,quanlity) VALUES('Sach A','Tac gia A','Mo ta A',15);
INSERT INTO book(name_book,author_book,describe_book,quanlity) VALUES('Sach B','Tac gia B','Mo ta B',15);
INSERT INTO book(name_book,author_book,describe_book,quanlity) VALUES('Sach C','Tac gia C','Mo ta C',15);
INSERT INTO book(name_book,author_book,describe_book,quanlity) VALUES('Sach D','Tac gia D','Mo ta D',15);
INSERT INTO book(name_book,author_book,describe_book,quanlity) VALUES('Sach E','Tac gia E','Mo ta E',15);

CREATE TABLE student(
	id_student INT AUTO_INCREMENT PRIMARY KEY,
    name_student NVARCHAR(45) NOT NULL,
    class_student NVARCHAR(45) NOT NULL
);

INSERT INTO student(name_student,class_student) VALUES ('Hoc sinh A','Lop A');
INSERT INTO student(name_student,class_student) VALUES ('Hoc sinh B','Lop B');
INSERT INTO student(name_student,class_student) VALUES ('Hoc sinh C','Lop C');
INSERT INTO student(name_student,class_student) VALUES ('Hoc sinh D','Lop D');
INSERT INTO student(name_student,class_student) VALUES ('Hoc sinh E','Lop E');

CREATE TABLE borrowing (
	id_borrowing INT AUTO_INCREMENT PRIMARY KEY,
    id_Book INT,
    id_student INT,
    status_borrowing NVARCHAR(45),
    star_borrowing DATE NOT NULL,
    end_borrowing  DATE NOT NULL,
    FOREIGN KEY(id_Book) REFERENCES book(id_Book),
    FOREIGN KEY(id_student) REFERENCES student(id_student)
);

