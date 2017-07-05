<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>welcome ${loginuser.name} ${loginuser.department.name} please select</h1>
<a href="${pageContext.request.contextPath}/employee.do?flag=addEmpUi">add a employee</a><br/>
<a href="${pageContext.request.contextPath}/employee.do?flag=goListEmpUi">show a employee</a><br/>
<a href="#">search a employee</a><br/>
<a href="#">exit</a><br/>


</body>
</html>