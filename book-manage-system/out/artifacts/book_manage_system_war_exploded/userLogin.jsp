
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        h1
        {
            background: aqua;
        }
        .in{
            border: 1px solid #ccc;
            padding: 7px 0px;
            border-radius: 3px; /*css3属性IE不支持*/
            padding-left:5px;
        }
        .sub
        {
            border:2px solid;
            padding:3px 20px;
            background: #2Effff;
            -webkit-border-radius: 25px;
        }
        .ma
        {
            border:2px solid;
            padding:3px 38px;
            background: #cccccc;
            -webkit-border-radius: 25px;
        }
        .but
        {
            border:2px solid;
            padding:3px 20px;
            background: #5599FF;
            -webkit-border-radius: 25px;
        }
    </style>
</head>
<body>
<form action="LoginServlet" method="post">
    <div align="center">
        <h1>用户登录</h1>
    </div>

    <div align="center">
        <table>username:
            <tr>
                <input type="text" name="username" class="in" placeholder="username"><br>
            </tr>password:
            <tr>
                <input type="password" name="password" class="in" placeholder="password"><br><br>
            </tr>
            <tr>
                <input type="submit" value="登录" class="sub">
                <input type="button" class="but" onclick="location.href='register.jsp'" value="注册">
            </tr>
        </table>
    </div>
    <div align="center" >
        <input value="管理员登录" class="ma" type="button" onclick="location.href='manageLogin.jsp'">
    </div>
</form>
</body>
</html>
