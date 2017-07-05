<%--
  Created by IntelliJ IDEA.
  User: ww
  Date: 2017/7/5
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
update a user

<form action="${pageContext.request.contextPath}/employee.do?flag=updEmp" method="post">
    <table>
        <tr>
            <td>id</td>
            <td><input type="text" name="id" value="${emp.id}" readonly="readonly" disabled="disabled"></td>
        </tr>
        <tr>
            <td>name</td>
            <td><input type="text" name="name" value="${emp.name}"></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name="email" value="${emp.email}"></td>
        </tr>
        <tr>
            <td>grade</td>
            <td><input type="text" name="grade" value="${emp.grade}"></td>
        </tr>
        <tr>
            <td>pwd</td>
            <td><input type="text" name="pwd" value="${emp.pwd}"></td>
        </tr>
        <tr>
            <td>salary</td>
            <td><input type="text" name="salary" value="${emp.salary}"></td>
        </tr>
        <tr>
            <td>department</td>
            <td><select name="departmentId">
                <option value="1">IT</option>
                <option value="2">MANAGE</option>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="update"></td>
            <td><input type="reset" value="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
