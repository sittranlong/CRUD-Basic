<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập nhật Giảng viên</title>
</head>
<body>
<h1>Cập nhật Giảng viên</h1>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
<form action="/giang-vien/update" method="post">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id" value="${giangVien != null ? giangVien.id : ''}"><br><br>
    <label for="ma">Mã:</label>
    <input type="text" id="ma" name="ma" value="${giangVien != null ? giangVien.ma : ''}"><br><br>
    <label for="ten">Tên:</label>
    <input type="text" id="ten" name="ten" value="${giangVien != null ? giangVien.ten : ''}"><br><br>
    <label for="tuoi">Tuổi:</label>
    <input type="text" id="tuoi" name="tuoi" value="${giangVien != null ? giangVien.tuoi : ''}"><br><br>
    <label for="gioiTinh">Giới tính:</label>
    <input type="text" id="gioiTinh" name="gioiTinh" value="${giangVien != null ? giangVien.gioiTinh : ''}"><br><br>
    <label for="diaChi">Địa chỉ:</label>
    <input type="text" id="diaChi" name="diaChi" value="${giangVien != null ? giangVien.diaChi : ''}"><br><br>
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
