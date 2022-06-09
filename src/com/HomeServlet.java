package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection conn=null;
		PreparedStatement pstmt;
		ResultSet rs;
		try
		{
			conn = SingletonConnection.getSingletonConnection();
			String query="SELECT * FROM TODOLIST";
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/home.jsp");
			
			requestDispatcher.include(request, response);
			
			out.print("<html>"
					+ "<head><title></title></head>"
					+ "<body>"
					+ "<table border='1' width='800' align='center'>"
					+ "<tr>"
					+ "<th>TITLE</th>"
					+ "<th>END DATE</th>"
					+ "<th>ACTION</th>"
					+ "</tr>"
					);
			while(rs.next())
			{
				HttpSession session = request.getSession(true);
				String title = rs.getString("TITLE");
				session.setAttribute("title", title);
				out.print("<tr>"
						+ "<td>"+rs.getString("TITLE")+"</td>"
						+ "<td>"+rs.getString("END_DATE")+"</td>"
						+ "<td>"+rs.getString("ACTION")+"</td>"
						+ "<td>"
						+ "<a href='/TODO/DeleteServlet/"+rs.getString("title")+"' style='margin-right:20px'>DELETE"
						+ "<a href='/TODO/EditServlet/"+rs.getString("title")+"'>EDIT"
						+ "</a></td>"
						+ "</tr>");
				
				
				
			}
			out.print("</table>"
					+ "</body>"
					+ "</html>");
			

			conn.close();
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
