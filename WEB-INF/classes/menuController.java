import Bean.Menu;
import DAO.menuDAO;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class menuController extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Menu u = new Menu();
		menuDAO m= new menuDAO();
		int t;
		m.getMenu(request.getParameter("type"),request.getParameter("cat"),u);
		String[] name=u.getn();
		String[] descp=u.getd();
		String[] img=u.geti();
		int[] rs=u.getr();
		int num=u.getnum();
		String[] r=new String[num];
		request.setAttribute("num",String.valueOf(num));
		request.setAttribute("name",name);
		request.setAttribute("descp",descp);
		request.setAttribute("img",img);
		for(int i=0;i<num;i++)
		{
			r[i]=String.valueOf(rs[i]);
		}
		request.setAttribute("rs",r);
		request.getRequestDispatcher("menu.jsp").forward(request,response);
	}
}