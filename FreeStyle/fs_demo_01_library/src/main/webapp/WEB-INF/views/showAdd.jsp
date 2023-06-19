<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 6/11/2023
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Muon sach</h1>
<form action="/library/add-borrowing" method="post">
    <table>
        <tr>
            <td>Ma muon sach</td>
            <td><input type="text" value="${count}" readonly></td>
        </tr>
        <tr>
            <td>Ten sach</td>
            <td><input type="text" value="${nameBook}" readonly name="nameBook"></td>
        </tr>
        <tr>
            <td>Ten hoc sinh</td>
            <td>
                <select name="student">
                    <c:forEach items="${getStudent}" var="list">
                        <option value="${list.idStudent}">${list.nameStudent}</option>
                    </c:forEach>
                </select>

            </td>
        </tr>
        <tr>
            <td>Ngay muon sach</td>
            <td><input type="text" value="${starDate}" readonly name="starDate"></td>
        </tr>
        <tr>
            <td>Ngay tra sach</td>
            <td><input type="date" name="endDate"></td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr>
            <td>
                <button>Muon</button>
            </td>
            <td><a href="/library/book">
                <button>Huy</button>
            </a></td>
        </tr>
    </table>
    <input type="hidden" value="${idBook}" name="idBook">
</form>

</body>
</html>
