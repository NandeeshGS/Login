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

@WebServlet("/info1")
public class SaveUser extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Signuppage sign=new Signuppage();
		
		sign.setName(req.getParameter("name"));
		sign.setEmail(req.getParameter("email"));
		sign.setMobileno(Long.parseLong(req.getParameter("mobileno")));
		sign.setPassword(req.getParameter("pass"));
		
		SingupLogin login=new SingupLogin();
		login.saveSignup(sign);
		
		resp.setContentType("Text/html");
		resp.getWriter().print("<h1>Data successfully entered</h1>");
		//RequestDispatcher(I) rd=This will provide connection to another servlet page or html page 
	     req.getRequestDispatcher("Login.html").include(req, resp);//two methods to connect 1.forward method  2.include method

		
	}
	
}
