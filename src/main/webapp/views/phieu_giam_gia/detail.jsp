<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sản Phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body class="container">
<h2>UPDATE</h2>
<form:form action="/phieu-giam-gia/update/${pgg.maPhieu}" method="post" modelAttribute="pgg">
    <div class="row row-cols-2">
        <div class="col">
            <label class="form-label">Tên phiếu: </label>
            <form:input path="tenPhieu" cssClass="form-control"/>
            <form:errors path="tenPhieu"/>
        </div>

        <div class="col">
            <label class="form-label">Giá trị giảm: </label>
            <form:input path="giaTriGiam" cssClass="form-control"/>
            <form:errors path="giaTriGiam"/>
        </div>

        <div class="col">
            <label class="form-label">Giá trị giảm tối đa: </label>
            <form:input path="giaTriGiamToiDa" cssClass="form-control"/>
            <form:errors path="giaTriGiamToiDa"/>
        </div>

        <div class="col">

        </div>

        <div class="col">
            <label class="form-label">Ngày bắt đầu: </label>
            <form:input path="ngayBatDau" type="date" cssClass="form-control"/>
            <form:errors path="ngayBatDau"/>
        </div>

        <div class="col">
            <label class="form-label">Ngày kết thúc: </label>
            <form:input path="ngayKetThuc" type="date" cssClass="form-control"/>
            <form:errors path="ngayKetThuc"/>
        </div>

        <div class="col">
            <label class="form-label">Khách hàng: </label>
            <form:select path="khach_hang">
                <form:option value="">Chọn khách hàng</form:option>
                <form:options items="${listKhachHang}" itemLabel="ma_khach_hang" itemValue="ma_khach_hang"/>
            </form:select><br>
        </div>

        <div class="col">
        </div>
    </div>

    <button class="btn btn-success">Update</button>
</form:form>
</body>
</html>