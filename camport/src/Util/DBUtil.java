package Util;


import java.sql.Connection;
import java.sql.DriverManager;

//반복되는 JDBC 구문 처리
public class DBUtil {
	
	private static Connection conn = null;
	
	public static Connection open() {
		//System.out.println(2);
		String url = "jdbc:mysql://128.199.107.242:3306/yseat";
		String id = "eeu1234";
		String pw = "thskxk4889";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//conn = DriverManager.getConnection(url, id, pw);
			//System.out.println(3);
			conn = DriverManager.getConnection(url, id, pw);
			//System.out.println(4);
			//System.out.println(conn.isClosed());
			
		} catch (Exception e) {
			System.out.println("DBUtil : " + e.toString());
		}
		
		return conn;
		
	}
	
	
	public static Connection open(String server
							, String id, String pw) {
		//System.out.println(1);
		String url = "jdbc:mysql://" + server + ":3306/yseat";
				
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, id, pw);
			//System.out.println(conn.isClosed());

		} catch (Exception e) {
			System.out.println("DBUtil : " + e.toString());
		}
		
		return conn;
		
	}
	
	public static void close() {
		
		try {
			
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (Exception e) {
			System.out.println("DBUtil : " + e.toString());
		}
		
	}

}












