<%--
  Created by IntelliJ IDEA.
  User: ww
  Date: 2017/6/30
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user list</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" language="JavaScript">
        $(document).ready(function(){
            $(".delid").click(function(){

                return window.confirm("are you sure to delete it?");
            });
        });


    </script>

</head>
<body>
User List

<table>
    <tr>
        <td>id</td><td>name</td><td>email</td><td>grade</td><td>salary</td><td>update user</td><td>delete user</td>
    </tr>
<c:forEach items="${emplist}" var="emp">
    <tr>
        <td>${emp.id}</td><td>${emp.name}</td><td>${emp.email}</td><td>${emp.grade}</td>
        <td>${emp.salary}</td><td><a href="${pageContext.request.contextPath}/employee.do?flag=goUpdEmpUi&&id=${emp.id}"> update </a></td><td>
        <a class="delid" href="${pageContext.request.contextPath}/employee.do?flag=delEmp&&id=${emp.id}">delete </a></td>
    </tr>
</c:forEach>
</table>
<c:forEach begin="1" end="${pageCount}" var="i">
    <a href="${pageContext.request.contextPath}/employee.do?flag=goListEmpUi&&pageNow=${i}">${i}</a>
</c:forEach>
</body>
</html>
