<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 6/15/2023
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Music</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<h1>List of Music</h1>
<table>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Author</th>
        <th>Genres</th>
    </tr>
    <c:forEach items="${showList}" var="s" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${s.nameMusic}</td>
            <td>${s.author}</td>
            <td>${s.musicGenres}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
