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
        <form action="<c:url value='/admin-delete-book'/>" id="formSubmit" method="post">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="/admin">Trang chủ</a>
                        </li>
                        <li>
                            <a href="/admin-product?type=list">Danh sách sản phẩm</a>
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
                            <div class="widget-box table-filter">
                                <div class="table-btn-controls">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <a flag="info"
                                               class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                               title='Thêm sản phẩm' href='<c:url value="/admin-book?type=edit"/>'>
                                                <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                            </a>
                                            <button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                    data-toggle="modal" title='Xóa sản phẩm' name="remove_levels">
                                                <span>
                                                    <i class="fa fa-trash-o bigger-110 pink"></i>
                                                </span>
                                            </button>
                                            <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            Bạn có chắc chắc muốn xoá sản phẩm?
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                            <button class="btn btn-danger" type="submit" id="delete" >Delete</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th><input type="checkbox" id="checkAll"></th>
                                                <th>Tên sản phẩm</th>
                                                <th>Ảnh</th>
                                                <th>Giá</th>
                                                <th>Thao tác</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="item" items="${itemBookList}">
                                                <tr>
                                                    <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}" name="checkbox"></td>
                                                    <td>${item.book.title}</td>
                                                    <td><img src="${item.imageUrl}" width="100px", height="100px"/></td>
                                                    <td>${item.price}</td>
                                                    <td>
                                                        <c:url var="editURL" value="/admin-book">
                                                            <c:param name="type" value="edit"/>
                                                            <c:param name="id" value="${item.id}"/>
                                                        </c:url>
                                                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                           title="Cập nhật sản phẩm" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                        </a>
                                                    </td>
                                                </tr>
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
        </form>
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

<script>
    $('button[name="remove_levels"]').on('click', function(e) {
        var $form = $(this).closest('form');
        e.preventDefault();
        $('#confirmModal').modal({
            backdrop: 'static',
            keyboard: false
        })
            .on('click', '#delete', function(e) {
                $form.trigger('submit');
            });
        $("#cancel").on('click',function(e){
            e.preventDefault();
            $('#confirm').modal.model('hide');
        });
    });
</script>
</body>
</html>
