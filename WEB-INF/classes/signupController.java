import Bean.Account;
import DAO.signupDAO;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class signupController extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("mail");
		String password = request.getParameter("password");
		String address = request.getParameter("address");


		Account u = new Account();
		u.setDetails(name,email,password,address);
		

		signupDAO d = new signupDAO();

		d.signup(u);
		
	}
}