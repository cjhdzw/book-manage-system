
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Register</title>

    <style>
        input{
            border: 1px solid #5599FF;
            padding: 7px 0px;
            border-radius: 3px; /*css3属性IE不支持*/
            padding-left:5px;
        }
        h1
        {
            background: #5599FF;
            text-shadow: #1Effff;
        }
        h3
        {

        }
        .sub
        {
            border:2px solid;
            padding:3px 20px;
            background: #2Effff;
            -webkit-border-radius: 25px;
        }
        .but
        {
            border:2px solid;
            padding:3px 60px;
            background: #5599FF;
            -webkit-border-radius: 25px;
        }
    </style>
</head>
<body>
<form action="RegisterServlet" method="post">
    <div align="center">
        <h1>Register</h1>
    </div>
    <div align="center">
        <h3>username</h3><input type="text" name="username" placeholder="username">
        <h3>password</h3><input type="password" name="password1" placeholder="password">
        <h3>password</h3><input type="password" name="password2" placeholder="repeat password">
        <br><br><input type="submit" value="register" class="but">
    </div>
</form>
</body>
</html>
