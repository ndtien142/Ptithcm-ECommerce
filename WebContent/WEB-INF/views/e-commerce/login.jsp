<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>E-COmmerce| Login</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@100;300;400;500;600;700;800&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/reset.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/admin/login.css' />">
</head>
<body>
	<div class="login">
		<div class="login__image">
			<div class="login__logo">
				<img src="<c:url value ='/common/images/logo.png'/>" alt="">
			</div>
			<h3>Chào mừng bạn quay trở lại!</h3>
			<img
				src="<c:url value ='/common/images/illustration_dashboard.svg'/>"
				alt="">
		</div>
		<div class="login__form">
			<form action="login.htm" method="POST">
				<div class="login__form-group">
					<div class="group-header">
						<h3>Đăng nhập vào thương mại điện tử</h3>
						<span>Người dùng mới? <a href="#">Tạo tài khoản</a></span>
					</div>
					<div class="input-container">
						<input type="text" required="required" id="username"
							name="username" aria-labelledby="username"><span
							class="highlight"></span><span class="bar"></span> <label
							for="searchText">Tên người dùng</label>
					</div>
					<div class="input-container">
						<input type="password" required="required" id="password"
							name="password" aria-labelledby="password"><span
							class="highlight"></span><span class="bar"></span> <label
							for="searchText">Mật khẩu</label>
					</div>
					<div class="form-submit">
						<a href="#">Quên mật khẩu?</a>
						<button type="submit">Đang nhập</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>