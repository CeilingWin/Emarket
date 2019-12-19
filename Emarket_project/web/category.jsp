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
</head>
<body>
	<%
		CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
		List<Category> list = new ArrayList<Category>();
		list = categoryDAO.getList();
	%>

	<div class="row mt centered">
		<%
                    Category c;
		    for (int i = 0; i < 3 ; i++) {      
			c = list.get(i);	
		%>

		<div class="col-lg-4">
			<a href="home.jsp?ma_the_loai=<%=c.getMa_the_loai()%>"><img
				class="img-responsive"
				src="img/portfolio/img<%=c.getMa_the_loai()%>.jpg" alt=""
				style="height: 250px; width: 400px" /></a>
			<p>
				<strong><%=c.getTen_the_loai()%></strong>
			</p>
		</div>

		<%
                    }
		%>
	</div>

	<div class="row mt centered">
		<%
                    
		    for (int i = 3; i < 6 ; i++) {      
			c = list.get(i);	
		%>

		<div class="col-lg-4">
			<a href="home.jsp?ma_the_loai=<%=c.getMa_the_loai()%>"><img
				class="img-responsive"
				src="img/portfolio/img<%=c.getMa_the_loai()%>.jpg" alt=""
				style="height: 250px; width: 400px" /></a>
			<p>
				<strong><%=c.getTen_the_loai()%></strong>
			</p>
		</div>

		<%
                    }
		%>
	</div>
</body>
</html>