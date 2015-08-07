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


<h2><a id="myLink" href="/">Back</a></h2>

<div id="formDiv">
    <form id="searchSortForm" method="get" action="/gp/search/ref=sr_st" class="s-inline-form"><input type="hidden"
                                                                                                      name="keywords"
                                                                                                      value="java">
        <input type="hidden" name="fst" value="as:off">
        <input type="hidden" name="rh" value="n:283155,k:java">
        <input type="hidden" name="qid" value="1438821314">
        <span class="a-size-base">Sort by&nbsp;</span>
        <select class="a-spacing-top-mini"
                style="vertical-align: baseline;" name="sort" id="sort"
                onchange="javascript:goToNewPage();">
            <option value="title-asc" selected="selected">Title: A-Z</option>
            <option value="title-desc">Title: Z-A</option>
            <option value="price-asc">Price: Low to High</option>
            <option value="price-desc">Price: High to Low</option>
        </select>
        <noscript>&lt;input type="image"
            src="http://g-ecx.images-amazon.com/images/G/01/buttons/go-orange-trans._CB192189913_.gif" width="21"
            alt="Go" align="top" value="Go" height="21" border="0" /&gt;</noscript>
    </form>
</div>
<div id="leftNav">
    <div id="headerNav">
        <p id="navTitle">Categories</p>
    </div>
    <div id="leftNavBody">
        <ul class="leftNavBody">
            <li>
                <a href="/books?category=Default&order=Default">All </a>
            </li>
            <c:forEach var="categoryName" items="${categoryCount}">
                <li><a id=
                       <c:choose>
                               <c:when test="${categoryName.name.equals(category)}">"selected"

                    </c:when>
                    <c:otherwise>""

                    </c:otherwise>
                    </c:choose> href="/books?category=${categoryName.name}&order=Default">${categoryName.name}<%=" ("%>
                        ${categoryName.count}<%=")"%></a></li>
            </c:forEach>
        </ul>
    </div>
</div>


<div class="itemsContainer">
    <div id="containerHeader">Show Books</div>
    <div id="results" class="row">
        <ul id="resultsList">

            <c:forEach var="book" items="${bookList}">
                <li class="items">
                    <div id="itemContainer">
                        <div><img id="image" src="/images/${book.imageName}"/></div>
                        <div id="description">
                            <div id="topDescriptionItem">${book.id}<%=" "%>
                                <a href="/book?id=${book.id}">${book.title}</a>
                                    ${book.publisher}<%=": "%>
                                    ${book.yearPublished}<%=" "%>
                                <div id="price">
                                    <%=" $"%>${book.price}
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
