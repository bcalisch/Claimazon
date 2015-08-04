<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: benjamin
  Date: 8/3/15
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>${message}</h1>

<h2><a href="/">Back</a></h2>
<table border="1" align="center" style="width:50%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Publisher</th>
        <th>Year Published</th>
        <th>Price</th>
        <th>Authors</th>
        <th>Categories</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${bookList}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.publisher}</td>
            <td>${book.yearPublished}</td>
            <td>${book.price}</td>
            <td><c:forEach var="author" items="${book.authors}">
                <table>
                    <tr>${author.firstName}<%=" "%></tr>
                    <tr>${author.lastName}</tr>
                </table>
                </c:forEach></td>

            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
