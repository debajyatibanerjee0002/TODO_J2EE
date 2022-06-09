//package com;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class SingletonConnection {
//	private static Connection con;
//	
//	static
//	{
//		try
//		{
//			String driver = "oracle.jdbc.driver.OracleDriver";
//			Class.forName(driver);
//			String url = "jdbc:oracle:thin:@localhost:1521:XE";
//			String userid = "system";
//			String password = "debajyati";
//			con = DriverManager.getConnection(url, userid, password);
////			con.close();
//		}
//		catch(ClassNotFoundException | SQLException e)
//		{
//			System.out.println("e.getMessage");
//		}
//	}
//	public static Connection getCon()
//	{
//		return con;
//	}
//}

package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection conn=null;
	
	private SingletonConnection()
	{}
	
	public static Connection getSingletonConnection()
	{
		try
		{
			if(conn == null || conn.isClosed())
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","debajyati");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
}

