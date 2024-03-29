package Bangsach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Quanlinguoidung.nguoidung;
import database.database;

public class danhsachsach {
	ArrayList<sach> dssach;
		sach dd;
	
		
		public danhsachsach()
		{
			dssach=new ArrayList<sach>();
			dd=new sach();
		}
		public ArrayList<sach> doctubangsach() {
			
			Connection con=database.getinstance().getconnection();
			String sql="select *from bangsach";
			Statement statement;
			try {
				statement = con.createStatement();
				ResultSet rs=statement.executeQuery(sql);
				while(rs.next())
				{
					String masach=rs.getString(1);
					String tensach=rs.getString(2);
					String theloai=rs.getString(3);
					String hansx=rs.getString(4);
					Double giathue=rs.getDouble(5);
					String ghichu=rs.getString(6);
					sach d=new sach(masach, tensach, theloai, hansx, giathue, ghichu);
					dssach.add(d);
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dssach;
			

		}
		
		public boolean create(String masach,String tensach,String theloai,String hansx,double giathue,String ghichu)
		{
			Connection con=database.getinstance().getconnection();
			PreparedStatement stmt=null;
			int n=0;
			try {
				stmt=con.prepareStatement("insert into bangsach values(?,?,?,?,?,?)");
				stmt.setString(1,masach);
				stmt.setString(2, tensach);
				stmt.setString(3, theloai);
				stmt.setString(4,hansx);
				stmt.setDouble(5,giathue);
				stmt.setString(6,ghichu);
		
			n=stmt.executeUpdate();
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n>0;
		}
		public boolean update(String masach,String tensach,String theloai,String hansx,double giathue,String ghichu)
		{
			Connection con=database.getinstance().getconnection();
			PreparedStatement stmt=null;
			int n=0;
			try {
				stmt=con.prepareStatement("UPDATE bangsach SET"
					
						+ " tensach =?, "
						+ " theloai =?, "
						+ " hansx =?, "
						+ " giathue =?, "
						+ " ghichu = ? "
						+ " WHERE macd = ? ");
				
				stmt.setString(1, tensach);
				stmt.setString(2, theloai);
				stmt.setString(3,hansx);
				stmt.setDouble(4, giathue);
				stmt.setString(5,ghichu);
				stmt.setString(6,masach);
				
				n=stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n>0;
		}
		public boolean delete(String masach)
		{
			Connection con=database.getinstance().getconnection();
			PreparedStatement stmt=null;
			int n=0;
			try {
				stmt=con.prepareStatement("delete from bangsach where macd=?");
				stmt.setString(1,masach);
				n=stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n>0;
		}
		
		

	}



