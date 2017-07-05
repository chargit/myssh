<%--
  Created by IntelliJ IDEA.
  User: ww
  Date: 2017/6/27
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>add a user</h1>
<form action="${pageContext.request.contextPath}/employee.do?flag=addEmp" method="post">
    <table>
        <tr>
            <td>name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>grade</td>
            <td><input type="text" name="grade"></td>
        </tr>
        <tr>
            <td>pwd</td>
            <td><input type="text" name="pwd"></td>
        </tr>
        <tr>
            <td>salary</td>
            <td><input type="text" name="salary"></td>
        </tr>
        <tr>
            <td>department</td>
            <td><select name="departmentId">
                <option value="1">IT</option>
                <option value="2">MANAGE</option>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="add"></td>
            <td><input type="reset" value="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
