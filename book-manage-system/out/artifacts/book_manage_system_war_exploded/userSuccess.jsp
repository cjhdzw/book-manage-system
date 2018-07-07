<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
当前用户：<%=session.getAttribute("username")%><br>
<div align="center">
    <h1>图书列表</h1>
</div>
<div align="center">
    <div align="center">
        <input type="button" value="修改密码" onclick="location.href='updateU-M.jsp'">
        <input type="button" value="注销" onclick="location.href='logout.jsp'">
    </div>
    <table align="center" border="1">
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>出版社</th>
        </tr>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td><c:out value="${book.bookname}"></c:out></td>
                <td><c:out value="${book.author}"></c:out></td>
                <td><c:out value="${book.press}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
