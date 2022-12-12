

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
                try {
                    ace.settings.check('main-container', 'fixed')
                } catch (e) {
                }
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
                                <form id="formSubmit" action="/admin-clothes" method="post">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Tên:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="name" name="name"
                                                   value="${itemClothes.clothes.name}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <br />

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Link hình ảnh</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="imageUrl" name="imageUrl"
                                                   value="${itemClothes.imageUrl}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Giá Nhập</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="priceClothes"
                                                   name="priceClothes" value="${itemClothes.clothes.price}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Giá Bán</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="priceItemClothes"
                                                   name="priceItemClothes" value="${itemClothes.price}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">BarCode</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="barcode"
                                                   name="barcode" value="${itemClothes.clothes.barcode}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Loại:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="type"
                                                   name="type" value="${itemClothes.clothes.type}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Năm sản xuất</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="yearOfManufacture"
                                                   name="yearOfManufacture" value="${itemClothes.clothes.yearOfManufacture}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Size:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="size"
                                                   name="size" value="${itemClothes.clothes.size}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Màu</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="color"
                                                   name="color" value="${itemClothes.clothes.color}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Chất liệu</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="material"
                                                   name="material" value="${itemClothes.clothes.material}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Tên Nhãn hiệu:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="nameTradeMark"
                                                   name="nameTradeMark" value="${itemClothes.clothes.trademark.name}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Địa chỉ Nhãn hiệu:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="addressTradeMark"
                                                   name="addressTradeMark" value="${itemClothes.clothes.trademark.address}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Quốc gia sản xuất:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="nationOrigin"
                                                   name="nationOrigin" value="${itemClothes.clothes.origin.nation}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Địa chỉ sản xuất:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="addressOrigin"
                                                   name="addressOrigin" value="${itemClothes.clothes.origin.address}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Mô tả sản phẩm</label>
                                        <div class="col-sm-9">
                                            <textarea rows="" cols="" id="description" name="description"
                                                      style="width: 820px;height: 175px">${itemClothes.clothes.description}</textarea>
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <c:if test="${not empty itemClothes.id}">
                                                <button type="submit" class="btn btn-white btn-warning btn-bold"
                                                        id="btnAddOrUpdateNew"> Cập nhật sản phẩm </button>
                                            </c:if>
                                            <c:if test="${empty itemClothes.id}">
                                                <button type="submit" class="btn btn-white btn-warning btn-bold"
                                                        id="btnAddOrUpdateNew"> Thêm sản phẩm </button>
                                            </c:if>
                                        </div>
                                    </div>
                                    <input type="hidden" value="${itemClothes.id}" id="id" name="id" />
                                </form>
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
        <script>
            let editor = '';
            $(document).ready(function () {
                editor = CKEDITOR.replace('description');
            });
        </script>

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
