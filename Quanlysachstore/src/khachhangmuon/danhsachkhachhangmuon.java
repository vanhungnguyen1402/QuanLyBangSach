package khachhangmuon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import database.database;
import khachhangtra.khachhantr;

public class danhsachkhachhangmuon {
	ArrayList<khachhangmuon> dskhhm;
	khachhangmuon khahm;
	khachhantr khhtra;
	ArrayList<khachhantr> dskhtr;
	public danhsachkhachhangmuon()
	{
		dskhhm=new ArrayList<khachhangmuon>();
		khahm=new khachhangmuon();
	}
	
	public ArrayList<khachhangmuon> doctubangkhachhangmuon()
	{
		Connection conn=database.getinstance().getconnection();
		String sql="select *from khachhangmuon";
		
		Statement statement;
		try {
			statement=conn.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String makhm=rs.getString(1);
				String  soph=rs.getString(2);
				Date ngayt=(Date) rs.getObject(3);
				String manv=rs.getString(4);
				String mabasach=rs.getString(5);
				String tenbsach=rs.getString(6);
				String thelo=rs.getString(7);
				String tinhtr=rs.getString(8);
				int soluo=rs.getInt(9);
				int songaym=rs.getInt(10);
				Float dongi=rs.getFloat(11);
			
				khachhangmuon kh=new khachhangmuon(makhm,soph, ngayt, manv, mabasach, tenbsach, thelo, tinhtr, soluo, songaym, dongi);
				dskhhm.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dskhhm;
	}
	public boolean create(String makh,String sophieu,Date date,String manv,String mabangsach,String tenbangsach,
			String theloai,String tinhtrang,int sol,int songaym,Float dongia)

	{
		Connection conn=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=conn.prepareStatement("insert into khachhangmuon values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,makh);
			stmt.setString(2,sophieu);
			stmt.setDate(3,new java.sql.Date(date.getTime()));
			stmt.setString(4,manv);
			stmt.setString(5,mabangsach);
			stmt.setString(6,tenbangsach);
			stmt.setString(7,theloai);
			stmt.setString(8,tinhtrang);
			stmt.setInt(9,sol);
			stmt.setInt(10,songaym);
			stmt.setFloat(11,dongia);
			
			
			n=stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return n>0;
		
	}
	public boolean createkhtr(String makhtr,String manv,String tenbangsach,Date ngaythue,String sophieu) {
		
		Connection conn=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		String kq="";
		Date dd=null;
		try {
			stmt=conn.prepareStatement("insert into khachhangtr values(?,?,?,?,?,?,?,?)");
			stmt.setString(1,makhtr);
			stmt.setString(2,manv);
			stmt.setString(3, tenbangsach);
			stmt.setDate(4, new java.sql.Date(ngaythue.getTime()));
			stmt.setString(5, sophieu);
			stmt.setDate(6, new java.sql.Date(ngaythue.getTime()));
			stmt.setString(7, kq);
			stmt.setString(8, kq);
			
			n=stmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return n>0;
	}
	public boolean update(String makhm,String sophieu,Date ngaythue,String manv,String mabangsach,String tenbangsach,
			String theloai,String tinhtrang,int sol,int songaym,Float dongia)
	{
		Connection conn=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=conn.prepareStatement("Update khachhangmuon SET"
					+ " sophieu = ?,"
					+ " ngaythue = ?,"
					+ " manv = ?,"
					+ " mabangsach = ?,"
					+ " tenbangsach = ?,"
					+ " theloai = ?,"
					+ " tinhtrang = ?,"
					+ " soluong = ?,"
					+ " songaymuon = ?,"
					+ " dongia = ?"
					+ " where makhm = ?");
			
			
			stmt.setString(1,sophieu);
			stmt.setDate(2, new java.sql.Date(ngaythue.getTime()));
			stmt.setString(3, manv);
			stmt.setString(4, mabangsach);
			stmt.setString(5, tenbangsach);
			stmt.setString(6, theloai);
			stmt.setString(7, tinhtrang);
			stmt.setInt(8, sol);
			stmt.setInt(9, songaym);
			stmt.setFloat(10, dongia);
			stmt.setString(11, makhm);
			n=stmt.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String khhm)
	{

		Connection conn=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=conn.prepareStatement("delete from khachhangmuon where makhm=?");
			stmt.setString(1, khhm);
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
		
	}
	
	
}
