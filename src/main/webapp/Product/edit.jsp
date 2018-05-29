<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/5/26
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  language="java"
        pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib  prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>学生互助系统注册页面</title>
    <style type="text/css">
        input[type=text], input[type=password] {width: 150px;}
    </style>
</head>
<body>
<div align="center">
    <form action="updateBaseinformation" method="post">


        身份证号：<input type="text" name="baseinformation.id" size="18" value="${baseinformation.id}"><br>
        您的密码：<input type="password" name ="baseinformation.password" value="${baseinformation.password}" ><br>
        确认密码：<input type="password" name ="password1"> <br>
        您的姓名：<input type="text" name="baseinformation.name" size="10" value="${baseinformation.name}" > <br>
        您的学号：<input type="text" name ="baseinformation.studentNumber"  value="${baseinformation.studentNumber}" size="10"><br>
        您的性别：<input type="radio" name="baseinformation.sex" value="${baseinformation.sex}" checked >男
        <input type="radio" name="baseinformation.sex" value="${baseinformation.sex}"> 女     <br>
        联系电话：<input type="text" name ="baseinformation.phonenumber" value="${baseinformation.phoneNumber}" size="11"> <br>
        邮箱账号：<input type="text" name="baseinformation.mailAccount" value="${baseinformation.mailAccount}"><br>
        您的学院：<input type="text" name="baseinformation.academy" value="${baseinformation.academy}"><br>
        <input  type="submit" name="button1" value="提交">


    </form>
</div>
</body>
</html>
