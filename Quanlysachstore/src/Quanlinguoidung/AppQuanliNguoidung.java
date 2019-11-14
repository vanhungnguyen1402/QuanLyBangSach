package Quanlinguoidung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import GiaoDien.AppThueSach2;
import database.database;

public class AppQuanliNguoidung extends JFrame implements ActionListener, MouseListener{

	private String [] s = {"Nam", "Nữ"};
	 private JTextField txtHoten, txtPhone, txtManv, txtTentk, txtMK,txtmangd; 
	private JComboBox cboGioitinh;
	private JButton btnThem, btnSua, btnXoa, btnThoat,btnluu,btnxoatrang;
	
	JTable table;
	DefaultTableModel tableModel;
	private ArrayList<nguoidung> list;
	danhsachnguoidung dsngd=new danhsachnguoidung();
	public AppQuanliNguoidung() {
		setTitle("App Quản lí Người dùng");
		setBounds(180, 40,1000,650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblTieude;
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		pnNorth.add(lblTieude = new JLabel("THÔNG TIN NGƯỜI DÙNG"));
		lblTieude.setFont(new Font("Arial", Font.BOLD, 30));
		lblTieude.setForeground(Color.BLACK);
		pnNorth.setBackground(Color.LIGHT_GRAY);
		
		
		JLabel lblhoten, lblgioitinh, lblphone, lblmanv, lbltentk, lblmk,lblmangd;
		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		
		//pnCenter.setPreferredSize(new Dimension(300,0));
		pnCenter.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));
		
		pnCenter.add(lblmangd=new JLabel("Mã người dùng:",JLabel.RIGHT));  pnCenter.add(txtmangd=new JTextField());
		pnCenter.add(lblhoten = new JLabel("Họ và tên: ",JLabel.RIGHT));			pnCenter.add(txtHoten = new JTextField());
		pnCenter.add(lblgioitinh = new JLabel("Giới tính: ",JLabel.RIGHT));			pnCenter.add(cboGioitinh = new JComboBox(s));
		pnCenter.add(lblphone = new JLabel("Số điện thoại: ",JLabel.RIGHT));		pnCenter.add(txtPhone = new JTextField());
		pnCenter.add(lblmanv = new JLabel("Mã nv: ",JLabel.RIGHT));				pnCenter.add(txtManv = new JTextField());
		pnCenter.add(lbltentk = new JLabel("Tên tài khoản: ",JLabel.RIGHT));		pnCenter.add(txtTentk = new JTextField());
		pnCenter.add(lblmk = new JLabel("Mật khẩu: ",JLabel.RIGHT));				pnCenter.add(txtMK = new JTextField());
		
		lblmangd.setBounds(20,20,90,25);                            txtmangd.setBounds(110, 20, 250, 25);
		lblhoten.setBounds(20, 60, 90, 25);							txtHoten.setBounds(110, 60, 250, 25);
		lblgioitinh.setBounds(20, 100, 90, 25);						cboGioitinh.setBounds(110, 100, 80, 25);
		lblphone.setBounds(400, 100, 100, 25);						txtPhone.setBounds(500, 100, 250, 25);
		lblmanv.setBounds(20, 140, 90, 25);						txtManv.setBounds(110, 140, 640, 25);
		lbltentk.setBounds(400, 20,85, 25);						txtTentk.setBounds(500, 20, 250, 25);
		lblmk.setBounds(400, 60, 100, 25);							txtMK.setBounds(500, 60, 250, 25);
		
		//int x=130,y=180,width=200,height=40;
		JPanel pnmenu=new JPanel();
		pnmenu.setBounds(110,180,640, 70);
		pnmenu.setPreferredSize(new Dimension(0,100));
		pnmenu.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),"Chọn Tác Vụ"));
		pnCenter.add(pnmenu);

		pnmenu.add(btnThem=new JButton("Thêm",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\them.PNG")));
//		btnThem.setBounds(x, y, width, height);
//		x+=85;
		pnmenu.add(btnluu=new JButton("Lưu",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\luu.PNG")));
		pnmenu.add(btnSua=new JButton("Sửa",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\capnhat.PNG")));
//		btnSua.setBounds(x, y, width, height);
//		x+=85;
		pnmenu.add(btnXoa=new JButton("Xóa",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\xoa.PNG")));
		
//		btnXoa.setBounds(x, y, width, height);
//		x+=85;
		
//		btnluu.setBounds(x, y, width, height);
//		x=+85;
		pnmenu.add(btnThoat=new JButton("Thoát",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\thoat.PNG")));
//		btnThoat.setBounds(x, y, width, height);
		
		
		JPanel pneast=new JPanel();
		pneast.setPreferredSize(new Dimension(230,0));
		//pneast.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.red)));
		add(pneast,BorderLayout.EAST);
		
		JLabel lblanh=new JLabel();
		lblanh.setLayout(null);
		lblanh.setBounds(0, 0,250,200);
		try {
			BufferedImage image= ImageIO.read(new File("K:\\qlbangsach\\Quanlysachstore\\nguoidung.jpg"));
			int x=lblanh.getSize().width;
			int y=lblanh.getSize().height;
			int ix=image.getWidth();
			int iy=image.getHeight();
			int dx=0;
			int dy=0;
			if(x / y > ix / iy)
			{
				dy=y;
				dx=dy * ix / iy;
				
			}
			else {
				dx=x;
				dy=dx * iy / ix;
			}
			ImageIcon icon=new ImageIcon(image.getScaledInstance(dx, dy,image.SCALE_SMOOTH));
			lblanh.setIcon(icon);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		pneast.add(lblanh);
		
		

		
		pnCenter.setLayout(null);
		

		
		JScrollPane scroll;
		String [] headers = "Ma ngd;Họ tên;Tên Tài khoản;Mật Khẩu;Giới Tính;SoDT;Mã NV".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setPreferredSize(new Dimension(0, 300));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách"));
		table.setRowHeight(20);
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		btnluu.addActionListener(this);
		//btnxoatrang.addActionListener(this);
		table.addMouseListener(this);
		
		database.getinstance().connect();
		updatetabledata();
		mokhoatextfield(false);
		btnluu.setEnabled(false);
	}
	
	private void updatetabledata() {
		danhsachnguoidung ds=new danhsachnguoidung();
		List<nguoidung> list=ds.doctubangnguoidung();
		for(nguoidung ng:list)
		{
			String [] rowdata= {ng.getMangd(),ng.getHoten(),ng.getTentaikh(),ng.getMatkhau(),ng.getGioitinh(),ng.getSodt(),ng.getManv()+""};
			tableModel.addRow(rowdata);
		}
		table.setModel(tableModel);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppQuanliNguoidung aqlnd = new AppQuanliNguoidung();
		aqlnd.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnThem))
		{
			if(btnThem.getText().equals("Thêm"))
			{
				mokhoatextfield(true);
				mokhoacontrol(false);
				btnluu.setEnabled(true);
				btnThem.setEnabled(true);
				xoatongactions();
				btnThem.setText("Hủy");
			}
			else
			{
				if(btnThem.getText().equalsIgnoreCase("Hủy"))
				{
					mokhoatextfield(false);
					mokhoacontrol(true);
					btnluu.setEnabled(false);
					btnThem.setText("Thêm");
					xoatongactions();
					txtmangd.setEditable(false);
				}
			}
		}
		else
		{
			if(o.equals(btnSua))
			{
				if(btnSua.getText().equalsIgnoreCase("Sửa"))
				{
					mokhoatextfield(true);
					naplopnguoidungvaotextfield();
					mokhoacontrol(false);
					btnluu.setEnabled(true);
					btnSua.setEnabled(true);
					btnSua.setText("Hủy");
					txtmangd.setEditable(false);
					
				}
				else
				{
					if(btnSua.getText().equalsIgnoreCase("Hủy"))
					{
						mokhoacontrol(true);
						mokhoatextfield(false);
						btnSua.setText("Sửa");
						btnluu.setEnabled(false);
						naplopnguoidungvaotextfield();
					}
				}
			}
			else
				if(o.equals(btnluu))
				{
					if(btnThem.getText().equalsIgnoreCase("Hủy"))
					{
						try {
							if(dsngd.create(txtmangd.getText(),txtHoten.getText(),txtTentk.getText(),txtMK.getText(),cboGioitinh.getSelectedItem().toString(),txtPhone.getText(),txtManv.getText()))
								{
									Object [] rowdata= {txtmangd.getText(),txtHoten.getText(),txtTentk.getText(),txtMK.getText(),cboGioitinh.getSelectedItem().toString(),txtPhone.getText(),txtManv.getText()};
									tableModel.addRow(rowdata);
									mokhoatextfield(false);
									mokhoacontrol(true);
									btnluu.setEnabled(false);
									btnThem.setText("Thêm");
									xoatongactions();
								}
							
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(this,"bạn nhập dữ liệu chưa đúng !xin nhập lại");
							e2.printStackTrace();
						}
					}
					else
					
						if(btnSua.getText().equalsIgnoreCase("Hủy"))
						{
							int row=table.getSelectedRow();
							if(row>=0)
							{
								try {
									if(dsngd.update(txtmangd.getText(),txtHoten.getText(),txtTentk.getText(),txtMK.getText(),cboGioitinh.getSelectedItem().toString(),txtPhone.getText(),txtManv.getText()))
									{
										
										table.setValueAt(txtHoten.getText(), row,1);
										table.setValueAt(txtTentk.getText(), row,2);
										table.setValueAt(txtMK.getText(), row,3);
										table.setValueAt(cboGioitinh.getSelectedItem().toString(), row,4);
										table.setValueAt(txtPhone.getText(), row,5);
										table.setValueAt(txtManv.getText(), row,6);
										mokhoatextfield(false);
										mokhoacontrol(true);
										btnluu.setEnabled(false);
										btnSua.setText("Sửa");
										xoatongactions();
									}
									
								} catch (Exception e2) {
									// TODO: handle exception
									JOptionPane.showMessageDialog(this,"bạn nhập dữ liệu chưa đúng ! xin nhập lại");
								}
								
							}
						}
					
					
				}
				else
					if(o.equals(btnXoa))
					{
						int row=table.getSelectedRow();
						if(row>=0)
						{
							String mangd=(String) table.getValueAt(row, 0);
							int hoinhac=JOptionPane.showConfirmDialog(this,"Bạn Có Chắc chắn xóa không","chú ý",JOptionPane.YES_NO_OPTION);
							if(hoinhac==JOptionPane.YES_OPTION)
								if(dsngd.delete(mangd))
								{
									tableModel.removeRow(row);
									xoatongactions();
								}
						}
					}
			
		}
		if(o.equals(btnThoat))
		{
			AppThueSach2 app=new AppThueSach2();
			app.main(null);
			setVisible(false);
			
		}
		

	}
	private void xoatongactions() {
		txtmangd.setText("");
		txtHoten.setText("");
		txtTentk.setText("");
		txtMK.setText("");
		txtPhone.setText("");
		txtManv.setText("");
		txtmangd.requestFocus();
		//txtmangd.setEditable(true);
	}

	
	

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int row=table.getSelectedRow();
		txtmangd.setText(table.getValueAt(row, 0).toString());
		txtHoten.setText(table.getValueAt(row, 1).toString());
		txtTentk.setText(table.getValueAt(row, 2).toString());
		txtMK.setText(table.getValueAt(row, 3).toString());
		cboGioitinh.setSelectedItem(table.getValueAt(row, 4).toString());
		txtPhone.setText(table.getValueAt(row, 5).toString());
		txtManv.setText(table.getValueAt(row, 6).toString());
		
		
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
	private void naplopnguoidungvaotextfield()
	{
		int row=table.getSelectedRow();
		try {
			txtmangd.setText((String) table.getValueAt(row, 0).toString());
			txtHoten.setText((String) table.getValueAt(row, 1).toString());
			txtTentk.setText((String) table.getValueAt(row, 2).toString());
			txtMK.setText((String) table.getValueAt(row, 3).toString());
			cboGioitinh.setSelectedItem((String) table.getValueAt(row, 4).toString());
			txtPhone.setText((String) table.getValueAt(row, 5).toString());
			txtManv.setText((String) table.getValueAt(row, 6).toString());
			
			
		} catch (Exception e) {
		
			//JOptionPane.showMessageDialog(this,"bạn cần chọn dòng cần sửa !");
			return ;
			// TODO: handle exception
		}
		
	}
	private void mokhoacontrol(boolean b)
	{
		btnThem.setEnabled(b);
		btnluu.setEnabled(b);
		btnSua.setEnabled(b);
		btnXoa.setEnabled(b);
		btnThoat.setEnabled(b);
		
	}
	private void mokhoatextfield(boolean b)
	{
		txtmangd.setEditable(b);
		txtHoten.setEditable(b);
		txtTentk.setEditable(b);
		txtMK.setEditable(b);
		cboGioitinh.setEnabled(b);
		txtPhone.setEditable(b);
		txtManv.setEditable(b);
		
	}

}
