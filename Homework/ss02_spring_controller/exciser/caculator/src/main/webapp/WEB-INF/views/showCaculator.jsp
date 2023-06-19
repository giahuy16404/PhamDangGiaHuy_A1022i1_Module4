<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 6/10/2023
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/caculator/result" method="post">
    <input type="number" placeholder="Number 1" name="num1">
    <input type="number" placeholder="Number 2" name="num2">
    <table>
        <tr>
            <td>
                <button name="calculations" value="+">Addition(+)</button>
            </td>
            <td>
                <button name="calculations" value="-">Subtraction(-)</button>
            </td>
            <td>
                <button name="calculations" value="x">Multiplication(x)</button>
            </td>
            <td>
                <button name="calculations" value="/">Division(/)</button>
            </td>
        </tr>
        <tr>
            <td>Result Division:</td>
            <td>${result}</td>
        </tr>
    </table>
</form>

</body>
</html>
