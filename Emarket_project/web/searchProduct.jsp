<%@page import="java.text.NumberFormat"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page import="dao.CategoryDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu dọc</title>
<link rel="stylesheet" href="css/category.css" />
<jsp:include page="include/bootstrap.jsp"></jsp:include>
</head>
<body>
	<%
		List<Product> list = (List<Product>) request.getAttribute("listProduct");
                NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(0);
	%>
	<!-- header -->
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
        
        <div class="container">
            <div class="panel panel-default" style="margin-top: 10px;">
                <div class="panel-heading">
                     <h3 class="text-center">Sản phẩm tìm kiếm:</h3>
                </div>
                <div class="panel-body">
                       <div class="row justify-content-md-center" style="margin-top: 10px;">
            <% if(list == null){ %>
                <h5>Rất tiếc, không có sản phẩm bạn tìm kiếm! </h5>
            <% }else{ 
		for (Product p : list) {
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
            <%} }%>
            </div>
           </div>
         
        </div>                                        
       </div>
        
        <jsp:include page="include/footer.jsp"></jsp:include>
        <jsp:include page="include/js.jsp"></jsp:include>
</body>
</html>