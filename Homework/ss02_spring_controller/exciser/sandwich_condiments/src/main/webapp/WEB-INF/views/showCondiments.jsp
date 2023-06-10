<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 6/10/2023
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich/condiments" method="post">
<input type="checkbox" value="1" name="condiments" id="1"> <label for="1">Lettuce</label>
<input type="checkbox" value="2" name="condiments" id="2"> <label for="2">Tomato</label>
<input type="checkbox" value="3" name="condiments" id="3"> <label for="3">Mustard</label>
<input type="checkbox" value="4" name="condiments" id="4"> <label for="4">Sprouts</label>
    <hr>
 <button>Save</button>
</form>
</body>
</html>
