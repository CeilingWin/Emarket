<%@page import="model.History"%>
<%@page import="dao.HistoryDAOImpl"%>
<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dao.UserDAOImpl"%>
<%@page import="model.User"%>
<%@page import="dao.UserDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lịch Sử</title>
<link rel="stylesheet" href="css/cart.css" />
<link rel="stylesheet" href="css/menu.css" />
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<jsp:include page="include/bootstrap.jsp"></jsp:include>

</head>
<body>
	<!-- header -->
	<%
		String username = null;
	Cookie[] cookies = request.getCookies();
	if(cookies !=null)
	{
	for(Cookie cookie : cookies)
	{
	    if(cookie.getName().equals("username")) 
	    	username = cookie.getValue();
	}
	}
	%>
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">

				<a class="navbar-brand" href="home.jsp">Web03.com</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="web03cart.jsp">Giỏ hàng</a></li>
					<li><a href="history.jsp">Lịch Sử</a></li>
					<li><a href="update_user.jsp?username=<%=username%>"><%=username%></a></li>
					<li><a href="LogoutServlet">Đăng xuất</a></li>

				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<!-- main -->
	<div id="main" style="height: 900px">
		<div id="content">


			<div class="shopping-cart">

				<div class="column-labels">
					<label class="product-image">Hình ảnh</label> <label
						class="product-details">Sản phẩm</label> <label
						class="product-price">Ngày mua</label> <label
						class="product-quantity">Số lượng</label><label
						class="product-line-price">Đã thanh toán</label>
				</div>
				<%
					ProductDAOImpl productDAO = new ProductDAOImpl();
							HistoryDAOImpl historyDAO = new HistoryDAOImpl();
							UserDAOImpl userDAO = new UserDAOImpl();
							User u= userDAO.getUser(username);
							
							List<History> L= historyDAO.getList(u.getUser_id());
							NumberFormat nf = NumberFormat.getInstance();
							nf.setMinimumIntegerDigits(0);
							
				%>
				<%
					if (L != null) {
						for (History h : L) {
											
				%>
				<div class="product">
					<div class="product-image">
						<img
							src="sanpham/<%=productDAO.getProduct(h.getMa_san_pham())
							.getHinh_anh()%>">
					</div>
					<div class="product-details">
						<div class="product-title">
							<%=productDAO.getProduct(h.getMa_san_pham())
							.getTen_san_pham()%>
						</div>
						<p class="product-description"></p>
					</div>
					<div class="product-price"><%=h.getNgay_mua()%>
					</div>
					<div class="product-quantity cart_quantity_button">
						<%=h.getSo_luong() %>
					</div>
					<div class="product-line-price" style="text-align: right"><%=nf.format(productDAO.getProduct(
							h.getMa_san_pham()).getGia_ban())%>
						VNĐ


					</div>

				</div>
				<%
					}
									}
				%>


			</div>

		</div>
	</div>
	<div class="clear"></div>
	<!-- footer -->
	<jsp:include page="include/footer.jsp"></jsp:include>
	<!-- js -->
	<jsp:include page="include/js.jsp"></jsp:include>
</body>
</html>