package Quanlinguoidung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.database;

public class danhsachnguoidung {
	ArrayList<nguoidung> dsnguoid;
	nguoidung ngd;
	public danhsachnguoidung()
	{
		dsnguoid=new ArrayList<nguoidung>();
		ngd=new nguoidung();
	}
	public ArrayList<nguoidung> doctubangnguoidung() {
		
		Connection con=database.getinstance().getconnection();
		String sql="select *from nguoidung";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String mangd=rs.getString(1);
				String hoten=rs.getString(2);
				String tenkhah=rs.getString(3);
				String makhau=rs.getString(4);
				String gioitinh=rs.getString(5);
				String sodt=rs.getString(6);
				String manv=rs.getString(7);
				nguoidung ng=new nguoidung(mangd,hoten, tenkhah, makhau, gioitinh, sodt, manv);
				dsnguoid.add(ng);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnguoid;
		

	}
	public boolean create(String mangd,String hoten,String tentaikh,String makh,String gioitinh,String sodt,String manv)
	{
		Connection con=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into nguoidung values(?,?,?,?,?,?,?)");
			stmt.setString(1,mangd);
		stmt.setString(2, hoten);
		stmt.setString(3, tentaikh);
		stmt.setString(4,makh);
		stmt.setString(5,gioitinh);
		stmt.setString(6,sodt);
		stmt.setString(7,manv);
		n=stmt.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean update(String mangd,String hoten,String tentaikh,String makh,String gioitinh,String sodt,String manv)
	{
		Connection con=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("UPDATE nguoidung SET"
					+ " hoten = ?, "
					+ " tentaikh = ?, "
					+ " matkhau =?, "
					+ " gioitinh =?, "
					+ " sodt =?, "
					+ " manv=? "
					+ " WHERE mangd =? ");
			
			stmt.setString(1, hoten);
			stmt.setString(2, tentaikh);
			stmt.setString(3,makh);
			stmt.setString(4,gioitinh);
			stmt.setString(5,sodt);
			stmt.setString(6,manv);
			stmt.setString(7,mangd);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String mangd)
	{
		Connection con=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from nguoidung where mangd=?");
			stmt.setString(1,mangd);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	

}
