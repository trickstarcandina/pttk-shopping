<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang quản trị</title>
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

    <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
</head>
<body class="no-skin">
<!-- header -->
<jsp:include page="../../../common/admin/header.jsp"/>
<!-- header -->

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>
    <!-- header -->
    <jsp:include page="../../../common/admin/menu.jsp"/>
    <!-- header -->

    <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="/admin">Trang chủ</a>
                        </li>
                        <li>
                            <a href="/admin-order?type=list">Danh sách đơn hàng</a>
                        </li>
                    </ul>
                </div>
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <c:if test="${not empty messageResponse}">
                                <div class="alert alert-${alert}">
                                        ${messageResponse}
                                </div>
                            </c:if>
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th>Mã đơn hàng</th>
                                                <th>Người mua</th>
                                                <th>Tổng giá</th>
                                                <th>Trạng thái</th>
                                                <th>Thao tác</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="item" items="${orderList}">
                                            <form action="<c:url value='/admin-order'/>" id="formSubmit" method="post">
                                                <tr>
                                                    <td> ${item.id} </td>
                                                    <td> ${item.customer.fullName.firstName} ${item.customer.fullName.middleName} ${item.customer.fullName.lastName}</td>
                                                    <td>${item.payment.amount}</td>
                                                    <td>
                                                        <select class="form-control" id="category" name="status">
                                                            <option value="Đang xử lý"
                                                                    <c:if test="${item.status == 'Đang xác nhận'}">
                                                                        selected="selected"
                                                                    </c:if>
                                                            >
                                                                Đang xác nhận
                                                            </option>
                                                            <option value="Hủy đơn hàng"
                                                            <c:if test="${item.status == 'Hủy đơn hàng'}">
                                                                    selected="selected"
                                                            </c:if>
                                                            >
                                                                Hủy đơn hàng
                                                            </option>
                                                            <option value="Đã giao cho đơn vị vận chuyển"
                                                                    <c:if test="${item.status == 'Đã giao cho đơn vị vận chuyển'}">
                                                                        selected="selected"
                                                                    </c:if>
                                                            >
                                                                Đã giao cho đơn vị vận chuyển
                                                            </option>
                                                            <option value="Đang giao hàng"
                                                                    <c:if test="${item.status == 'Đang giao hàng'}">
                                                                        selected="selected"
                                                                    </c:if>
                                                            >
                                                                Đang giao hàng
                                                            </option>
                                                            <option value="Thành công"
                                                                    <c:if test="${item.status == 'Thành công'}">
                                                                        selected="selected"
                                                                    </c:if>
                                                            >
                                                                Thành công
                                                            </option>
                                                        </select>
                                                    </td>
                                                    <input type="hidden" value="${item.id}" name="id"/>
                                                    <td>
                                                        <button class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                           title="Cập nhật đơn hàng" type="submit"><i class="fa fa-save" aria-hidden="true"></i>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </form>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                        <div class="justify-content-end" style="display: flex">
                                            <nav aria-label="Page navigation example">
                                                <ul class="pagination">
                                                    <c:if test="${currentPage != 1}">
                                                        <li class="page-item">
                                                            <a class="page-link" href="/admin-product?type=list&currentPage=${currentPage-1}" aria-label="Previous">
                                                                <span aria-hidden="true">&laquo;</span>
                                                                <span class="sr-only">Previous</span>
                                                            </a>
                                                        </li>
                                                    </c:if>
                                                    <c:forEach begin="1" end="${totalPage}" var="i">
                                                        <c:if test="${currentPage == i}">
                                                            <li class="page-item active"><a class="page-link active" href="#">${i}</a></li>
                                                        </c:if>
                                                        <c:if test="${currentPage != i}">
                                                            <li class="page-item"><a class="page-link" href="/admin-product?type=list&currentPage=${i}">${i}</a></li>
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:if test="${currentPage != totalPage}">
                                                        <li class="page-item">
                                                            <a class="page-link" href="/admin-product?type=list&currentPage=${currentPage+1}" aria-label="Next">
                                                                <span aria-hidden="true">&raquo;</span>
                                                                <span class="sr-only">Next</span>
                                                            </a>
                                                        </li>
                                                    </c:if>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>
    <!-- footer -->
    <jsp:include page="../../../common/admin/footer.jsp"/>
    <!-- footer -->
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>

<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

<script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>
