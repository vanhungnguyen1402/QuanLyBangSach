package thongtinnhanvien;

import java.util.Date;

public class nhanvien {
	
	private String manv;
	private String hoten;
	private String gioitinh;
	private Date ngaysinh;
	private double tienluong;
	private String chucvu;
	private String sodt;
	private String diachi;
	public nhanvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public nhanvien(String manv, String hoten, String gioitinh, Date ngaysinh, double tienluong, String chucvu,
			String sodt, String diachi) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.tienluong = tienluong;
		this.chucvu = chucvu;
		this.sodt = sodt;
		this.diachi = diachi;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public double getTienluong() {
		return tienluong;
	}
	public void setTienluong(double tienluong) {
		this.tienluong = tienluong;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manv == null) ? 0 : manv.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		nhanvien other = (nhanvien) obj;
		if (manv == null) {
			if (other.manv != null)
				return false;
		} else if (!manv.equals(other.manv))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
