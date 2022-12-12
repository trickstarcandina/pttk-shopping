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
                    <c:forEach var="category" items="${categories}" >
                        <a href="/category?id=${category.id}" class="list-group-item">${category.name}</a>
                    </c:forEach>
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
                            <img class="d-block img-fluid" src="https://cf.shopee.sg/file/86ce190aada75d142eee15473d5e1343_xxhdpi" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="https://cf.shopee.sg/file/76dd7d21c6228338237b87558bcf4a36_xxhdpi" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="https://cf.shopee.sg/file/dfd09a0b5f3241b6f0f368470cfb7bf6_xxhdpi" alt="Third slide">
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
                        <div class="col-lg-12 col-md-12 mb-6">
                            <form action="/addToCart" method="post">

                                <div class="row">
                                    <div class="col-lg-6 col-md-6 mb-6">
                                        <img src="${product.image}" width="300", height="300px">

                                    </div>
                                    <div class="col-lg-6 col-md-6 mb-6">
                                        <h4>
                                            ${product.name}
                                        </h4>
                                        <h5 class="ml-2" style="color: #d0011b">${product.price} đ</h5>
                                        <p>Số lượng: <input class="quantity ml-auto" id="quantity" min="1" name="quantity" value="1" type="number" > </p>
                                        <input type="hidden" value="${product.id}" name="id">
                                        <input type="submit" value="Add to cart" class="btn btn-success">
                                        <br>
                                        <p class="mt-2">${product.description}</p>
                                    </div>
                                </div>
                            </form>
                        </div>
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
