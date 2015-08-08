<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="js/scripts.js"></script>
    <link rel="stylesheet" type="text/css" href="style/style.css">
    <title></title>
</head>
<body>
<h1>${message}</h1>

<c:forEach var="book" items="${bookList}">
<h2><a id="myLink" href="javascript:goBack();">Back</a>
    <a id="deleteLink" href="/book/delete?id=${book.id}">Delete</a></h2>


<div class="itemsContainer">
    <%--<div id="containerHeader">Show Books</div>--%>
    <div id="results" class="row">
        <ul id="resultsList">


                <li class="items">
                    <div id="itemContainer">
                        <div><img id="singleBookImage" src="/images/${book.imageName}"/></div>
                        <div id="description">
                            <div id="topDescriptionItem">
                                    ${book.title}<%=" "%>
                                        Publisher: ${book.publisher}<%=": "%>
                                    Year Published: ${book.yearPublished}<%=" "%>
                                <div id="price">
                                    <%=" $"%>${book.price}
                                </div>
                                <div id="otherDescription">
                                    <div id="authors">
                                        <p>Authors:</p>
                                        <p> <c:forEach var="author" items="${book.authors}">
                                                ${author.firstName}<%=" "%>
                                                ${author.lastName}
                                        <p></p>
                                        </c:forEach>
                                        </p>
                                        <div id="categories">

                                            <c:forEach var="category" items="${book.categories}">

                                                <a href="/books?category=${category.name}&order=Default"><p>${category.name}<%=" "%></p></>

                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>

                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>


</body>
</html>
