package DAO;
import Bean.Menu;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class menuDAO{
	public void getMenu(String type,String cat,Menu m){
		String[] name=new String[100];
	String[] descp=new String[100];
	String[] img=new String[100];
	int[] rs=new int[100];
		
		int i=0;
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/SHOP";

		final String USER="root";
		final String PASS="swarna";

		Connection conn=null;
		Statement stmt=null;
			try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			stmt=conn.createStatement();
			String sql="Select * from  food  where category='"+cat+"' and type='"+type+"'";
			 ResultSet r=stmt.executeQuery(sql);
			 while(r.next())
			 {
			 		name[i]=r.getString("name");
			 		descp[i]=r.getString("descp");
			 		img[i]=r.getString("image");
			 		rs[i]=r.getInt("rs");
			 		i++;
			 }
			 r.last();
			 int n=r.getRow();
			 m.set(name,descp,img,rs,n);
			}
			catch(Exception e)
			{
			}

	}
}
