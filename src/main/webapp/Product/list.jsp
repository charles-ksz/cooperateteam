<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
<table align="center" border="1" cellspacing="0" width="500px">

    <tr>
        <td>id</td>
        <td>name</td>

        <td>edit</td>
        <td>delete</td>
    </tr>

    <s:iterator value="Baseinformations" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>

            <td><a href="editBaseinformation?Baseinformation.id=${p.id}">edit</a></td>
            <td><a href="deleteBaseinformation?Baseinformation.id=${p.id}">delete</a></td>
        </tr>
    </s:iterator>
</table>

<br/>

<form action="addBaseinformation" method="post">
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>
                name:
            </td>
            <td>
                <input type="text" name="Baseinformation.name" value="">
            </td>
        </tr>
        <tr>

            <td>
                <input type="text" name="Baseinformation.price" value="0">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>

</form>

</body>
</html>
