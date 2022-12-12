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
        <link href="<c:url value='../../../template/css/bootstrap.min.css'/>" rel="stylesheet" >
        <link href="<c:url value='../../../template/css/font-awesome.min.css'/>" rel="stylesheet">
        <link href="<c:url value='../../../template/css/prettyPhoto.css'/>" rel="stylesheet">
        <link href="<c:url value='../../../template/css/price-range.css'/>" rel="stylesheet">
        <link href="<c:url value='../../../template/css/animate.css'/>" rel="stylesheet">
        <link href="<c:url value='../../../template/css/main.css'/>" rel="stylesheet">
        <link href="<c:url value='../../../template/css/responsive.css'/>" rel="stylesheet">

        <!--[if lt IE 9]>
    <script src="<c:url value='../../../template/js/html5shiv.js'/>"></script>
    <![endif]-->
    </head><!--/head-->

    <body>
        <jsp:include page="/common/web/header.jsp"/>
        <section ><!--form-->
            <div class="container ">
                <div class="row">
                    <div class="col col-xs-2 col-sm-2 col-md-3"></div>
                    <div class="col col-xs-8 col-sm-8 col-md-6">
                        <div class="signup-form"><!--sign up form-->
                            <h2 style="text-align:center">Thay đổi thông tin cá nhân</h2>
                            <c:if test="${not empty message}">
                                <div class="alert alert-${alert}">
                                    ${message}
                                </div>
                            </c:if>
                            <form action="<c:url value='/my-account'/>" id="formSignup" method="post" >
                                <div class="form-group d-flex align-items-center justify-content-around">
                                    <div  style="display: flex; align-items: center; justify-content: space-between" >
                                        <input type="text" style="margin-right:20px" class="form-control" id="fullName" name="first-name"
                                               placeholder="Họ " value="${ customer.getFullName().getFirstName()}">
                                        <input type="text" class="form-control " id="fullName" name="middle-name"
                                               placeholder="Tên đệm" value="${customer.getFullName().getMiddleName().toString()}">
                                    </div>
                                    <input type="text" class="form-control" id="fullName" name="last-name"
                                           placeholder="Tên *" value="${ customer.getFullName().getLastName()}">
                                </div>
                                <div > 
                                    <div style="display: flex; align-items: center; justify-content: space-between">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="username" name="nation"
                                                   placeholder="Quốc Gia" value="${customer.getAddress().getNation()}">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" class="form-control" id="password" name="city"
                                                   placeholder="Thành phố" value="${customer.getAddress().getCity()}">
                                        </div>
                                    </div>
                                    <div style="display: flex; align-items: center; justify-content: space-between">
                                        <div class="form-group">
                                            <input type="text" class="form-control"  id="password" name="district"
                                                   placeholder="Huyện" value="${customer.getAddress().getDistrict()}">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="re-password" name="street"
                                                   placeholder="Phố" value="${customer.getAddress().getStreet()}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="number" class="form-control" id="re-password" name="number-house"
                                               placeholder="Số nhà" value="${customer.getAddress().getNumberHouse()}">
                                    </div>
                                    <div style="display: flex; align-items: center; justify-content: space-around">
                                        <button type="submit" class="btn btn-primary" >Cập nhật</button>
                                        <button type="button" class="btn btn-primary" ><a style="color:white; text-decoration: none" href="/change-password" >
                                                <i class="fa fa-lock "></i><span style="padding-left: 4px" >Thay đổi mật khẩu </span>
                                            </a></button>

                                    </div>
                                </div>
                            </form>

                        </div>    
                    </div>
                    <div class="col col-xs-2 col-sm-2 col-md-3"></div>
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
