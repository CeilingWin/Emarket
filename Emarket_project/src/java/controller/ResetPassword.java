package controller;

import dao.DBConnect;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;









import model.User;
import dao.UserDAO;
import dao.UserDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * Servlet implementation class ResetPassword
 */
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAO = new UserDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
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
		String username = request.getParameter("username");
		
		String err = "";
		if (username.equals("")) {
			err += "Phải nhập đầy đủ thông tin!";
		} else {
			if (userDAO.checkUser(username) == false) {
				err += "Tên đăng nhập không tồn tại!";
			}
		}

		if (err.length() > 0) {
			request.setAttribute("err", err);
		}
		
		String url = "/resetpassword.jsp";
		try {
			if (err.length() == 0) {

				 User u = userDAO.getUser(username);
				url = "/login.jsp";
				String mess = "Kiểm tra email để nhận mật khẩu mới!";
				request.setAttribute("mess", mess);
				
				//gửi mật khẩu mới qua email.
				   final String username_mail = "ahihidongoc1278@gmail.com";
				   final String password = "truongchi1278";
                                   Random random = new Random();
                                   int x = random.nextInt(100000);
                                   String xxx = "web03"+x;
                                   Connection conn = DBConnect.getConnecttion();
                                   String sql = "update users set password =? where user_id=?";
                                   try{
                                       PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                                        ps.setString(1, xxx);
                                        ps.setInt(2, u.getUser_id());
                                        
                                        ps.executeUpdate();
                                        conn.close();
                                   }catch (SQLException e) {
			          e.printStackTrace();
		                  }
                                   
				   String to = u.getEmail();
				   String subject = "Reset Password";
				   String text ="<i>Reset Password</i><br/>";
						   text+="<p>User: <strong>"; text+=username; text+="</strong></p>";
						   text+="<p>New password: <strong>web03"+x+"</strong></p>";
				   Properties props = new Properties();
				   props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
				   Session session_mail = Session.getInstance(props,
				   new javax.mail.Authenticator() {
				      protected PasswordAuthentication getPasswordAuthentication() {
				        return new PasswordAuthentication(username_mail, password);
				      }
				   });
                               
				
                                
				   try {
				     Message message = new MimeMessage(session_mail);
				     message.setHeader("Content-Type", "text/plain; charset=UTF-8");
				     message.setFrom(new InternetAddress(username_mail));
				     message.setRecipients(Message.RecipientType.TO,
				     InternetAddress.parse(to));
				     message.setSubject(subject);
				     message.setContent(text, "text/html; charset=utf-8");
				     Transport.send(message);
				   } catch (MessagingException e) {
				     throw new RuntimeException(e);
				   }
				
			} else {
				url = "/resetpassword.jsp";
				
			}
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/resetpassword.jsp");
		}
	}

}
