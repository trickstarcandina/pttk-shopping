<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!-- Navigation -->
<header id="header"><!--header-->
    <div class="header_top"><!--header_top-->
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="contactinfo">
                        <ul class="nav nav-pills">
                            <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                            <li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="social-icons pull-right">
                        <ul class="nav navbar-nav">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header_top-->


    <div class="header-middle"><!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="/"><img src="<c:url value='../../template/images/home/logo.png'/>" alt=""/></a>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">
                            <c:set var="user" value="${sessionScope.customer}"/>
                            <c:if test="${not empty user}">

                                <li><a href="/order"><i class="fa fa-user"></i> My orders </a></li>
                                <li><a href="/cart"><i class="fa fa-shopping-cart"></i> Cart </a></li>
                                <li>
                                    <a href="/my-account">
                                        <i class="fa fa-user"></i>${user.fullName.firstName} ${user.fullName.middleName} ${user.fullName.lastName}
                                    </a>
                                </li>
                                <c:if test="${user.role eq 'ADMIN'}">
                                    <li><a class="fa fa-user-secret" href="/admin">Quản trị viên</a></li>
                                </c:if>
                                <li>
                                    <a href="/logout">
                                        <i class="fa fa-sign-out"></i> Đăng xuất
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${empty user}">
                                <li><a href="/login"><i class="fa fa-"></i> Login </a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div><!--/header-middle-->
    <div class="header-bottom"><!--header-bottom-->
        <div class="container">

        </div>
    </div><!--/header-bottom-->
</header>
<!--/header-->
