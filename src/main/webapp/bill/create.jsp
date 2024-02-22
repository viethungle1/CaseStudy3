<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Create New Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="white" class="bi bi-house-door" viewBox="0 0 16 16">
            <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4z"/>
        </svg></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<div>
    <form method="post">
        <fieldset>
            <legend>Create New Order</legend>
        <table>
            <tr>
                <th>Name:</th>
                <td><input type="text" name="name" size="45px"></td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td><input type="text" name="phone" size="45px"></td>
            </tr>
            <tr>
                <th>Address:</th>
                <td><input type="text" name="address" size="45px"></td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td><input type="text" name="quantity" size="45px"></td>
            </tr>
            <tr>
                <th>Book: </th>
                <td>
                    <select name="books" multiple>
                        <c:forEach items="${books}" var="b">
                            <option  value="${b.id}">${b.name} - ${b.price}$</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Save</button>
                </td>
            </tr>
        </table>
        </fieldset>
    </form>
</div>
</body>
</html>
