package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SingupLogin;
import dto.Signuppage;

@WebServlet("/info")
public class LoginUser extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		SingupLogin dao=new SingupLogin();
		RequestDispatcher dispatcher=req.getRequestDispatcher("Login.html");
		
		try {
			long mobileno=Long.parseLong(email);
			Signuppage signuppage=dao.LoginUser(mobileno);
			if (signuppage==null) {
				resp.getWriter().print("<h1>incorrect mobile number</h1>");
				dispatcher.include(req, resp);
			} else {
              if (signuppage.getPassword().equals(password)) {
				resp.getWriter().print("<h1>Login successfully</h1>");
				req.setAttribute("list", dao.fetchAll());
				req.getRequestDispatcher("Result.jsp").include(req, resp);
				//resp.sendRedirect("https://www.youtube.com");
			}else{
				resp.getWriter().print("<h1>incorrect password</h1>");
				dispatcher.include(req, resp);
			}
              
			}
			
			
		} catch (NumberFormatException e) {
			String email1=email;
			Signuppage signuppage=dao.LoginUser(email1);
			if (signuppage==null) {
				resp.getWriter().print("<h1>incorrect email</h1>");
				dispatcher.include(req, resp);
			} else {
              if (signuppage.getPassword().equals(password)) {
				resp.getWriter().print("<h1>Login successfully</h1>");
				req.setAttribute("list", dao.fetchAll());
				req.getRequestDispatcher("Result.jsp").include(req, resp);
				//resp.sendRedirect("https://www.youtube.com");
			}else{
				resp.getWriter().print("<h1>incorrect password</h1>");
				dispatcher.include(req, resp);
			}
              
		}
		
	}
	
	}
}
