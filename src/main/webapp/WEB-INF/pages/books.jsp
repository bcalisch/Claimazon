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

<aside style="display:inline-table">
    <table>
        <thead>
        <tr>
            <th>Categories</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="/books?category=Default&order=Default&ascending=true">All </a> </td>
        </tr>
        <c:forEach var="category" items="${categoryCount}">
            <tr>
                <td><a href="/books?category=${category.name}&order=Default&ascending=true">${category.name}<%="("%>${category.count}<%=")"%></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</aside>

<table border="1" align="center" style="width:50%;margin-left:4em; display:inline-block;clear-side: right">
    <thead>
    <tr>
        <th>Image</th>
        <th><a href="/books?category=${category}&order=Default&ascending=${ascending}">ID</a></th>
        <th><a href="/books?category=${category}&order=Title&ascending=${ascending}">Title</a></th>
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
            <td><img src="/images/A9781430231684-small_8.png"/></td>
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
            <td><c:forEach var="category" items="${book.categories}">
                <table>
                    <tr>${category.name}<%=" "%></tr>
                </table>
            </c:forEach></td>

            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
