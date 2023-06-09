<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<fieldset style="width: 400px">
    <legend>Swap</legend>
    <form action="/swap" method="post">
        <table>
            <tr>
                <td>Nhập English</td>
                <td><input type="text" name="english" required></td>
            </tr>
            <tr>
                <td>Result Viet Nam:</td>
                <td>${result}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Swap"></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>