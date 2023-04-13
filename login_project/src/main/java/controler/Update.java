package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SingupLogin;
import dto.Signuppage;
@WebServlet("/update")
public class Update extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Signuppage signuppage=new Signuppage();
	SingupLogin login=new SingupLogin();
	
	signuppage.setId(Integer.parseInt(req.getParameter("id")));
	signuppage.setEmail(req.getParameter("Email"));
	signuppage.setName(req.getParameter("name"));
	signuppage.setMobileno(Long.parseLong(req.getParameter("mobileno")));
	signuppage.setPassword(req.getParameter("password"));
	
	login.update(signuppage);
	
	resp.getWriter().print("<h1 style='colour:green'>Updated successfully....</h1>");
	req.setAttribute("list", login.fetchAll());
	req.getRequestDispatcher("Result.jsp").include(req, resp);
}
}
