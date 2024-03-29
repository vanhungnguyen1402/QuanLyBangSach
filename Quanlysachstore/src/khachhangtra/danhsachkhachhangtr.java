package khachhangtra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import database.database;
import khachhangmuon.khachhangmuon;

public class danhsachkhachhangtr {

	ArrayList<khachhantr> dskhtr;
	khachhantr khtr;
	public danhsachkhachhangtr()
	{
		dskhtr=new ArrayList<khachhantr>();
		khtr=new khachhantr();
	}
	public ArrayList<khachhantr> doctubangkhachhangtr()
	{
		Connection conn=database.getinstance().getconnection();
		String sql="select *from khachhangtr";
		Statement satement;
		try {
			satement=conn.createStatement();
			ResultSet rs=satement.executeQuery(sql);
			while(rs.next())
			{
				String makh=rs.getString(1);
				String manv=rs.getString(2);
				String tensach=rs.getString(3);
				Date ngaythu=(Date) rs.getObject(4);
				String sphieu=rs.getString(5);
				
				Date ngaytr=(Date) rs.getObject(6);
				
				String tinhtr=rs.getString(7);
				String ghichu=rs.getString(8);
				
				
				//khachhantr tt=new khachhantr(makh, tenbangdia, (java.sql.Date) ngaythu, sphieu);
				khachhantr tt=new khachhantr(makh, manv, tensach, ngaythu, sphieu, ngaytr, tinhtr, ghichu);
				dskhtr.add(tt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskhtr;
		
	}
	public boolean create(String makhm,String manv,String tensach,Date ngaythu,String sphieu,Date ngaytr,
			String tinhtr,String ghichu)
	
	{
		Connection conn=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=conn.prepareStatement("insert into khachhangtr values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, makhm);
			stmt.setString(2, manv);
			stmt.setString(3, tensach);
			stmt.setDate(4, new java.sql.Date(ngaythu.getTime()));
			stmt.setString(5, sphieu);
			stmt.setDate(6, new java.sql.Date(ngaytr.getTime()));
			stmt.setString(7, tinhtr);
			stmt.setString(8, ghichu);
			
			n=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean update(String makhm,Date ngaytr,String tinhtr,String ghichu)
	{
		Connection conn=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=conn.prepareStatement("update khachhangtr set"
					+ " ngaytr = ?,"
					+ " tinhtrang = ?,"
					+ " ghichu = ?"
					+ " where makhm =?");
			stmt.setDate(1, new java.sql.Date(ngaytr.getTime()));
			stmt.setString(2, tinhtr);
			stmt.setString(3,ghichu);
			stmt.setString(4,makhm );
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			stmt=conn.prepareStatement("delete from khachhangtr where makhm=?");
			stmt.setString(1, khhm);
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
		
	}
	
}
