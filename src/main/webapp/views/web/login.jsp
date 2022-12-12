<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | E-Shopper</title>
	<link href="<c:url value='../../template/css/bootstrap.min.css'/>" rel="stylesheet" >
	<link href="<c:url value='../../template/css/font-awesome.min.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/prettyPhoto.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/price-range.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/animate.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/main.css'/>" rel="stylesheet">
	<link href="<c:url value='../../template/css/responsive.css'/>" rel="stylesheet">
	<!--[if lt IE 9]>
    <script src="<c:url value='../../template/js/html5shiv.js'/>"></script>
    <![endif]-->
</head><!--/head-->

<body>
	<jsp:include page="../../common/web/header.jsp"/>
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<c:if test="${not empty message}">
                                                        <div class="alert alert-${alert}">
                                                                ${message}
                                                        </div>
                                                    </c:if>
						<form action="<c:url value='/login'/>" id="formLogin" method="post">
							<input type="text" class="form-control" id="username" name="username" value="${username}"
								   placeholder="Tên đăng nhập">
							<input type="password" class="form-control" id="password" name="password"
								   placeholder="Mật khẩu">
							<span>
								<input type="checkbox" value="1" name="remember"/>
								<i>Remember me</i>
							</span>
							<button type="submit" class="btn btn-default">Login</button>
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
                                                <c:if test="${not empty message1}">
                                                        <div class="alert alert-${alert}">
                                                                ${message1}
                                                        </div>
                                                    </c:if>
						<form action="<c:url value='/signup'/>" id="formSignup" method="post" >
                                                    <div class="form-group d-flex align-items-center justify-content-around">
                                                        <input type="text" class="form-control mr-2" id="fullName" name="first-name"
                                                               placeholder="Họ  ">
                                                        <input type="text" class="form-control mr-2" id="fullName" name="middle-name"
                                                               placeholder="Tên đệm">
                                                        <input type="text" class="form-control" id="fullName" name="last-name"
                                                               placeholder="Tên *">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" id="username" name="username"
                                                               placeholder="Tên đăng nhập *">
                                                    </div>

                                                    <div class="form-group">
                                                        <input type="password" class="form-control" id="password" name="password"
                                                               placeholder="Mật khẩu *">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="password" class="form-control" id="re-password" name="re-password"
                                                               placeholder="Nhập lại mật khẩu *">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary" >Đăng ký</button>
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->

	<jsp:include page="../../common/web/footer.jsp"/>

	<script src="<c:url value='../../template/js/jquery.js'/>"></script>
	<script src="<c:url value='../../template/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='../../template/js/jquery.scrollUp.min.js'/>"></script>
	<script src="<c:url value='../../template/js/price-range.js'/>"></script>
	<script src="<c:url value='../../template/js/jquery.prettyPhoto.js'/>"></script>
	<script src="<c:url value='../../template/js/main.js'/>"></script>
</body>
</html>
