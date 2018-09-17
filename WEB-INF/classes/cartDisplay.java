import DAO.cartDAO;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class cartDisplay extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String c=new String();
		int rs,total=0,i;
		cartDAO obj=new cartDAO();
		String name=new String();
		Cookie cookies[] = request.getCookies();   
		    
      for( i = 1; i < cookies.length; i++)     
      {
       				rs=obj.getRs(Integer.valueOf(cookies[i].getName()));
					name=obj.getName(Integer.valueOf(cookies[i].getName()));
					out.println("Item : "+name+"<br>Qty : "+cookies[i].getValue()+"<br>Rs : "+rs+"<br><br>");

      }    
      for(i=1;i<cookies.length;i++)
      {

      		total+=( (obj.getRs(Integer.valueOf(cookies[i].getName())) )*( Integer.valueOf(cookies[i].getValue())) );
      }
      out.println("<hr>Total : Rs. "+total+"\\-");
	}
}