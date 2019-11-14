package Baomat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import database.database;

public class danhsachthe {

	
	
	public boolean create(String hoten,String diachi,String mathe,Date ngayhh)
	
	{
		database.getinstance().connect();
		Connection conn=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=conn.prepareStatement("insert into thongtinthe values(?,?,?,?)");
			stmt.setString(1, hoten);
			stmt.setString(2, diachi);
			stmt.setString(3, mathe);
			stmt.setDate(4, new java.sql.Date(ngayhh.getTime()));
			
			
			n=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	
	
}
