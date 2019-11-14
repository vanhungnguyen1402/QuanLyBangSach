package Bangsach;

public class sach {
	private String masach;
	private String tensach;
	private String theloai;
	private String hansx;
	private double giathue;
	private String ghichu;
	public sach(String masach, String tensach, String theloai, String hansx, double giathue, String ghichu) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.theloai = theloai;
		this.hansx = hansx;
		this.giathue = giathue;
		this.ghichu = ghichu;
	}
	public sach(String masach) {
		this(masach,"","","",0.0,"");
	}
	public sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTencd(String tensach) {
		this.tensach= tensach;
	}
	public String getTheloai() {
		return theloai;
	}
	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}
	public String getHansx() {
		return hansx;
	}
	public void setHansx(String hansx) {
		this.hansx = hansx;
	}
	public double getGiathue() {
		return giathue;
	}
	public void setGiathue(double giathue) {
		this.giathue = giathue;
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
		result = prime * result + ((masach == null) ? 0 : masach.hashCode());
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
		sach other = (sach) obj;
		if (masach == null) {
			if (other.masach != null)
				return false;
		} else if (!masach.equals(other.masach))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  masach + ";" + tensach + ";" + theloai + ";" + hansx + ";"
				+ giathue + ";" + ghichu;
	}
	
	

}
