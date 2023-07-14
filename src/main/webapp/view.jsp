<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Giảng viên</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Danh sách Giảng viên</h1>
<!-- Form tìm kiếm -->
<form action="${pageContext.request.contextPath}/giang-vien/search" method="GET">
    <input type="text" name="searchKeyword" placeholder="Tìm kiếm...">
    <button type="submit">Tìm kiếm</button>
</form>
<br>
<button><a href="${pageContext.request.contextPath}/giang-vien/view-add">Thêm giảng viên</a></button>
<button><a href="${pageContext.request.contextPath}/giang-vien/giang-vien-nu">Giảng viên nữ</a></button>
<br>
<br>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Địa chỉ</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty giangvien}">
        <c:forEach items="${giangvien}" var="giangVien" varStatus="viTri">
            <tr>
                <td>${viTri.index + 1}</td> <!-- Thêm 1 vào viTri.index để bắt đầu từ 1 thay vì 0 -->
                <td>${giangVien.id}</td>
                <td>${giangVien.ma}</td>
                <td>${giangVien.ten}</td>
                <td>${giangVien.tuoi}</td>
                <td>${giangVien.gioiTinh}</td>
                <td>${giangVien.diaChi}</td>
                <td>
                    <button onclick="location.href='${pageContext.request.contextPath}/giang-vien/detail?id=${giangVien.id}'">
                        Detail
                    </button>
                    <button onclick="location.href='${pageContext.request.contextPath}/giang-vien/view-update?id=${giangVien.id}'">
                        Edit
                    </button>
                    <button onclick="location.href='${pageContext.request.contextPath}/giang-vien/remove?id=${giangVien.id}'">
                        Remove
                    </button>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
