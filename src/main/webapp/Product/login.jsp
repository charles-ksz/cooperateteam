<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>学生互助系统登录页面</title>
    <style type="text/css">
        input[type=text], input[type=password] {width: 150px;}
    </style>
</head>
<body>
<div align="center">
    <form action="login" method="post">
        用户名:<input type="text" name="username" /><br />
        密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" /><br />
        <input type="submit" value="登录" />
        <input type="reset" value="重置" />

    </form>
</div>
</body>
</html>