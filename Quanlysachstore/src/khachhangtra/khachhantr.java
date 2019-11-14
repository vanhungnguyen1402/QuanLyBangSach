package khachhangtra;

import java.sql.Date;

public class khachhantr {

	private String makhhm;
	private String manv;
	private String tensach;
	private Date ngaythue;
	private String sophieu;
	private Date ngaytr;
	private String tinhtrang;
	private String ghichu;

	public khachhantr() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param makhhm
	 * @param tenbangdia
	 * @param ngaythue
	 * @param sophieu
	 */
	public khachhantr(String makhhm, String tensach, Date ngaythue, String sophieu) {
		super();
		this.makhhm = makhhm;
		this.tensach = tensach;
		this.ngaythue = ngaythue;
		this.sophieu = sophieu;
	}

	public khachhantr(String makhhm, String manv, String tensach, java.util.Date ngaythu, String sophieu, java.util.Date ngaytr2,
			String tinhtrang, String ghichu) {
		super();
		this.makhhm = makhhm;
		this.manv = manv;
		this.tensach = tensach;
		this.ngaythue = (Date) ngaythu;
		this.sophieu = sophieu;
		this.ngaytr = (Date) ngaytr2;
		this.tinhtrang = tinhtrang;
		this.ghichu = ghichu;
		
	}
	public String getMakhhm() {
		return makhhm;
	}
	public void setMakhhm(String makhhm) {
		this.makhhm = makhhm;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public Date getNgaythue() {
		return ngaythue;
	}
	public void setNgaythue(Date ngaythue) {
		this.ngaythue = ngaythue;
	}
	public String getSophieu() {
		return sophieu;
	}
	public void setSophieu(String sophieu) {
		this.sophieu = sophieu;
	}
	public Date getNgaytr() {
		return ngaytr;
	}
	public void setNgaytr(Date ngaytr) {
		this.ngaytr = ngaytr;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((makhhm == null) ? 0 : makhhm.hashCode());
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
		khachhantr other = (khachhantr) obj;
		if (makhhm == null) {
			if (other.makhhm != null)
				return false;
		} else if (!makhhm.equals(other.makhhm))
			return false;
		if (manv == null) {
			if (other.manv != null)
				return false;
		} else if (!manv.equals(other.manv))
			return false;
		return true;
	}
	
	
}