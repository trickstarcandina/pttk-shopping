<%@ page import="pttk.model.order.Cash" %>
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
    <title>Cart | E-Shopper</title>
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
	<div class="container">
		<div class="breadcrumbs">
			<ol class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li class="active">Check out</li>
			</ol>
		</div>
		<c:forEach var="order" items="${orderList}" varStatus="loop">
		<section id="cart_items">
			<div class="container">
				${message}
					<div class="table-responsive cart_info">
						<table class="table table-condensed">
							<thead>
							<tr class="cart_menu">
								<td class="image" style="text-align: center">STT</td>
								<td class="name" style="text-align: center">Tên khách hàng:</td>
								<td class="price" style="text-align: center">Thời gian đặt</td>
								<td class="quantity" style="text-align: center">Trạng thái</td>
							</tr>
							</thead>
							<tbody>
								<tr>
									<td class="cart_product">
										<p style="font-size:x-large; text-align: center">
											${loop.index + 1}
										</p>
									</td>
									<td class="name">
										<p style="font-size:x-large; text-align: center">
												${order.customer.fullName.firstName} ${order.customer.fullName.middleName} ${order.customer.fullName.lastName}
										</p>
									</td>
									<td class="cart_price">
										<p style="font-size:x-large; text-align: center">
											${order.date}
										</p>
									</td>
									<td class="cart_price">
										<p style="font-size:x-large; text-align: center">
												${order.status}
										</p>
									</td>
								</tr>
							</tbody>
						</table>
						<table class="table table-condensed">
							<tbody>
							<c:forEach var="item" items="${order.cart.lineItemBooks}">
							<tr>
								<td class="cart_product">
									<img  width="100" height="120" src="${item.itemBook.imageUrl}" alt=""/>
								</td>
								<td class="name">
									<p style="font-size:x-large; text-align: center">
										${item.itemBook.book.title}
									</p>
								</td>
								<td class="cart_price">
									<p>${item.itemBook.price}</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<input class="cart_quantity_input" disabled="disabled" type="text" name="quantity" value="${item.quantity}" autocomplete="off" size="2">
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price"> ${item.itemBook.price*item.quantity}</p>
								</td>
							</tr>
							</c:forEach>
							<c:forEach var="item" items="${order.cart.lineItemClothes}">
								<tr>
									<td class="cart_product">
										<img  width="100" height="120" src="${item.itemClothes.imageUrl}" alt=""/>
									</td>
									<td class="name">
										<p style="font-size:x-large; text-align: center">
												${item.itemClothes.clothes.name}
										</p>
									</td>
									<td class="cart_price">
										<p>${item.itemClothes.price}</p>
									</td>
									<td class="cart_quantity">
										<div class="cart_quantity_button">
											<input class="cart_quantity_input" disabled="disabled" type="text" name="quantity" value="${item.quantity}" autocomplete="off" size="2">
										</div>
									</td>
									<td class="cart_total">
										<p class="cart_total_price"> ${item.itemClothes.price*item.quantity}</p>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
			</div>
		</section> <!--/#cart_items-->

		<section id="do_action">
			<div class="container">
				<div class="heading">
					<h3>What would you like to do next?</h3>
					<p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<div class="chose_area">
							<form action="/cart" method="post">
								<ul class="user_info">
									<li class="col-sm-12">
										<label>Hình thức thanh toán:</label>
										<input name="shipmentService" type="text" style="width: 100%" value="${listPayment.get(loop.index)}">
									</li>
									<li class="col-sm-12">
										<label>Chọn đơn vị vận chuyển</label>
										<input name="shipmentService" type="text" style="width: 100%" value="${order.shipment.shipmentService.shipUnit}">
									</li>
									<li class="col-sm-12">
										<label>Địa chỉ giao hàng</label>
										<input type="text" style="width: 100%" value="${order.shipment.addressReceive}">
									</li>
								</ul>
							<form action="/cart" type="get">
						</div>
					</div>
					<div class="col-sm-6">
						<div class="col-sm-12"></div>
						<div class="total_area">
							<ul>
								<li>Sub Total <span>${order.cart.totalPrice}</span></li>
								<li>Shipping Cost <span>${order.shipment.shipmentService.shipPrice}</span></li>
								<li>Total Price<span>${order.cart.totalPrice + order.shipment.shipmentService.shipPrice}</span></li>
							</ul>
						</div>
						<div class="col-sm-4">
						</div>
						<div class="col-sm-8">
						</div>
					</div>

				</div>

			</div>
		</section><!--/#do_action-->
		</c:forEach>
	</div>

	<jsp:include page="../../common/web/footer.jsp"/>

	<script src="<c:url value='../../template/js/jquery.js'/>"></script>
	<script src="<c:url value='../../template/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='../../template/js/jquery.scrollUp.min.js'/>"></script>
	<script src="<c:url value='../../template/js/price-range.js'/>"></script>
	<script src="<c:url value='../../template/js/jquery.prettyPhoto.js'/>"></script>
	<script src="<c:url value='../../template/js/main.js'/>"></script>
</body>
</html>
