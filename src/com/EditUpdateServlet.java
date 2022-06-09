package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditUpdateServlet")
public class EditUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			Connection conn = SingletonConnection.getSingletonConnection();;
			PreparedStatement psmt;
			int rn;
			
			String title = request.getParameter("title");
			String enddate = request.getParameter("enddate");
			String action = request.getParameter("action");
			
			String query = "UPDATE TODOLIST SET END_DATE=?, ACTION=? WHERE TITLE=?";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, enddate);
			psmt.setString(2, action);
			psmt.setString(3, title);
			
			rn = psmt.executeUpdate();
			
			if(rn>0)
			{
				response.sendRedirect("/TODO/HomeServlet");
			}
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
