import Bean.Account;
import DAO.signupDAO;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class signinController extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");


		Account u = new Account();
		u.setNamePass(name,password);
		

		signupDAO d = new signupDAO();
		int f=d.signin(u);
		String url="index.html?name="+name;
		out.println("<input type='submit' value='Back to Home' onclick='location.href ='+url />");
		
	}
}