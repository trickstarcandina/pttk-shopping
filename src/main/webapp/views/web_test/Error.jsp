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
            <div class="col mt-5" style="text-align: center"><h2>Có lỗi</h2> </div>
            <div class="col-lg-12 mt-5 mb-3">
                <div class="row justify-content-center">
                        <div class="alert alert-primary">
                            Có một lỗi gì đó đãy xảy ra rồi!
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
