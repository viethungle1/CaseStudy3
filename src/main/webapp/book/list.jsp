<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Book Manager</title>
    <style>
        body {
            background-image: url("https://img.freepik.com/free-photo/gray-painted-background_53876-94041.jpg");
            width: 100%;
            height: 100%;
        }
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" >BOOK MANAGER</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="bill?action=create">TẠO ĐƠN HÀNG</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/bill">DANH SÁCH ĐƠN HÀNG</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input type="hidden" value="search"/>
                <input type="hidden" name="action" value="search"/>
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
                <button class="btn btn-outline-dark" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">BOOK</th>
            <th scope="col">AUTHOR</th>
            <th scope="col">PRICE</th>
            <th scope="col">CATEGORY</th>
            <th scope="col">ACTION</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.name}</td>
                <td>${b.author}</td>
                <td>${b.price}</td>
                <td>
                    <c:forEach items="${b.categories}" var="c">
                        <span>${c.name}</span> &nbsp;
                    </c:forEach>
                </td>
                <td>
                    <a href="/books?action=edit&id=${b.id}"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="black" class="bi bi-wrench-adjustable" viewBox="0 0 16 16">
                        <path d="M16 4.5a4.5 4.5 0 0 1-1.703 3.526L13 5l2.959-1.11q.04.3.041.61"/>
                        <path d="M11.5 9c.653 0 1.273-.139 1.833-.39L12 5.5 11 3l3.826-1.53A4.5 4.5 0 0 0 7.29 6.092l-6.116 5.096a2.583 2.583 0 1 0 3.638 3.638L9.908 8.71A4.5 4.5 0 0 0 11.5 9m-1.292-4.361-.596.893.809-.27a.25.25 0 0 1 .287.377l-.596.893.809-.27.158.475-1.5.5a.25.25 0 0 1-.287-.376l.596-.893-.809.27a.25.25 0 0 1-.287-.377l.596-.893-.809.27-.158-.475 1.5-.5a.25.25 0 0 1 .287.376M3 14a1 1 0 1 1 0-2 1 1 0 0 1 0 2"/>
                    </svg></a> &nbsp&nbsp
                    <a href="?action=delete&id=${b.id}"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="black" class="bi bi-x-square" viewBox="0 0 16 16">
                        <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"/>
                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"/>
                    </svg></a>
                </td>
            </tr>
        </c:forEach>
        </tr>
        <tr>
            <td colspan="5"></td>
            <td>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="?action=create"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="black" class="bi bi-plus-circle" viewBox="0 0 16 16">
                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
            </svg></a></td>
        </tr>
        </tbody>
    </table>
</body>
</html>
