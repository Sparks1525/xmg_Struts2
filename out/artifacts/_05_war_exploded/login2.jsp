<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2019/1/11
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>paramAndScope.login</title>
</head>

<h3>获取三大作用域的方式</h3>
<form action="/login/login3" method="post">
    账号:<input type="text" name="username"/></br>
    密码:<input type="number" name="password"/></br>
    <input type="submit" value="朕要登录">
</form>

</hr>

<h3>三种获取parameter的方式</h3>

<form action="/paramAndScope/parameter1" method="post">
    账号:<input type="text" name="username"/></br>
    密码:<input type="number" name="password"/></br>
    <input type="submit" value="朕要登录">
</form>

</hr>

<form action="/paramAndScope/parameter2" method="post">
    账号:<input type="text" name="user.username"/></br>
    密码:<input type="number" name="user.password"/></br>
    <input type="submit" value="朕要登录">
</form>

</hr>

<form action="/paramAndScope/parameter3" method="post">
    账号:<input type="text" name="username"/></br>
    密码:<input type="number" name="password"/></br>
    <input type="submit" value="朕要登录">
</form>

</body>
</html>
