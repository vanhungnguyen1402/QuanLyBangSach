package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Bangsach.demo;
import Baomat.AppDoiMK;
import Baomat.dangnhapapp;
import Quanlinguoidung.AppQuanliNguoidung;
import khachhangmuon.AppkhachhangM;
import thongtinnhanvien.displaynhanvien;



public class AppThueSach2 extends JFrame implements ActionListener{

	JLabel label = new JLabel();
	JMenuBar mnubar;
	JMenu mnuHethong, mnuQuanli, mnuTimkiem, mnuThongke, menukhachang, mnutrogiup;
	JMenuItem mnuHTDangnhap, mnuHTDoimatkhau, mnuHTQuanlind, mnuHTDangxuat, mnuHTThoat,mnunhanvien,mnuTGlienhe;
	JMenuItem mnuQLBangsach, mnuQLKhachhang,mnukhachhangm,mnukhachhangtr;
	JMenuItem mnuTKBangsach, mnuTKKhachhang;
	
	//JMenuItem mnu;
	
	public AppThueSach2() {
		setTitle("BOOK STORE");
		setBounds(180, 40,1000,650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		mnubar = new JMenuBar();
		setJMenuBar(mnubar);
		
		mnuHethong = new JMenu("Hệ thống");		mnubar.add(mnuHethong);
		mnuQuanli = new JMenu("Quản lí");		mnubar.add(mnuQuanli);

		mnuThongke = new JMenu("Thống kê");		mnubar.add(mnuThongke);
		mnutrogiup=new JMenu("Trợ Giúp");   mnubar.add(mnutrogiup);
		
		mnuHTDangnhap = new JMenuItem("Đăng nhập");				mnuHethong.add(mnuHTDangnhap);
		mnuHTDoimatkhau = new JMenuItem("Đổi mật khẩu");			mnuHethong.add(mnuHTDoimatkhau);
		mnuHTQuanlind = new JMenuItem("Quản lí người dùng");		mnuHethong.add(mnuHTQuanlind);
		mnuHTDangxuat = new JMenuItem("Đăng xuât");				mnuHethong.add(mnuHTDangxuat);
		mnuHethong.addSeparator();
		mnuHTThoat = new JMenuItem("Thoát");						mnuHethong.add(mnuHTThoat);

		mnunhanvien=new JMenuItem("Nhân viên");					mnuQuanli.add(mnunhanvien);
		mnuQLBangsach = new JMenuItem("Bảng Sách");				mnuQuanli.add(mnuQLBangsach);
		
		  mnuQuanli.addSeparator();
		menukhachang = new JMenu("Khách hàng");			mnuQuanli.add(menukhachang);
		
		//mnuQLKhachhang=new JMenuItem("Khách Hàng"); menukhachang.add(mnuQLKhachhang);
		menukhachang.addSeparator();
		mnukhachhangm=new JMenuItem("Khách Hàng mượn"); menukhachang.add(mnukhachhangm);
		
		
		mnukhachhangtr=new JMenuItem("Khách hàng Trả");         menukhachang.add(mnukhachhangtr);
		mnuTGlienhe=new JMenuItem("Hướng Dẫn Sử Dụng");            mnutrogiup.add(mnuTGlienhe);
		
		mnuTKBangsach = new JMenuItem("Thông tin sách");		mnuThongke.add(mnuTKBangsach);
		mnuTKKhachhang = new JMenuItem("Thông tin khách hàng");	mnuThongke.add(mnuTKKhachhang);
		mnuTKBangsach.setToolTipText("Thống kê thông tin sách ");
		mnuTKKhachhang.setToolTipText("Thống kê thông tin khach hàng");
		mnuHTDoimatkhau.setToolTipText("Đổi Mật Khẩu Ứng Dụng Sách");
		mnuHTDangxuat.setToolTipText("Thoát Ứng Dụng Sách");
		mnuHTQuanlind.setToolTipText("Quản lí người Dùng Tài Khoản Sách");
		mnunhanvien.setToolTipText("Quản lí Nhân Viên Sách");
		mnuQLBangsach.setToolTipText("Quản lí Sách");
		mnukhachhangm.setToolTipText("Quản lí khách Hàng mượn Sách");
		mnukhachhangtr.setToolTipText("Quản lí khách Hàng TRả Sách");
		
		add(label);
		label.setLayout(null);
		label.setBounds(180, 40,1000,650);
		
		try {
			BufferedImage image = ImageIO.read(new File("K:\\qlbangsach\\Quanlysachstore\\sach.jpg"));
			int x = label.getSize().width;
			int y = label.getSize().height;
			int ix = image.getWidth();
			int iy = image.getHeight();
			int dx = 0;
			int dy = 0;
			if(x / y > ix / iy) {
				dy = y;
				dx = dy * ix / iy;
			}else {
				dx = x;
				dy = dx * iy / ix;
			}
			
			ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
			label.setIcon(icon);
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mnuHTDangnhap.addActionListener(this);
		mnuHTDangxuat.addActionListener(this);
		mnuHTDoimatkhau.addActionListener(this);
		mnuHTThoat.addActionListener(this);
		mnuHTQuanlind.addActionListener(this);
		mnuQLBangsach.addActionListener(this);
		//mnuQLKhachhang.addActionListener(this);
		mnukhachhangm.addActionListener(this);
		mnunhanvien.addActionListener(this);
		mnuHTDangnhap.setEnabled(false);
		mnuHTThoat.setEnabled(false);
		mnuTKBangsach.addActionListener(this);
		mnuTKKhachhang.addActionListener(this);
		mnukhachhangtr.addActionListener(this);
		mnuTGlienhe.addActionListener(this);
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppThueSach2 acd = new AppThueSach2();
		acd.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(mnuHTDangnhap))
			DangnhapActions();
		
		if(o.equals(mnuHTDangxuat))
			DangxuatActions();
		if(o.equals(mnuHTDoimatkhau))
			MatkhauActions();
		if(o.equals(mnuHTQuanlind))
			NguoidungActions();
		if(o.equals(mnuQLBangsach))
			BangdiaActions();
		if(o.equals(mnukhachhangm))
			khachhangmuonaction();
		if(o.equals(mnunhanvien))
			nhanvienaction();
		if(o.equals(mnukhachhangtr))
		{
			khachhangtra();
		}
		if(o.equals(mnuTKBangsach))
		{
			demo app=new demo();
			app.thongke();
			
		}
	
		if(o.equals(mnuTGlienhe))
		{
			trogiupaction();
		
		}
		
	}

	private void trogiupaction() {
		
		//apptrogiup app1=new apptrogiup();
		//app1.main(null);
		//setVisible(false);
		String fileName = "K:\\qlbangsach\\Quanlysachstore\\src\\HuongDanSuDung.chm";
		String[] commands = {"cmd", "/c", fileName};
		try {
		Runtime.getRuntime().exec(commands);
		} catch (Exception ex) {
		ex.printStackTrace();
		}
	}

	private void khachhangtra() {
		// TODO Auto-generated method stub
		khachhangtra.khachhangtra app=new khachhangtra.khachhangtra();
		app.main(null);
		setVisible(false);
	}

	private void nhanvienaction() {
		
		displaynhanvien app=new displaynhanvien();
		app.main(null);
		setVisible(false);
	}

	private void khachhangmuonaction() {
		AppkhachhangM app=new AppkhachhangM();
		app.main(null);
		setVisible(false);
		
		
	}

	private void DangnhapActions() {
		// TODO Auto-generated method stub
		dangnhapapp dna=new dangnhapapp();
		dna.main(null);
	}


	private void NguoidungActions() {
		// TODO Auto-generated method stub
		AppQuanliNguoidung aqlnd = new AppQuanliNguoidung();
		aqlnd.main(null);
		setVisible(false);
	}

	private void MatkhauActions() {
		// TODO Auto-generated method stub
		AppDoiMK admk = new AppDoiMK();
		admk.main(null);
	}

	private void DangxuatActions() {
		// TODO Auto-generated method stub
		AppThueSach atcd = new AppThueSach();
		atcd.main(null);
		setVisible(false);
	}

	private void BangdiaActions() {
		// TODO Auto-generated method stub
		demo atbd = new demo();
		atbd.main(null);
		setVisible(false);
	}
}
