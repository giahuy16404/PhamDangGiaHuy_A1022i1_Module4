<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sách</title>
    <style>
        body {
            padding: 30px;
            font-family: Arial, sans-serif;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
            text-transform: uppercase;
        }

        form {
            margin-bottom: 20px;
        }

        label {
            position: relative;
            left: 430px;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"] {
            position: relative;
            left: 430px;
            padding: 8px;
            width: 200px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        button {
            position: relative;
            left: 450px;
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        button:hover {
            background-color: #45a049;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
            color: #333;
        }

        td:first-child {
            text-align: center;
        }

        .delete-button {
            padding: 8px 16px;
            background-color: #f44336;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        .delete-button:hover {
            background-color: #d32f2f;
        }
        #count{
            width: 100px;
        }
    </style>
</head>
<body>
<h1>Thống kê sách đang cho mượn</h1>
<form action="/library/findBy" method="post">
    <label for="findSach">Tên sách</label>
    <input type="text" name="findSach" id="findSach" placeholder="Tìm theo tên sách">

    <label for="findTenHocSinh">Tên học sinh</label>
    <input type="text" name="findTenHocSinh" id="findTenHocSinh" placeholder="Tìm theo tên học sinh">

    <button>Tìm kiếm</button>
</form>

<table>
    <tr>
        <th>Ma mượn sách</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Tên học sinh</th>
        <th>Lớp</th>
        <th>Ngày mượn</th>
        <th>Ngày trả</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${showList}" var="list" varStatus="status">
        <tr>
            <td id="count">${status.count}</td>
            <td>${list.book.nameBook}</td>
            <td>${list.book.authorBook}</td>
            <td>${list.student.nameStudent}</td>
            <td>${list.student.classStudent}</td>
            <td>${list.starBorrowing}</td>
            <td>${list.endBorrowing}</td>
            <td>
                <form action="/library/delete/${list.idBorrowing}">
                    <input type="submit" class="delete-button" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>