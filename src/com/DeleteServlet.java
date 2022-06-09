package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con;
		PreparedStatement psmt;
		int rn;
		
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection();;
			
//			HttpSession session = request.getSession();
//			String title = (String) session.getAttribute("title");
			
			String uri = request.getRequestURI();
			String[] arrOfStr = uri.split("/");
			String val = arrOfStr[arrOfStr.length-1];
			
			String query = "DELETE FROM TODOLIST WHERE TITLE=?";
			psmt = conn.prepareStatement(query);
			
			psmt.setString(1, val);
			rn = psmt.executeUpdate();
			
			if(rn>0)
			{
				response.sendRedirect("/TODO/HomeServlet");
			}
			
//			conn.close();
			
		}
		catch(Exception e)
		{
			out.print(e);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
