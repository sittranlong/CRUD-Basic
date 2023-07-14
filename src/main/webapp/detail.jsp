<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết Giảng viên</title>
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
<h1>Chi tiết Giảng viên</h1>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
<table>
    <tr>
        <th>ID:</th>
        <td>${giangvien.id}</td>
    </tr>
    <tr>
        <th>Mã:</th>
        <td>${giangvien.ma}</td>
    </tr>
    <tr>
        <th>Tên:</th>
        <td>${giangvien.ten}</td>
    </tr>
    <tr>
        <th>Tuổi:</th>
        <td>${giangvien.tuoi}</td>
    </tr>
    <tr>
        <th>Giới tính:</th>
        <td>${giangvien.gioiTinh}</td>
    </tr>
    <tr>
        <th>Địa chỉ:</th>
        <td>${giangvien.diaChi}</td>
    </tr>
</table>
</body>
</html>
