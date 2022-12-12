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
            <div class="col mt-5" style="text-align: center"><h2>Chi tiết Đơn hàng</h2> </div>
            <div class="col-lg-12 mt-5 mb-3">
                <div class="row">

                    <c:if test="${not empty order}">
                        <c:forEach var="item" items="${order.orderItems}">
                                <div class="col-lg-12 col-md-12 mb-6">
                                        <div class="row mb-3">
                                            <div class="col-lg-6 col-md-6 mb-6">
                                                <img src="${item.product.image}" width="250px", height="250px">
                                            </div>
                                            <div class="col-lg-6 col-md-6 mb-6">
                                                <h4>
                                                    ${item.product.name}
                                                </h4>
                                                <h5 class="ml-2" style="color: #d0011b">${item.product.price} đ</h5>
                                                <div class="button-group">
                                                    <p>Số lượng: ${item.quantity}</p>
                                                </div>
                                            </div>
                                        </div>
                                </div>
                        </c:forEach>

                        <div class="col-lg-12 col-md-12 mb-6 mt-10">
                                <div class="row mb-3 mr-auto">
                                    <div class="col-lg-6 col-md-6 mb-6">
                                        <h4>Số lượng sản phẩm:</h4>
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                        <h5>${order.totalAmount}</h5>
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                        sản phẩm
                                    </div>
                                    <div class="col-lg-6 col-md-6 mb-6">
                                        <h4>Tổng tiền:</h4>
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                        <h5>${order.totalPrice}</h5>
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                        vnđ
                                    </div>
                                    <div class="col-lg-6 col-md-6 mb-6">
                                        <h4>Trạng thái:</h4>
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                        <h5>${order.status}</h5>
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                    </div>
                                </div>
                        </div>
                    </c:if>
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
