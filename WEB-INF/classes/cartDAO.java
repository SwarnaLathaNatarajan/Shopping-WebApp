package DAO;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class cartDAO{
	public int getID(String name)
	{
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
			String sql="Select * from  food  where name='"+name+"';";
			 ResultSet r=stmt.executeQuery(sql);
			 while(r.next())
			 {
			 System.out.println(sql);
			 System.out.println(r.getInt("id"));
			 return r.getInt("id");
			}
			return 0;
			}
			catch(Exception e)
			{
				return -1;
			}

	}
	public String getName(int id)
	{
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
			String sql="Select * from  food  where id="+id;
			System.out.println(sql);
			 ResultSet r=stmt.executeQuery(sql);
			 while(r.next())
			 {
			 return r.getString("name");
			 }
			 return null;
			}
			catch(Exception e)
			{
				return null;
			}
		}
			public int getRs(int id)
	{
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
			String sql="Select * from  food  where id="+id;
			 ResultSet r=stmt.executeQuery(sql);
			 while(r.next())
			 {
			 	System.out.println(r.getInt("rs"));
			 	return r.getInt("rs");
			 }
			 return -1;
			}
			catch(Exception e)
			{
				return -1;
			}
	}
}
