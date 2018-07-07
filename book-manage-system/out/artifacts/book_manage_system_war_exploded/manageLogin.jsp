
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
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
            background: #cccccc;
            -webkit-border-radius: 25px;
        }
    </style>
</head>
<body>
<form action="LoginServlet" method="post">
    <div align="center">
        <h1>管理员登录</h1>
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
                <input type="button" value="用户登录" onclick="location.href='index.jsp'" class="but">
            </tr>
        </table>
    </div>
</form>
</body>
</html>
