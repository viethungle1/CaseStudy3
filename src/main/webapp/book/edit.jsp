<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit book</title>
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
            <legend>Edit Book Information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${requestScope["book"].getName()}"></td>
                </tr>
                <tr>
                    <td>Author:</td>
                    <td><input type="text" name="author" value="${requestScope["book"].getAuthor()}"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" value="${requestScope["book"].getPrice()}"></td>
                </tr>
                <tr>
                    <td>Category: </td>
                    <td>
                        <select name="categories" id="categories" multiple>
                            <c:forEach items="${categories}" var="c">
                                <option value="${c.id}">${c.name}</option>
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