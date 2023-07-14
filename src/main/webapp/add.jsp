<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm giảng viên</title>
</head>
<body>

<h1>Thêm giảng viên</h1>

<form action="${pageContext.request.contextPath}/giang-vien/add" method="POST">
    <label>ID:</label><br>
    <input type="text" name="id" required><br><br>
    <label>Mã giảng viên:</label><br>
    <input type="text" name="ma" required><br><br>
    <label>Tên giảng viên:</label><br>
    <input type="text" name="ten" required><br><br>
    <label>Tuổi:</label><br>
    <input type="number" name="tuoi" required><br><br>
    <label>Giới tính:</label><br>
    <input type="radio" name="gioiTinh" value="Nam" required> Nam
    <input type="radio" name="gioiTinh" value="Nữ" required> Nữ<br><br>
    <label>Địa chỉ:</label><br>
    <input type="text" name="diaChi" required><br><br>
    <button type="submit">Thêm</button>
</form>

</body>
</html>
