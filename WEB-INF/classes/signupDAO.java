package DAO;

import Bean.Account;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class signupDAO{
	public void signup(Account u){
		String name = u.getName();
		String password = u.getPass();
		String email=u.getEmail();
		String address=u.getAdd();

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

			String sql="insert into User values('"+name+"','"+email+"','"+password+"','"+address+"')";
			 stmt.executeUpdate(sql);
}
catch(Exception e)
{
}

	}
	public int signin(Account u){
		String name = u.getName();
		String password = u.getPass();

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
			String sql="Select name,password from User where name='"+name+"' && password='"+password+"';";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				
					return 1;	
			}
			else
				return 0;
}
catch(Exception e)
{
	return 0;
}
	}
}