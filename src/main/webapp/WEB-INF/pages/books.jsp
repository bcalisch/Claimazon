<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style/style.css">
    <title></title>
</head>
<body>
<h1>${message}</h1>



<h2><a href="/">Back</a></h2>

<div id = "leftNav">
    <div id="headerNav">
        <p id="navTitle">Categories</p>
    </div>
    <div id="leftNavBody">
    <ul class="leftNavBody">
        <li>
            <a href="/books?category=Default&order=Default&ascending=true">All </a>
        </li>
        <c:forEach var="category" items="${categoryCount}">
            <li><a href="/books?category=${category.name}&order=Default&ascending=true">${category.name}<%=" ("%>${category.count}<%=")"%></a></li>
        </c:forEach>
    </ul>
    </div>
</div>

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
            <td><img src="/images/${book.imageName}"/></td>
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
