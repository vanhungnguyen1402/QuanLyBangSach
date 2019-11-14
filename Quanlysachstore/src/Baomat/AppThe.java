package Baomat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.toedter.calendar.JDateChooser;

import database.database;


public class AppThe extends JFrame implements ActionListener, MouseListener{

	JTextField txtHoten, txtDiachi, txtMathe;
	JDateChooser txtNgayHH;
	JButton btnLuu, btnThoat;
	public AppThe() {
		setTitle("Thẻ thuê");
		setSize(600, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblTieude;
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		pnNorth.add(lblTieude = new JLabel("THẺ THUÊ SÁCH"));
		lblTieude.setFont(new Font("Arial", Font.BOLD, 30));
		lblTieude.setForeground(Color.darkGray);
		pnNorth.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblhoten, lbldiachi, lblmathe, lblngayHH;
		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		//pnCenter.setBounds(20, 20, 200, 200);
		pnCenter.setPreferredSize(new Dimension(0, 100));
		pnCenter.setBorder(BorderFactory.createTitledBorder("Thông tin"));
		pnCenter.setLayout(null);
		
		pnCenter.add(lblhoten = new JLabel("Họ tên:"));
		pnCenter.add(lbldiachi = new JLabel("Địa chỉ:"));
		pnCenter.add(lblmathe = new JLabel("Mã thẻ:"));
		pnCenter.add(lblngayHH = new JLabel("Ngày hết hạn:"));
		
		pnCenter.add(txtHoten = new JTextField());
		pnCenter.add(txtDiachi = new JTextField());
		pnCenter.add(txtMathe = new JTextField());
		pnCenter.add(txtNgayHH = new JDateChooser());
		
		lblhoten.setBounds(160, 20, 100, 20);			txtHoten.setBounds(250, 20, 200, 20);
		lbldiachi.setBounds(160, 60, 100, 20);			txtDiachi.setBounds(250, 60, 200, 20);
		lblmathe.setBounds(160, 100, 100, 20);			txtMathe.setBounds(250, 100, 200, 20);
		lblngayHH.setBounds(160, 140, 100, 20);			txtNgayHH.setBounds(250, 140, 200, 20);

		JPanel pnSouth = new JPanel();
		add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setPreferredSize(new Dimension(0, 100));
		pnSouth.setBorder(BorderFactory.createTitledBorder(""));
		pnSouth.setLayout(null);
		
		pnSouth.add(btnLuu = new JButton("Lưu",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\ok.PNG")));
		pnSouth.add(btnThoat = new JButton("Thoát",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\thoat.PNG")));
		
		btnLuu.setBounds(210, 30, 100, 40);
		btnThoat.setBounds(330, 30, 100, 40);
		txtNgayHH.setDateFormatString("dd-MM-yyyy");
		btnLuu.addActionListener(this);
		btnThoat.addActionListener(this);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppThe at = new AppThe();
		at.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o.equals(btnLuu))
			LuuActions();
		if(o.equals(btnThoat))
			ThoatActions();
		
	}
	private void ThoatActions() {
		// TODO Auto-generated method stub
	//	AppKhachHang akh = new AppKhachHang();
//		akh.main(null);
//		setVisible(false);
//		
	}
	private void LuuActions() {
		// TODO Auto-generated method stub
//		danhsachthe dsthe=new danhsachthe();
//		dsthe.create(txtHoten.getText(), txtDiachi.getText(),txtMathe.getText(), txtNgayHH.getDate());
//	//	AppKhachHang akh = new AppKhachHang();
//		akh.main(null);
//		setVisible(false);
	}

}
