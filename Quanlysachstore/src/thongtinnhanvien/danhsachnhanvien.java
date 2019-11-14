package thongtinnhanvien;

import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.database;

public class danhsachnhanvien {
	ArrayList<nhanvien> dsnv;
	nhanvien nv;
	public danhsachnhanvien()
	{
		dsnv=new ArrayList<nhanvien>();
		nv=new nhanvien();
	}
	public ArrayList<nhanvien> doctubangnhanvien()
	{
		Connection con=database.getinstance().getconnection();
		String sql="select *from nhanvien";
		Statement statement;
		try {
			statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String manv=rs.getString(1);
				String hoten=rs.getString(2);
				String gioitinh=rs.getString(3);
				Date ngay=(Date) rs.getObject(4);
				Float tienl=rs.getFloat(5);
				String chucv=rs.getString(6);
				String sodt=rs.getString(7);
				String diachi=rs.getString(8);
				nhanvien nn=new nhanvien(manv, hoten, gioitinh, ngay, tienl, chucv, sodt, diachi);
				dsnv.add(nn);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public boolean create(String manv,String hoten,String gioitinh,java.util.Date ngaysinh,Float tienlu,String chucv,String sodt,String diachi)
	{
		Connection con=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into nhanvien values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, manv);
			stmt.setString(2, hoten);
			stmt.setString(3, gioitinh);
			stmt.setDate(4, new Date(ngaysinh.getTime()));
			stmt.setFloat(5, tienlu);
			stmt.setString(6, chucv);
			stmt.setString(7, sodt);
			stmt.setString(8, diachi);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
		
	}
	public boolean update(String manv,String hoten,String gioitinh,java.util.Date date,Float tienlu,String chucv,String sodt,String diachi)
	{
		Connection con=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("UPDATE nhanvien SET "
					+ " hoten = ?,"
					+ " gioitinh = ?,"
					+ " ngaysinh = ?,"
					+ " tienluong = ?,"
					+ " chucvu = ?,"
					+ " sodt = ?,"
					+ " diachi = ?"
					+ " WHERE manv = ?");
			
			stmt.setString(1, hoten);
			stmt.setString(2, gioitinh);
			stmt.setDate(3,new Date(date.getTime()));
			stmt.setFloat(4, tienlu);
			stmt.setString(5, chucv);
			stmt.setString(6, sodt);
			stmt.setString(7, diachi);
			stmt.setString(8, manv);
			n=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String manv)
	{

		Connection conn=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=conn.prepareStatement("delete from nhanvien where manv=?");
			stmt.setString(1, manv);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
}
