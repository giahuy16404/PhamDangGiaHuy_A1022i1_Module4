<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 6/14/2023
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        table {
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
        }

        td {
            padding: 10px;
        }

        button {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<form:form modelAttribute="music" method="post">
    <table>
        <tr>
            <td>Ten bài hát</td>
            <td><form:input path="nameMusic"/></td>
        </tr>
        <tr>
            <td>Nghệ sĩ</td>
            <td><form:input path="author"/></td>
        </tr>
        <tr>
            <td>Music Genres</td>
            <td>
                <form:checkboxes path="musicGenres" items="${musicGenres}"/>
            </td>
        </tr>
        <tr>
            <td>
                Upload File
            </td>
            <td>
                    ${errorFile}
            </td>
            <td><form:input type="file" path="fileMusic"/></td>
        </tr>
        <tr>
            <td>
                <button>Save</button>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
