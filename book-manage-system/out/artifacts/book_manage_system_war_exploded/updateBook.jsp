<%--
  Created by IntelliJ IDEA.
  User: cjh
  Date: 2018/7/7
  Time: 下午 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
当前用户：<%=session.getAttribute("username")%><br>
<form action="UpdateBookServlet" method="post">
    <div align="center">
        <table>书名:
            <tr>
                <input type="text" name="bookname" value="${book.bookname}">
            </tr>作者:
            <tr>
                <input type="text" name="author" value="${book.author}">
            </tr>出版社:
            <tr>
                <input type="text" name="press" value="${book.press}">
            </tr>
            <tr>
                <input type="submit" value="确认">
            </tr>
        </table>
    </div>
</form>
</body>
</html>
