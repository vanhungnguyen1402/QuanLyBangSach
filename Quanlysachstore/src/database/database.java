package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
	public static Connection conn;
	private static database instance=new database();
	public static database getinstance() {
		return instance;
	}
	
	public void connect() {
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanlibangsach";
		String user="sa";
		String password="123456";
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("kết nối thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
	
		public static Connection getconnection() {
			return conn;
		}
	
}
