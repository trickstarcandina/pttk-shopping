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
    <title>Home | E-Shopper</title>
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
<section id="slider"><!--slider-->
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#slider-carousel" data-slide-to="1"></li>
                        <li data-target="#slider-carousel" data-slide-to="2"></li>
                    </ol>

                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="col-sm-6">
                                <h1><span>E</span>-SHOPPER</h1>
                                <h2>Free E-Commerce Template</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                                <button type="button" class="btn btn-default get">Get it now</button>
                            </div>
                            <div class="col-sm-6">
                                <img src="<c:url value='../../template/images/home/girl1.jpg'/>" class="girl img-responsive" alt="" />
                                <img src="<c:url value='../../template/images/home/pricing.png'/>"  class="pricing" alt="" />
                            </div>
                        </div>
                        <div class="item">
                            <div class="col-sm-6">
                                <h1><span>E</span>-SHOP</h1>
                                <h2>100% Responsive Design</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                                <button type="button" class="btn btn-default get">Get it now</button>
                            </div>
                            <div class="col-sm-6">
                                <img src="<c:url value='../../template/images/home/girl2.jpg'/>" class="girl img-responsive" alt="" />
                                <img src="<c:url value='../../template/images/home/pricing.png'/>"  class="pricing" alt="" />
                            </div>
                        </div>

                        <div class="item">
                            <div class="col-sm-6">
                                <h1><span>E</span>-SHOP</h1>
                                <h2>Free Ecommerce Template</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                                <button type="button" class="btn btn-default get">Get it now</button>
                            </div>
                            <div class="col-sm-6">
                                <img src="<c:url value='../../template/images/home/girl3.jpg'/>" class="girl img-responsive" alt="" />
                                <img src="<c:url value='../../template/images/home/pricing.png'/>" class="pricing" alt="" />
                            </div>
                        </div>

                    </div>

                    <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                        <i class="fa fa-angle-left"></i>
                    </a>
                    <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                        <i class="fa fa-angle-right"></i>
                    </a>
                </div>

            </div>
        </div>
    </div>
</section><!--/slider-->

<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <div class="left-sidebar">
                    <h2>Category</h2>
                    <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordian" href="/list-itemBook">
                                        Book
                                    </a>
                                </h4>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordian" href="/list-itemClothes">
                                        Clothes
                                    </a>
                                </h4>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordian" href="#electronic">
                                        <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                        Electronic
                                    </a>
                                </h4>
                            </div>
                            <div id="electronic" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul>
                                        <li><a href="/list-itemElectronic?type=mobile">Mobile</a></li>
                                        <li><a href="/list-itemElectronic?type=computer">Computer</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordian" href="#shoes">
                                        <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                        Shoes
                                    </a>
                                </h4>
                            </div>
                            <div id="shoes" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul>
                                        <li><a href="/item-shoes?type=men">Men</a></li>
                                        <li><a href="/item-shoes?type=women">Women</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><!--/category-products-->
                    <div class="price-range"><!--price-range-->
                        <h2>Price Range</h2>
                        <div class="well text-center">
                            <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
                            <b class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
                        </div>
                    </div><!--/price-range-->

                    <div class="shipping text-center"><!--shipping-->
                        <img src="images/home/shipping.jpg" alt="" />
                    </div><!--/shipping-->

                </div>
            </div>

            <div class="col-sm-9 padding-right">
                <div class="features_items">
                    <h2 class="title text-center">List Clothes</h2>
                    <c:forEach var="item" items="${listItemClothes}">
                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <form action="/addToCart" method="post">
                                        <div class="product-info text-center">
                                            <a href="/detailItemClothes?id=${item.id}"><img  width="250" height="300" src="${item.imageUrl}" alt=""/></a>
                                            <h2>${item.price}</h2>
                                            <a href="/detailItemClothes?id=${item.id}"><p>${item.clothes.name}</p></a>
                                            <input type="hidden" value="${item.id}" name="id">
                                            <input type="hidden" value="1" name="quantity">
                                            <input type="submit" class="btn btn-cart add-to-cart" value=" Add to cart" >
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../../common/web/footer.jsp"/>

<script src="<c:url value='../../template/js/jquery.js'/>"></script>
<script src="<c:url value='../../template/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='../../template/js/jquery.scrollUp.min.js'/>"></script>
<script src="<c:url value='../../template/js/price-range.js'/>"></script>
<script src="<c:url value='../../template/js/jquery.prettyPhoto.js'/>"></script>
<script src="<c:url value='../../template/js/main.js'/>"></script>
</body>
</html>
