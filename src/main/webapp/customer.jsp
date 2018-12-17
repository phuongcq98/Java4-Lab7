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
	<form action="ListCustomerController" method="get">

		<label for="subject" id="chu">Mã khách hàng <span class="req"></span></label>
		<input type="text" name="txtMaKH" id="subject" class="txt"
			tabindex="3"> <input type="submit" name="action"
			value="Search" id="submitbtn"> <input type="submit"
			name="action" value="New" id="submitbtn">
	</form>
	<table border="1">
		<thead>
			<tr>
				<td>Mã khách hàng</td>
				<td>Họ và tên</td>
				<td>Mật khẩu</td>
				<td>Email</td>
				<td>Điện Thoại</td>
				<td>Delete</td>
				<td>Update</td>
			</tr>
		</thead>
		<c:forEach var="rows" items="${listCustomer}">
			<form action="ListCustomerController" method="get">
				<input type="hidden" name="txtMaKH" value="${rows.makh }" />
				<tr>
					<td>${rows.makh }</td>
					<td>${rows.hovaten }</td>
					<td>${rows.matkhau }</td>
					<td>${rows.email }</td>
					<td>${rows.sodienthoai }</td>
					<td><input type="submit" name="action" value="Delete"
						id="submitbtn" /></td>
					<td><input type="submit" name="action" value="Update"
						id="submitbtn" /></td>

				</tr>
				<input type="hidden" name="txtMaKH" value="${rows.makh }"> <input
					type="hidden" name="txtMatKhau" value="${rows.matkhau }"> <input
					type="hidden" name="txtHVT" value="${rows.hovaten }"> <input
					type="hidden" name="txtSoDienThoai" value="${rows.sodienthoai }">
				<input type="hidden" name="txtEmail" value="${rows.email }">
			</form>
		</c:forEach>
	</table>
</body>
</html>