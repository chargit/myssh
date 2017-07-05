<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Admin Login </h1>
<form action="/myssh/login.do?flag=login" method="post" namespace="/">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>pwd:</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td><input type="submit" value="login"></td>
            <td><input type="reset" value="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>