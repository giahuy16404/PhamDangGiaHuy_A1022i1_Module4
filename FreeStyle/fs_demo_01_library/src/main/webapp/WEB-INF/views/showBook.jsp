<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 6/11/2023
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sách</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
            text-transform: uppercase;
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

        button {
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

        a {
            text-decoration: none;
        }

        /* Áp dụng CSS cho button Borrow */
        .borrow-button {
            padding: 8px 16px;
            background-color: #3f51b5;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
            text-decoration: none;
            display: inline-block;
            text-transform: uppercase;
        }

        .borrow-button:hover {
            background-color: #303f9f;
        }
    </style>
</head>
<body>
<h1>Danh sách sách đang có</h1>
<table>
    <tr>
        <th>STT</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Số lượng</th>
        <th>Mô tả</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach items="${showList}" var="list" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${list.nameBook}</td>
            <td>${list.authorBook}</td>
            <td>${list.quantityBook}</td>
            <td>${list.describeBook}</td>
            <td><a href="/library/show-borrowing/${status.count}/${list.nameBook}/${list.idBook}" class="borrow-button">Mượn</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
