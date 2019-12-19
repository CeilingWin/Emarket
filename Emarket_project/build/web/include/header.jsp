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
  
  

</head>

<body>
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
				
			if (username != null) {
                            
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
    <%
	} else {
    %>
       <div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
      <div class="navbar-header">
        
        <a class="navbar-brand" href="home.jsp">Web03.com</a>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
       
          <li><a href="register.jsp">Đăng kí</a></li>
          <li><a href="login.jsp">Đăng nhập</a></li>
         
        </ul>
      </div>
      <!--/.nav-collapse -->
    </div>
  </div>
    <%
	}
    %>
    
    
</body>
</html>
