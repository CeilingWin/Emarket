<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAOImpl"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="include/bootstrap.jsp"></jsp:include>
<title>Trang Chủ</title>
</head>

<body>
        
	<!-- Static navbar -->
	<jsp:include page="include/header.jsp"></jsp:include>


	<!-- +++++ Welcome Section +++++ -->
	<div id="ww">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 centered">
					<img src="img/user.png" alt="web03">
					<h1>Hi, Welcome To Web03.com!</h1>
					<p>Chúng tôi hi vọng sẽ làm hài lòng bạn.</p>
					<p>Hãy mua hàng, Hãy ủng hộ chúng tôi!!!</p>
                                        <form class="navbar-form " action="SearchServlet" method="post"> 
                                            <div class="form-group">
                                              <input type="text" class="form-control" placeholder="Nhập sản phẩm cần tìm..."
                                                     style="border: #0af solid 1px;" name="search">
                                            </div>
                                            <button type="submit" class="btn btn-default" style="border: #0af solid 1px;">Search</button>
                                        </form>
                                        <div class="alert-warning"><%= Util.StringUtil.getString(request.getAttribute("err"))%></div>
				</div>
				<!-- /col-lg-8 -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /ww -->


	<!-- +++++ Projects Section +++++ -->

	<div class="container pt">

		<div class="row mt centered">
			<jsp:include page="category.jsp"></jsp:include>
		</div>
		<!-- /row -->

	</div>
	<!-- /container -->

	<!-- san pham -->
	<div class="container">

		<%
		ProductDAOImpl productDAO = new ProductDAOImpl();
		List<Product> list = new ArrayList<Product>();
		list = productDAO.getList();
		String ma_the_loai = null;
		if (request.getParameter("ma_the_loai") != null) {
			   ma_the_loai = request.getParameter("ma_the_loai");
		}
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(0);

	if (ma_the_loai != null) {
            
            %>
		<h3 class="text-center">SẢN PHẨM</h3>
		<div class="row justify-content-md-center" style="margin-top: 10px;">

			<%
		for (Product p : productDAO.getListByCategory(Integer
			.parseInt(ma_the_loai))) {
            %>

			<div class="col-md-4 card thumbnail">

				<a href="detail.jsp?ma_san_pham=<%=p.getMa_san_pham()%>"
					class="spmoi"> <img src="sanpham/<%=p.getHinh_anh()%>"
					alt="anh" class="card-img-top" style="width: 360px; height: 360px;">

					<div class="card-body ">
						<p class="text-center" style="font-size: 20px;">
							<strong><%=p.getTen_san_pham()%></strong>
						</p>
						<p class="text-center"
							style="text-decoration: line-through; color: black;">
							<strong> <%=nf.format(p.getGia_ban()*1.1)%> VND
							</strong>
						</p>
						<p class="text-center" style="color: red">
							<strong><%=nf.format(p.getGia_ban())%> VND</strong>
						</p>
					</div>
                                               
				</a>
			</div>



			<!--  <div class="col-md-3">
                            <div class="card thumbnail">
                                <img class="card-img-top" src="sanpham/<%=p.getHinh_anh()%>"
                                     alt="anh"  style="width:300px; height:250px;">
                                <div class="card-body">
                                    <h4 class="card-title"> <strong><%=p.getTen_san_pham()%></strong></h4>
                                    <p class="card-text"><%=nf.format(p.getGia_ban())%> vnđ</p>
                                    <a href="detail.jsp?ma_san_pham=<%=p.getMa_san_pham()%>" class="btn btn-danger">Mua</a>
                                </div>
                            </div>
                        </div> -->

			<% } %>
		</div>

		<%
		} else {
           %>
		<h3 class="text-center">TẤT CẢ CÁC SẢN PHẨM</h3>
		<div class="row justify-content-md-center" style="margin-top: 10px;">
			<%
		for (Product p : productDAO.getList()) {
	   %>
			<div class="col-md-4 card thumbnail">

				<a href="detail.jsp?ma_san_pham=<%=p.getMa_san_pham()%>"
					class="spmoi"> <img src="sanpham/<%=p.getHinh_anh()%>"
					alt="anh" class="card-img-top" style="width: 360px; height: 360px;">

					<div class="card-body ">
						<p class="text-center" style="font-size: 20px;">
							<strong><%=p.getTen_san_pham()%></strong>
						</p>
						<p class="text-center"
							style="text-decoration: line-through; color: black;">
							<strong> <%=nf.format(p.getGia_ban()*1.1)%> VND
							</strong>
						</p>
						<p class="text-center" style="color: red">
							<strong><%=nf.format(p.getGia_ban())%> VND</strong>
						</p>
					</div>
				</a>
			</div>

			<!-- <div class="col-md-3">
                            <div class="card thumbnail">
                                <img class="card-img-top" src="sanpham/<%=p.getHinh_anh()%>"
                                     alt="anh"  style="width:250px; height:250px;">
                                <div class="card-body">
                                    <h4 class="card-title"> <strong><%=p.getTen_san_pham()%></strong></h4>
                                    <p class="card-text"><%=nf.format(p.getGia_ban())%> vnđ</p>
                                    <a href="detail.jsp?ma_san_pham=<%=p.getMa_san_pham()%>" class="btn btn-danger">Mua</a>
                                </div>
                            </div>
                        </div> -->

			<% } %>

		</div>
		<% } %>
	</div>
	<!-- END san pham -->
	<div class="clear"></div>

	<!-- anh flash sale -->
	<div class="container-fluid thumbnail" style="margin-top: 20px;">
		<a href="#"> <img src="img/portfolio/anhbiacongnghe2.jpg"
			alt="anh" style="width: 100%">
		</a>
	</div>

	<!-- +++++ Footer Section +++++ -->
	<jsp:include page="include/footer.jsp"></jsp:include>

	<!-- / copyrights -->

	<!-- JavaScript Libraries -->
	<jsp:include page="include/js.jsp"></jsp:include>
	
</body>
</html>


