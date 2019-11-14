package GiaoDien;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



import Baomat.dangnhapapp;



public class AppThueSach extends JFrame implements ActionListener{

	JLabel label = new JLabel();
	JMenuBar mnubar;
	JMenu mnuHethong, mnuQuanli, mnuTimkiem, mnuThongke,mnutrogiup;
	JMenuItem mnuHTDangnhap, mnuHTDoimatkhau, mnuHTQuanlind, mnuHTDangxuat, mnuHTThoat,mnukhachhangmuon,mnunhanvien;
	JMenuItem mnuQLBangsach, mnuQLKhachhang;
	JMenuItem mnuTKBangsach, mnuTKKhachhang;
	//JMenuItem mnu;
	
	public AppThueSach() {
		setTitle("Cho Thue Sach");
		setBounds(180, 40,1000,650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		mnubar = new JMenuBar();
		setJMenuBar(mnubar);
		
		mnuHethong = new JMenu("Hệ Thống");		mnubar.add(mnuHethong);
		mnuQuanli = new JMenu("Quản lí");		mnubar.add(mnuQuanli);
		
		mnuThongke = new JMenu("Thống kê");		mnubar.add(mnuThongke);
		mnutrogiup=new JMenu("Trợ Giúp");   mnubar.add(mnutrogiup);
		
		mnuHTDangnhap = new JMenuItem("Đăng nhập");				mnuHethong.add(mnuHTDangnhap);
		mnuHTDoimatkhau = new JMenuItem("Đổi mật khẩu");			mnuHethong.add(mnuHTDoimatkhau);
		mnuHTQuanlind = new JMenuItem("Quản lí người dùng");		mnuHethong.add(mnuHTQuanlind);
		mnuHTDangxuat = new JMenuItem("Đăng xuất");				mnuHethong.add(mnuHTDangxuat);
																	mnuHethong.addSeparator();
		mnuHTThoat = new JMenuItem("Thoát");						mnuHethong.add(mnuHTThoat);
		
		mnuHTDangnhap.setToolTipText("Dăng nhập tài khoảng");
		
		mnuQLBangsach = new JMenuItem("Bang Sach");				mnuQuanli.add(mnuQLBangsach);
		mnuQLKhachhang = new JMenuItem("Khách hàng");			mnuQuanli.add(mnuQLKhachhang);
		mnunhanvien=new JMenuItem("Nhân viên");                 mnuQuanli.add(mnunhanvien);
		 mnukhachhangmuon=new JMenuItem("Khách hàng mượn") ;	mnuQuanli.addSeparator();
		  														mnuQuanli.add(mnukhachhangmuon);
		
		mnuTKBangsach = new JMenuItem("Thông tin băng đĩa");		mnuThongke.add(mnuTKBangsach);
		mnuTKKhachhang = new JMenuItem("Thông tin khách hàng");	mnuThongke.add(mnuTKKhachhang);
		mnuHTThoat.setToolTipText("Thoát Ứng Dụng");
		add(label);
		label.setLayout(null);
		label.setBounds(180, 40,1000,650);
		
		try {
			BufferedImage image = ImageIO.read(new File("K:\\qlbangsach\\Quanlysachstore\\kkk.jpg"));
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
		
		mnuHTDoimatkhau.setEnabled(false);
		mnuHTDangxuat.setEnabled(false);
		mnuHTQuanlind.setEnabled(false);
		mnuHTThoat.addActionListener(this);
		mnuQLBangsach.setEnabled(false);
		mnuQLKhachhang.setEnabled(false);
		mnuTKBangsach.setEnabled(false);
		mnuTKKhachhang.setEnabled(false);
		mnukhachhangmuon.setEnabled(false);
		mnutrogiup.addActionListener(this);
		mnunhanvien.setEnabled(false);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppThueSach acd = new AppThueSach();
		acd.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(mnuHTDangnhap))
			DangnhapActions();
		if(o.equals(mnuHTThoat))
			ThoatActions();
	}

	private void ThoatActions() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	private void DangnhapActions() {
		// TODO Auto-generated method stub
		dangnhapapp dna = new dangnhapapp();
		dna.main(null);
		setVisible(false);
	}
}
