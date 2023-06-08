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
                <td>Nhập USD</td>
                <td><input type="number" name="usd"></td>
            </tr>
            <tr>
                <td>Thành tiền VND</td>
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