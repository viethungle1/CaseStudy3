<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List</title>
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
    <table class="table">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">TÊN KHÁCH HÀNG</th>
            <th scope="col">ĐIỆN THOẠI</th>
            <th scope="col">ĐỊA CHỈ</th>
<%--            <th>SỐ LƯỢNG</th>--%>
            <th scope="col">SẢN PHẨM</th>
            <th scope="col">THÀNH TIỀN</th>
        </tr>
        <c:forEach items="${list}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.name}</td>
                <td>${b.phone}</td>
                <td>${b.address}</td>
<%--                <td>${b.quantity}</td>--%>
                <td>
                    <c:forEach items="${b.books}" var="c">
                        <span>${c.name}</span>
                        <br>
                        <span>${c.price}/cuốn</span>
                        <br>
                    </c:forEach>
                </td>
                <td>${b.getTotalprice()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
