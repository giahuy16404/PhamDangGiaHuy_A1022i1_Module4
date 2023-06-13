<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h3 style="color: #000000">${showTime}</h3>
<form id="locale" method="post" action="/time-now-world">
    <select name="world" onchange="document.getElementById('locale').submit()">
        <option value="vn">Viet Nam</option>
        <option value="usa"> Myx</option>
        <option value="trung"> Trung</option>
    </select>
</form>
</body>
</html>