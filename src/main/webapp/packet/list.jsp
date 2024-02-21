<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Home Page</title>
</head>
<body>
<center>
    <h2>Home Page</h2>
    <h3><a href="?action=create">Create New</a></h3>
</center>
<br>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>ID_Khach_Hang</th>
            <th>ID_Book</th>
            <th>So_luong</th>
            <th>Ten_Sach</th>
        </tr>
        <c:forEach items="${packetList}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.id_kh}</td>
                <td>${p.id_book}</td>
                <td>${p.quantity}</td>
                <td>
                    <c:forEach items="${p.books}" var="b">
                        <span>${b.name}</span> &nbsp;
                    </c:forEach>
                </td>
                <td>
                    <a href="/books?action=edit&id=${b.id}">Edit</a>
                    <a href="?action=delete&id=${b.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
