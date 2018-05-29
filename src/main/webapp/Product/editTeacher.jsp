<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/5/28
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>学生互助系统教师注册</title>
</head>
<body>
        <form action="addT" method="post">

        <div align="center">
            <s:iterator  value="teacher" var="t">
                身份证号： <input name="t.id" type="text" value="">
                擅长科目：<input name="t.goodSubect" type="text " value="">
                空闲时间：<input name="t.freeTime"  type="text" value="">
                所获荣誉：<input name="t.honor" type="text" value=" ">
                备&nbsp;&nbsp;注：<input name="t.remark" type="text" value="想对大家说的"  >
                <input type="submit" value="提交">
            </s:iterator>

        </div>
        </form>
</body>
</html>
