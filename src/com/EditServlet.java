package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			PreparedStatement psmt;
			ResultSet rs;
			
			Connection conn = SingletonConnection.getSingletonConnection();
			
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/edit.jsp");			
//			requestDispatcher.include(request, response);
			
			String uri = request.getRequestURI();
			String[] arrOfStr = uri.split("/");
			String val = arrOfStr[arrOfStr.length-1];
			
			String query = "SELECT * FROM TODOLIST WHERE TITLE=?";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, val);
			
			rs = psmt.executeQuery();
			while(rs.next())
			{
				String title = rs.getString("TITLE");
				String enddate = rs.getString("END_DATE");
				String action = rs.getString("ACTION");
				request.setAttribute("title", title);
				request.setAttribute("enddate", enddate);
				request.setAttribute("action", action);
			}
			
			
			request.getRequestDispatcher("/pages/edit.jsp").forward(request, response);
			
			
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
