<%-- 
    Document   : admin
    Created on : Dec 14, 2019, 10:07:51 PM
    Author     : Pham Phong
--%>

<%@page import="model.User"%>
<%@page import="dao.UserDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.OrderDAOImpl"%>
<%@page import="model.Order"%>
<%@page import="dao.CategoryDAOImpl"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Add_product</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style1.css"/>
        <link type="text/css" rel="stylesheet" href="css/add_product.css">

        <link rel="stylesheet" type="text/css" href="./bootstrap3/bootstrap/css/bootstrap.min.css"/>

    </head>
    <body>

        <!-- header -->
        <div class="header">
            <nav class="navbar navbar-inverse">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Web03.com</a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="update_user.jsp?username=admin">admin</a></li>
                        <li><a href="LogoutServlet">Đăng xuất</a></li>
                    </ul>
                </div>
            </nav>
        </div>


        <!-- main ->
        <!-- add product -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Form Elements -->
                        <div class="panel panel-default">
                            <div class="panel-heading">Add Product</div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-6">
                                        <h3>Info Product:</h3>

                                        <!--										<form role="form" action="AddProduct" method="get">-->
                                        <form role="form" action="AddProduct" method="post" enctype="multipart/form-data">
                                            <!--											<div class="form-group">
                                                                                                                                                    <label>Product_id:</label> <input class="form-control"
                                                                                                                                                            placeholder="please enter Product_Id" name="product_id" />
                                                                                                                                    </div>-->
                                            <div class="form-group">
                                                <label>Name</label> <input class="form-control"
                                                                           placeholder="please enter Product Name" name="name" />
                                            </div>
                                            <div class="form-group">
                                                <label>Price</label> <input class="form-control"
                                                                            placeholder="please enter Price" type="number" name="price" />
                                            </div>
                                            <div class="form-group">
                                                <label>Producer</label> <input class="form-control"
                                                                               placeholder="please enter Producer" type="name" name="producer" />
                                            </div>
                                            <div class="form-group">
                                                <label>Description </label>
                                                <br>
                                                <textarea rows="8" cols="72" name="des" id="editer"></textarea>

                                            </div>

                                            <div class="form-group">
                                                <label>Category_id</label>
                                                <div class="checkbox">

                                                    <select name="category">
<!--														<c:forEach items="${categories_id}" var="c">
                                                                    <option value="${c.id}">${c.name}</option>
                                                            </c:forEach>-->
                                                        <%
                                                            List<Category> list = new CategoryDAOImpl().getList();
                                                            for (Category c : list) {
                                                        %>
                                                        <option value="<%=c.getMa_the_loai()%>"><%=c.getTen_the_loai()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <label>image</label> <input type="file" name="image" />
                                            </div>
                                            <button type="submit" class="btn btn-default">Add</button>
                                            <button type="reset" class="btn btn-primary">Reset</button>
                                        </form>


                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Form Elements -->
                    </div>
                </div>		
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->
        <!-- /add product -->
        <!-- ====================================================== -->
        <!-- Don hang -->
        <%  OrderDAOImpl orderDAO = new OrderDAOImpl();
            List<Order> list1 = new ArrayList();
            list1 = orderDAO.getOrder();

        %>  

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Bảng order của khách hàng</div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <tr>
                                <th>STT</th>
                                <th>Id User</th>
                                <th>Id Product</th>
                                <th>Time</th>
                                <th>Quantity</th>
                                <th>Sum Money</th>
                                <th>Status</th>
                                <th></th>
                            </tr> 
                            <% for (Order o : list1) {%>
                            <tr>
                                <th><%=o.getId_order()%></th>
                                <th><%=o.getUser_id()%></th>
                                <th><%=o.getMa_san_pham()%></th>
                                <th><%=o.getNgay_mua()%></th>
                                <th><%=o.getSo_luong()%></th>
                                <th><%=o.getThanh_tien()%></th>
                                <th><%=o.getTrangthai()%></th>
                                <th> <a href="updateOrder?trangthai=1&id_order=<%=o.getId_order()%>">Giao hàng</a> ||
                                    <a href="updateOrder?trangthai=-1&id_order=<%=o.getId_order()%>">Hủy đơn</a></th>
                            </tr>
                            <% } %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- end order -->

        <!-- start user -->
        <%  UserDAOImpl userDAO = new UserDAOImpl();
            List<User> list2 = new ArrayList();
            list2 = userDAO.getList();

        %>  
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Danh sách khách hàng</div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <tr>
                                <th>Họ tên</th>
                                <th>Ngày Sinh</th>
                                <th>Giới tính</th>
                                <th>Email</th>
                                <th>Số điện thoại</th>
                                <th>Địa chỉ</th>
                                <th></th>
                            </tr> 
                            <% for (User u : list2) {%>
                            <tr>
                                <th><%=u.getUsername()%></th>
                                <th><%=u.getNgaysinh()%></th>
                                <th><%= u.getGioitinh()%></th>
                                <th><%=u.getEmail()%></th>
                                <th><%=u.getSdt()%></th>
                                <th><%=u.getDiachi()%></th>
                                <th> <a href="EditUser?trangthai=1&user_id=<%=u.getUser_id()%>&role=<%=u.getRole()%>">Xóa</a>
                                </th>
                            </tr>
                            <% }%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- FOOTER -->


        <!-- jQuery Plugins -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
        <script src="lib/jquery/jquery.min.js"></script>
    </body>
</html>

