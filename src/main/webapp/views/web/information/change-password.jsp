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
    <title>Thay đổi mật khẩu | E-Shopper</title>
	<link href="<c:url value='/template/css/bootstrap.min.css'/>" rel="stylesheet" >
	<link href="<c:url value='/template/css/font-awesome.min.css'/>" rel="stylesheet">
	<link href="<c:url value='/template/css/prettyPhoto.css'/>" rel="stylesheet">
	<link href="<c:url value='/template/css/price-range.css'/>" rel="stylesheet">
	<link href="<c:url value='/template/css/animate.css'/>" rel="stylesheet">
	<link href="<c:url value='/template/css/main.css'/>" rel="stylesheet">
	<link href="<c:url value='/template/css/responsive.css'/>" rel="stylesheet">
	<!--[if lt IE 9]>
    <script src="<c:url value='../../../template/js/html5shiv.js'/>"></script>
    <![endif]-->
</head><!--/head-->

<body>
	<jsp:include page="/common/web/header.jsp"/>
	<section ><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-md-offset-4">
					<div class="login-form"><!--login form-->
                                            <h2 style="text-align: center">Change Password</h2>
						<c:if test="${not empty message}">
                                                        <div class="alert alert-${alert}">
                                                                ${message}
                                                        </div>
                                                    </c:if>
						<form action="<c:url value='/change-password'/>" id="formChange" method="post">
							<input type="password" class="form-control" id="username" name="password" 
								   placeholder="Mật khẩu cũ">
							<input type="password" class="form-control" id="password" name="new-password"
								   placeholder="Mật khẩu Mới">
							<input type="password" class="form-control" id="password" name="re-password"
								   placeholder="Nhập lại Mật khẩu Mới">
                                                        <div style="display: flex; align-items: center; justify-content:center;"> <button  type="submit" style="border-radius: 3px" class="btn btn-default ">Lưu mật khẩu</button></div>
						</form>
					</div><!--/login form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
        <div style="height: 200px"></div>

	<jsp:include page="/common/web/footer.jsp"/>

	<script src="<c:url value='../../../template/js/jquery.js'/>"></script>
	<script src="<c:url value='../../../template/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='../../../template/js/jquery.scrollUp.min.js'/>"></script>
	<script src="<c:url value='../../../template/js/price-range.js'/>"></script>
	<script src="<c:url value='../../../template/js/jquery.prettyPhoto.js'/>"></script>
	<script src="<c:url value='../../../template/js/main.js'/>"></script>
</body>
</html>
