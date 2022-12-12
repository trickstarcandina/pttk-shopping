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
            <div class="col mt-5" style="text-align: center"><h2>Giỏ Hàng</h2> </div>
            <div class="col-lg-12 mt-5 mb-3">
                <div class="row justify-content-center">
                    <c:if test="${empty cartItems}">
                        <div class="alert alert-primary">
                            Bạn chưa có sản phẩm nào trong giỏ hàng!
                        </div>
                    </c:if>
                    <c:if test="${not empty cartItems}">
                        <c:forEach var="cartItem" items="${cartItems}">
                                <div class="col-lg-12 col-md-12 mb-6">
                                        <div class="row mb-3">
                                            <div class="col-lg-6 col-md-6 mb-6">
                                                <img src="${cartItem.product.image}" width="250px", height="250px">
                                            </div>
                                            <div class="col-lg-6 col-md-6 mb-6">
                                                <h4>
                                                    ${cartItem.product.name}
                                                </h4>
                                                <h5 class="ml-2" style="color: #d0011b">${cartItem.product.price} đ</h5>
                                                <div class="button-group">
                                                    <p>Số lượng:</p>
                                                    <a class="btn btn-danger" type="button" href="/change-quantity?action=dec&id=${cartItem.product.id}">-</a>
                                                    <input name="quantity" value="${cartItem.quantity}" type="number" disabled/>
                                                    <a class="btn btn-success" type="button" href="/change-quantity?action=inc&id=${cartItem.product.id}">+</a>
                                                    <button class="btn btn-danger" style="margin-left: 150px" data-toggle="modal" type="button" data-target="#confirmModal${cartItem.product.id}">
                                                        Remove
                                                    </button>
                                                    <div class="modal fade" id="confirmModal${cartItem.product.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    Bạn có chắc chắc muốn xoá sản phẩm này ra khỏi giỏ hàng?
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                    <a class="btn btn-danger" type="button" href="/change-quantity?action=del&id=${cartItem.product.id}">Delete</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
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
                                        <h5>${totalAmount}</h5>
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                        sản phẩm
                                    </div>
                                    <div class="col-lg-6 col-md-6 mb-6">
                                        <h4>Tổng tiền:</h4>
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                        <h5>${totalPrice}</h5>
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                        vnđ
                                    </div>
                                    <div class="col-lg-9 col-md-9 mb-9" style="text-align: right">
                                    </div>
                                    <div class="col-lg-3 col-md-3 mb-3" style="text-align: right">
                                        <a href="/order" class="btn btn-success">Thanh toán</a>
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
