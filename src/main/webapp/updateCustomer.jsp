<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab7</title>
</head>
<body>
	<form action="ListCustomerController" method="get" name="myForm"
		onsubmit="return validate();">

		<div id="mid" class="mid">
			<h2 id="taotaikhoan" class="taotaikhoan">Tạo khách hàng</h2>
			<div class="row">
				<label for="name">Mã khách hàng <span class="req">*</span></label> <input
					type="text" name="txtMaKH" id="txtttk" class="txt" tabindex="1"
					value="<%=request.getAttribute("makh")%>">
			</div>
			<div class="row">
				<label for="name">Họ và tên <span class="req">*</span></label> <input
					type="text" name="txtHVT" id="txtmktk" class="txt" tabindex="1"
					value="<%=request.getAttribute("hovaten")%>">
			</div>
			<div class="row">
				<label for="name">Mật khẩu<span class="req">*</span></label> <input
					type="password" name="txtMatKhau" id="name" class="txt"
					tabindex="1" value="<%=request.getAttribute("matkhau")%>">
			</div>
			<div class="row">
				<label for="name">Email<span class="req">*</span></label> <input
					type="text" name="txtEmail" id="txte" class="txt" tabindex="1"
					value="<%=request.getAttribute("email")%>">
			</div>
			<div class="row">
				<label for="name">Điện Thoại <span class="req">*</span></label> <input
					type="text" name="txtSoDienThoai" id="txtdt" class="txt"
					tabindex="1" value="<%=request.getAttribute("sodienthoai")%>">
			</div>
			<br> <input type="submit" value="Save" name="action"
				id="submitbtn">
		</div>
	</form>
</body>
</html>