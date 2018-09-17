import DAO.cartDAO;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class cartController extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String rs=request.getParameter("rs");
		String qty=request.getParameter("qty");
		int flag=-1;
		cartDAO o=new cartDAO();
		int id=o.getID(name);
		System.out.println(name);
		System.out.println(id);
		Cookie[] cookies = request.getCookies();
		if(cookies !=null)
		{
			for(int i=1;i<cookies.length;i++)
			{
				if(cookies[i].getName().equals(String.valueOf(id)))
				{
					flag=i;
				}
			}
			if(flag!=-1)
			{
					String c=cookies[flag].getValue();
					String q=String.valueOf(Integer.valueOf(c)+Integer.valueOf(qty));
					Cookie ck3=new Cookie(String.valueOf(id),q);
					response.addCookie(ck3);
			}
			else
			{
				Cookie ck2=new Cookie(String.valueOf(id),qty);
				response.addCookie(ck2);
			}
			
		}
		else
		{
			Cookie ck1 = new Cookie(String.valueOf(id),qty);   
			response.addCookie(ck1); 
		}

		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/display");
		rd.forward(request, response);
	}
}