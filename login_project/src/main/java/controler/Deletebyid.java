package controler;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import dao.SingupLogin;

public class Deletebyid extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		SingupLogin singupLogin=new SingupLogin();
		singupLogin.deleteById(id);
		
		req.setAttribute("list", singupLogin.fetchAll());
		resp.getWriter().print("<h1>Delete Successfully</h1>");
		req.getRequestDispatcher("Result.jsp").include(req, resp);
		
	}

}
