
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
当前用户：<%=session.getAttribute("username")%><br>
<form action="UpdateServlet" method="post">
    <div align="center">
        <h1>修改密码</h1>
    </div>

    <div align="center">
        <table>oldPassword:<br>
            <tr>
                <input type="password" name="oldPassword" class="in"><br>
            </tr>password:<br>
            <tr>
                <input type="password" name="password1" class="in"><br>
            </tr>repeat password:<br>
            <tr>
                <input type="password" name="password2" class="in"><br><br>
            </tr>
            <tr>
                <input type="submit" value="修改" class="sub">
            </tr>
        </table>
    </div>
</form>
</body>
</html>
