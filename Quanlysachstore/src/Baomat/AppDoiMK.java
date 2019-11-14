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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.database;

public class AppDoiMK extends JFrame implements ActionListener, MouseListener{

	JTextField txtUser, txtPass, txtNewPass, txtPass2;
	JButton btnOK, btnThoat;
	public AppDoiMK() {
		setTitle("Thẻ thuê");
		setSize(600, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblTieude;
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		pnNorth.add(lblTieude = new JLabel("THÔNG TIN TÀI KHOẢN"));
		lblTieude.setFont(new Font("Arial", Font.BOLD, 30));
		lblTieude.setForeground(Color.darkGray);
		pnNorth.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblusername, lblpass, lblnewpass, lblpass2;
		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		//pnCenter.setBounds(20, 20, 200, 200);
		pnCenter.setPreferredSize(new Dimension(0, 100));
		pnCenter.setBorder(BorderFactory.createTitledBorder("Thông tin"));
		pnCenter.setLayout(null);
		
		pnCenter.add(lblusername = new JLabel("Tên tài khoản:"));
		pnCenter.add(lblpass = new JLabel("Mật khẩu cũ:"));
		pnCenter.add(lblnewpass = new JLabel("Mật khẩu mới:"));
		pnCenter.add(lblpass2 = new JLabel("Đánh lại mật khẩu:"));
		
		pnCenter.add(txtUser = new JTextField());
		pnCenter.add(txtPass = new JTextField());
		pnCenter.add(txtNewPass = new JTextField());
		pnCenter.add(txtPass2 = new JTextField());
		
		lblusername.setBounds(140, 20, 120, 20);			txtUser.setBounds(260, 20, 200, 20);
		lblpass.setBounds(140, 60, 120, 20);				txtPass.setBounds(260, 60, 200, 20);
		lblnewpass.setBounds(140, 100, 120, 20);			txtNewPass.setBounds(260, 100, 200, 20);
		lblpass2.setBounds(140, 140, 120, 20);			txtPass2.setBounds(260, 140, 200, 20);

		JPanel pnSouth = new JPanel();
		add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setPreferredSize(new Dimension(0, 100));
		pnSouth.setBorder(BorderFactory.createTitledBorder(""));
		pnSouth.setLayout(null);
		
		pnSouth.add(btnOK = new JButton("OK",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\ok.PNG")));
		pnSouth.add(btnThoat = new JButton("Thoát",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\thoat.PNG")));
		
		btnOK.setBounds(210, 30, 100, 40);
		btnThoat.setBounds(330, 30, 100, 40);
		
		btnOK.addActionListener(this);
		btnThoat.addActionListener(this);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppDoiMK admk = new AppDoiMK();
		admk.setVisible(true);
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
		if(o.equals(btnOK))
			LuuActions();
		if(o.equals(btnThoat))
			ThoatActions();
		
	}
	private void ThoatActions() {
		// TODO Auto-generated method stub
		setVisible(false);
	}
	private void LuuActions() {
		database.getinstance().connect();

		String sql="UPDATE nguoidung SET"
				+ " tentaikh = ?, "
				+ " matkhau = ? "
				+ " WHERE tentaikh= ? ";
		Connection conn=database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		
		
			try {
				

					

				if(kiemtrammkhaucu())
				{
					stmt=conn.prepareStatement(sql);
					stmt.setString(1,txtUser.getText());
					stmt.setString(2, txtNewPass.getText());
					stmt.setString(3, txtUser.getText());
				
				if(txtPass2.getText().equals(txtNewPass.getText()))
				{
					JOptionPane.showMessageDialog(this,"bạn nhập đã thành công!");
					n=stmt.executeUpdate();
					setVisible(false);
				}
				else 
				{
					JOptionPane.showMessageDialog(this,"nhập lại  mật khẩu mới !");
					System.out.println(txtNewPass.getText());
					txtPass2.requestFocus();
				}
				
				
				}
			
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		
		return;
		
	}
	private boolean kiemtrammkhaucu() {
		// TODO Auto-generated method stub
		database.getinstance().connect();
		String sql="select matkhau from nguoidung";
		Connection con=database.getinstance().getconnection();
		Statement stmt;
		try {
			stmt =con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String makh=rs.getString(1);
				if(makh.equals(txtPass.getText()))
				{
				
					return true;
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
		
		
	}

}
