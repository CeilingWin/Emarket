package controller;

import dao.DBConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.Product;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ten_san_pham_search = request.getParameter("search");
		String err="";
		
		if(ten_san_pham_search.equals("")){
			err+="Phải nhập ít nhất 1 thông tin tìm kiếm";
                        request.setAttribute("err",err);
                        String url = "/home.jsp";
                        RequestDispatcher dis = request.getRequestDispatcher(url);
                         dis.forward(request, response);
		}else{
                    Connection conn = DBConnect.getConnecttion();
                    String sql = "select * from product where ten_san_pham like  N'%"+ten_san_pham_search+"%'";
                    List<Product> list = new ArrayList<Product>();
                    try {
                            PreparedStatement ps = (PreparedStatement) conn
                                            .prepareStatement(sql);
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {
                                    int ma_san_pham = rs.getInt("ma_san_pham");
                                    int ma_the_loai = rs.getInt("ma_the_loai");
                                    String ten_san_pham = rs.getString("ten_san_pham");
                                    String hinh_anh = rs.getString("hinh_anh");
                                    Double gia_ban = rs.getDouble("gia_ban");
                                    String hang_san_xuat = rs.getString("hang_san_xuat");
                                    String thong_tin = rs.getString("thong_tin");
                                    list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham,
                                                    hinh_anh, gia_ban, hang_san_xuat, thong_tin));
                            }
                            conn.close();
                    } catch (SQLException e) {
                            e.printStackTrace();
                    }

                    request.setAttribute("listProduct",list);

                    String url = "/searchProduct.jsp";
                    RequestDispatcher dis = request.getRequestDispatcher(url);
                     dis.forward(request, response);
                }
	}

}
