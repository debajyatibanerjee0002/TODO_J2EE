package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con;
		PreparedStatement psmt;
		
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection();
			
			String title = request.getParameter("title");
			String enddate = request.getParameter("enddate");
			String action = request.getParameter("action");
			
			String query = "INSERT INTO TODOLIST(TITLE,END_DATE,ACTION) VALUES(?,?,?)";
			psmt= conn.prepareStatement(query);
			
			psmt.setString(1,title);
			psmt.setString(2, enddate);
			psmt.setString(3, action);
			
			int rn=psmt.executeUpdate();
			
			if(rn>0)
			{
				response.sendRedirect("/TODO/HomeServlet");
			}
			conn.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
