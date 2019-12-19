package controller;

import dao.DBConnect;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAOImpl;
import dao.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAO = new UserDAOImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");          
                UserDAOImpl userDAO = new UserDAOImpl();
		String user_id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
               java.sql.Date ngaysinh= null;
		User u = (User) userDAO.getUser(request.getParameter(username));
		try {
			ngaysinh = new java.sql.Date((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaysinh"))).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String gioitinh = request.getParameter("gioitinh");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		String diachi = request.getParameter("diachi");

		
		String err = "";
		String url = "";

		if (password.equals("") || email.equals("") || sdt.equals("") || diachi.equals("")) {
			err += "Phải nhập đầy đủ thông tin!";
		} else {
			 
				Pattern pattenObj = Pattern
						.compile("^(.+)@(.+)$");
				Matcher matcherObj = pattenObj.matcher(email);
				if (!matcherObj.matches()) {
					err += "Email sai định dạng!";
				}else{
					Pattern pattenObj2 = Pattern
							.compile("[\\d]{9,11}");
					Matcher matcherObj2 = pattenObj2.matcher(sdt);
					if (!matcherObj2.matches()) {
						err += "Sđt sai định dạng!";}
				}
		}

		if (err.length() > 0) {
			request.setAttribute("err", err);
		} 

	
			if (err.length() == 0) {
			Connection con = DBConnect.getConnecttion();
		      String sql = "update users set  password=?, ngaysinh=?, gioitinh=?, email=?, sdt=?, diachi=? where username=?";
                    try {
                            PreparedStatement ps = (PreparedStatement) con
                                            .prepareStatement(sql);
                         
                            ps.setString(1, password);
                            ps.setDate(2, ngaysinh);
                            ps.setString(3, gioitinh);
                            ps.setString(4, email);
                            ps.setString(5, sdt);
                            ps.setString(6, diachi);
                          
                            ps.setString(7, u.getUsername());
                            ps.executeUpdate();
                            con.close();
                    } catch (SQLException e) {
                            e.printStackTrace();
                    }
                    url = "/home.jsp";
                    } else {
                       url = "/update_user.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
        

}
