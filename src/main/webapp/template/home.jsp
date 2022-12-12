<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang chủ</title>
    <link href="<c:url value='../../template/web/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='../../template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
    <jsp:include page="../../common/web/header.jsp"/>
    <div class="container">
        <div class="row">

            <div class="col-lg-3">

                <h1 class="my-4">Danh mục</h1>
                <div class="list-group">
                    <a href="/list-itemBook" class="list-group-item">Book</a>
                    <a href="/list-itemElectronic" class="list-group-item">Electronic</a>
                    <a href="/list-itemClothes" class="list-group-item">Clothes</a>
                    <a href="/list-itemShoes" class="list-group-item">Shoes</a>

                </div>

            </div>
            <!-- /.col-lg-3 -->

            <div class="col-lg-9">

                <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="https://cf.shopee.sg/file/21204006070a1853c94de3bc7aac7ef9_xxhdpi" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="https://cf.shopee.sg/file/3010a8258d6580aafa621c3ebf670aa5_xxhdpi" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="https://cf.shopee.sg/file/311205e065170ff5411c99dc076616ae_xxhdpi" alt="Third slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>

                <div class="row">
                    <c:forEach var="item" items="${listItemBook}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100" >
                                <form action="/addToCart" method="post">
                                    <a href="/detailItemBook?id=${item.id}"><img class="card-img-top" src="${item.imageUrl}" alt=""></a>
                                    <div class="card-body" style="margin-bottom: 50px">
                                        <h4 class="card-title">
                                            <a href="/itemBook?id=${item.id}">${item.book.title}</a>
                                        </h4>
                                        <h5>${item.price} đ</h5>
                                        <input type="hidden" value="${item.id}" name="id">
                                        <input type="hidden" value="1" name="quantity">

                                    </div>
                                    <div class="text-center" style="position:absolute; bottom: 20px; margin-left: 30%; margin-top: 10px">
                                        <input type="submit" value="Add to cart" class="btn btn-success">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                    <c:forEach var="item" items="${listItemClothes}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100" >
                                <form action="/addToCart" method="post">
                                    <a href="/detailItemClothes?id=${item.id}"><img class="card-img-top" src="${item.imageUrl}" alt=""></a>
                                    <div class="card-body" style="margin-bottom: 50px">
                                        <h4 class="card-title">
                                            <a href="/itemClothes?id=${item.id}">${item.clothes.name}</a>
                                        </h4>
                                        <h5>${item.price} đ</h5>
                                        <input type="hidden" value="${item.id}" name="id">
                                        <input type="hidden" value="1" name="quantity">

                                    </div>
                                    <div class="text-center" style="position:absolute; bottom: 20px; margin-left: 30%; margin-top: 10px">
                                        <input type="submit" value="Add to cart" class="btn btn-success">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.col-lg-9 -->

        </div>
    </div>
    <jsp:include page="../../common/web/footer.jsp"/>
<!-- /.row -->
    <script type="text/javascript" src="<c:url value='../../template/web/jquery/jquery.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='../../template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>
