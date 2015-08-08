<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: benjamin
  Date: 8/6/15
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<h1> Add New Book</h1>

<div id="formContainer">


    <form:form action="add" method="post"  modelAttribute="bookForm"><%--commandName="bookForm"--%>
        <table>
            <tr>
                <td>
                    ID
                </td>
                <td>
                    <form:input type="number" path="id"/>
                </td>
            </tr>
            <tr>
                <td>
                    Title
                </td>
                <td>
                    <form:input type="text" path="title"/>
                </td>
            </tr>
            <tr>
                <td>
                    Price
                </td>
                <td>
                    <form:input type="number" path="price"/>
                </td>
            </tr>

            <tr>
                <td>Author</td>
                    <c:forEach items="${bookForm.authors}" var="author" varStatus="i">
                <td>First Name</td>
                <td>
                <form:input path="authors[${i.index}].firstName" type="text"/>
                </td>
                <td>Last Name</td>
                <td>
                <form:input path="authors[${i.index}].lastName" type="text"/>
                </td>
                </c:forEach>
            </tr>

            <tr>
                <td>
                    Publisher
                </td>
                <td>
                    <form:input type="text" path="publisher"/>
                </td>
            </tr>
            <tr>
                <td>
                    Publication Year
                </td>
                <td>
                    <form:input type="date" path="yearPublished"/>
                </td>
            </tr>
            <tr>
                <td>
                    Description
                </td>
                <td>
                    <form:input type="text" path="description"/>
                </td>
            </tr>
            <tr>
                <td>
                    Image URL
                </td>
                <td>
                    <form:input type="text" path="imageName"/>
                </td>
            </tr>
            <tr>
                <td>
                    Category</td>


                <c:forEach items="${bookForm.categories}" var="category" varStatus="i">

                    <td>
                        <form:input path="categories[${i.index}].name" type="text"/>
                    </td>
                </c:forEach>


            </tr>

        </table>
        <input type="submit" value="Register"/>
        <input type="reset" name="clear">
    </form:form>

</div>
</body>
</html>