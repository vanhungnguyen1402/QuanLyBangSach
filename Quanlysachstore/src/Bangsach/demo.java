package Bangsach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import GiaoDien.AppThueSach2;
import database.database;




public class demo extends JFrame implements ActionListener,MouseListener{
	private JLabel lbltitle,lblmasach,lbltensach,lbltheloai,lblhansx,lblbgiathue,lblghichu;
	private JTextField txtmasach,txttensach,txttheloai,txttim,txthansx,txtgiathue,txtghichu;
	private ArrayList<sach> list;
	
	private JTable table;
	private JComboBox<String> combtheloai;
	private DefaultTableModel tablemodel;
	private JButton btnthem,btntim,btnxoa,btncapnhat,btnxoatrang,btnluu,btnthoat;

	danhsachsach dssach=new danhsachsach();
	
	public demo()
	{
		setTitle("Danh sách sách");
		addcontrol();
		setBounds(180, 40,1000,650);
		
	}

	private void addcontrol() {
		JPanel pnnorth=new JPanel();
		pnnorth.setPreferredSize(new Dimension(0, 50));
		pnnorth.add(lbltitle=new JLabel("QUẢN LÍ SÁCH"));
		lbltitle.setFont(new Font("Arial",Font.BOLD,30));
		lbltitle.setForeground(Color.BLACK);
		add(pnnorth,BorderLayout.NORTH);
		pnnorth.setBackground(Color.LIGHT_GRAY);
		
		JPanel pnleft=new JPanel();
		pnleft.setPreferredSize(new Dimension(300,200));
		pnleft.setBackground(Color.LIGHT_GRAY);
		add(pnleft, BorderLayout.WEST);
		JLabel lblanh=new JLabel();
		lblanh.setLayout(null);
		lblanh.setBounds(0, 50,450,300);
		try {
			BufferedImage image= ImageIO.read(new File("K:\\qlbangsach\\Quanlysachstore\\bangsach.jpg"));
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
		pnleft.add(lblanh);
		
		JPanel pnsouth=new JPanel();
		pnsouth.setPreferredSize(new Dimension(0, 300));
		pnsouth.setBackground(Color.LIGHT_GRAY);
		
		pnsouth.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.GRAY),"Chọn tác Vụ"));
		int x=20,y=30,width=100,height=30;
		
		pnsouth.add(lblmasach=new JLabel("Mã Sách:"));
		lblmasach.setBounds(x, y, width, height);
		y+=40;
		pnsouth.add(lbltensach=new JLabel("Tên Sách:"));
		lbltensach.setBounds(x, y, width, height);
		y+=40;
		pnsouth.add(lbltheloai=new JLabel("Thể Loại:"));
		lbltheloai.setBounds(550, 70, width, height);
		
		String []a= {"Đồng Quê","Nhạc Đỏ","Nhạc Vàng","Loại khác"};
		pnsouth.add(combtheloai=new JComboBox<>(a));
		combtheloai.setBounds(640, 70, width, 25);
		
		
		pnsouth.add(lblhansx=new JLabel("Hãng sản Xuất:"));
		lblhansx.setBounds(x, y, width, height);
		y+=40;
		pnsouth.add(lblbgiathue=new JLabel("Giá thuê:"));
		lblbgiathue.setBounds(x, y, width, height);
		y+=40;
		pnsouth.add(lblghichu=new JLabel("Ghi chú:"));
		lblghichu.setBounds(x, y, width, height);
		y+=30;
		
		x=130;y=30;width=400;height=25;
		pnsouth.add(txtmasach=new JTextField());
		txtmasach.setBounds(x, y, width, height);
		y+=40;
		pnsouth.add(txttensach=new JTextField());
		txttensach.setBounds(x, y, width, height);
		y+=40;
		width=610;
		pnsouth.add(txthansx=new JTextField());
		txthansx.setBounds(x, y, width, height);
		
		y+=40;
		pnsouth.add(txtgiathue=new JTextField());
		txtgiathue.setBounds(x, y, width, height);
		y+=40;
		pnsouth.add(txtghichu=new JTextField());
		txtghichu.setBounds(x, y, width, height);
		y+=30;
		
		//JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		JPanel pnle=new JPanel();
		pnle.setBackground(Color.LIGHT_GRAY);
		pnle.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.GRAY),"Chọn Chức Năng"));
		pnle.setBounds(0, y, 950,70);
		
		
		ImageIcon timicon=new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\tim.PNG");
		pnle.add(btntim=new JButton("Tìm",timicon));
		
		ImageIcon themicon=new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\them.PNG");
		pnle.add(btnthem=new JButton("Thêm",themicon));
		
		ImageIcon luuicon=new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\luu.PNG");
		pnle.add(btnluu=new JButton("Lưu",luuicon));
		
		ImageIcon capicon=new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\capnhat.PNG");
		pnle.add(btncapnhat=new JButton("Sửa",capicon));
		
		ImageIcon xoaicon=new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\xoa.PNG");
		pnle.add(btnxoa=new JButton("Xóa",xoaicon));
		
//		ImageIcon xoatrangicon=new ImageIcon("xoatrang.png");
//		pnle.add(btnxoatrang=new JButton("xoatrang"));
		
		
		
		ImageIcon thoat=new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\thoat.PNG");
		pnle.add(btnthoat=new JButton("Thoát",thoat));
		
		pnsouth.add(pnle);
		//pnle.setLayout(null);
		add(pnsouth, BorderLayout.SOUTH);
		pnsouth.setLayout(null);
		
		Box b=Box.createVerticalBox();
		Box b1;
		b.setPreferredSize(new Dimension(0, 200));
		b.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.GRAY),"Danh sách sách"));
		
		b.add(b1=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		String []headers="MÃ SÁCH;TÊN SÁCH;THỂ LOẠI;HÃNG SẢN XUẤT;GIÁ THUÊ;GHI CHÚ".split(";");
		tablemodel=new DefaultTableModel(headers, 0);
		JScrollPane scroll=new JScrollPane();
		scroll.setViewportView(table=new JTable(tablemodel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		b1.add(scroll);

		add(b, BorderLayout.CENTER);
		btntim.addActionListener(this);
		btnthem.addActionListener(this);
		btnxoa.addActionListener(this);
		btncapnhat.addActionListener(this);
		//btnxoatrang.addActionListener(this);
		btnluu.addActionListener(this);
		btnthoat.addActionListener(this);
		table.addMouseListener(this);
		
		database.getinstance().connect();
		updatetabledata();
		mokhoatextfield(false);
		btnluu.setEnabled(false);
		
		
		
	}

	
	private void updatetabledata() {
		danhsachsach ds=new danhsachsach();
		List< sach> list=ds.doctubangsach();
		for(sach s:list)
		{
			Object [] rowdata= {s.getMasach(),s.getTensach(),s.getTheloai(),s.getHansx(),s.getGiathue(),s.getGhichu()+""};
			tablemodel.addRow(rowdata);
		}
		
	}

	public static void main(String[] args) {
		new demo().setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row=table.getSelectedRow();
		txtmasach.setText(table.getValueAt(row, 0).toString());
		txttensach.setText(table.getValueAt(row, 1).toString());
		combtheloai.setSelectedItem(table.getValueAt(row, 2).toString());
		txthansx.setText(table.getValueAt(row, 3).toString());
		txtgiathue.setText(table.getValueAt(row, 4).toString());
		txtghichu.setText(table.getValueAt(row, 5).toString());
		
		
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void naplopbangdiavaotextfield() {
		int row=table.getSelectedRow();
//		if(row>0)
//		{
		try {
			txtmasach.setText((String )table.getValueAt(row, 0).toString());
			txttensach.setText((String) table.getValueAt(row, 1).toString());
			combtheloai.setSelectedItem((String) table.getValueAt(row, 2).toString());
			txthansx.setText((String) table.getValueAt(row, 3).toString());
			txtgiathue.setText((String) table.getValueAt(row, 4).toString());
			txtghichu.setText((String) table.getValueAt(row, 5).toString());
		} catch (Exception e) {
			// TODO: handle exception
		//	JOptionPane.showMessageDialog(this,"bạn cần chọn dòng cần sửa !");
			return ;
		}
			
			
			
			
//		}
	}
	private void mokhoacontrol(boolean b)
	{
		btnthem.setEnabled(b);
		btncapnhat.setEnabled(b);
		btnxoa.setEnabled(b);
		btnthoat.setEnabled(b);
		btnluu.setEnabled(b);
		btntim.setEnabled(b);
		
	}
	private void mokhoatextfield(boolean b)
	{
		txtmasach.setEditable(b);
		txttensach.setEditable(b);
		combtheloai.setEnabled(b);
		txthansx.setEditable(b);
		txtgiathue.setEditable(b);
		txtghichu.setEditable(b);
		//satxttim.setEditable(b);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(btnthem))
		{
			if(btnthem.getText().equals("Thêm"))
			{
				mokhoatextfield(true);
				mokhoacontrol(false);
				btnluu.setEnabled(true);
				btnthem.setEnabled(true);
				xoatrangactions();
				btnthem.setText("Hủy");
				
			}
			else
			{
				if(btnthem.getText().equalsIgnoreCase("Hủy"))
				{
					mokhoatextfield(false);
					mokhoacontrol(true);
					btnluu.setEnabled(false);
					btnthem.setText("Thêm");
					
					xoatrangactions();
					txtmasach.setEditable(false);
				}
			}
		}
		else
		{
			if(obj.equals(btncapnhat))
			{
				if(btncapnhat.getText().equalsIgnoreCase("Sửa"))
				{
					mokhoatextfield(true);
				naplopbangdiavaotextfield();
				mokhoacontrol(false);
				btnluu.setEnabled(true);
				btncapnhat.setEnabled(true);
				btncapnhat.setText("Hủy");
				txtmasach.setEditable(false);
				}
				else
				{
					if(btncapnhat.getText().equalsIgnoreCase("Hủy"))
					{
						mokhoacontrol(true);
						mokhoatextfield(false);
						btncapnhat.setText("Sửa");
						btnluu.setEnabled(false);
						naplopbangdiavaotextfield();
						
					}
				}
				
			}
			else
				if(obj.equals(btnluu))
				{
					if(btnthem.getText().equalsIgnoreCase("Hủy"))
					{
						try {
							if(dssach.create(txtmasach.getText(), txttensach.getText(),(String) combtheloai.getSelectedItem().toString(), txthansx.getText(),Double.parseDouble(txtgiathue.getText()),txtghichu.getText()))
							{
								Object [] rowdata= {txtmasach.getText(),txttensach.getText(),(String)combtheloai.getSelectedItem().toString(),txthansx.getText(),Double.parseDouble(txtgiathue.getText()),txtghichu.getText()};
								tablemodel.addRow(rowdata);
								mokhoatextfield(false);
								mokhoacontrol(true);
								btnluu.setEnabled(false);
								btnthem.setText("Thêm");
								xoatrangactions();
							}
							
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(this,"ban nhap du lieu chua dung !xin nhap lai");
							return ;
						}
						
					}
						else 
							if(btncapnhat.getText().equalsIgnoreCase("Hủy"))
							{
								int row=table.getSelectedRow();
								if(row>=0)
									{
									try {
										
										if(dssach.update(txtmasach.getText(), txttensach.getText(),(String)combtheloai.getSelectedItem().toString(),txthansx.getText(),Double.parseDouble(txtgiathue.getText()),txtghichu.getText()))
										{
											//table.setValueAt(txtmacd.getText(), row, 1);
											table.setValueAt(txttensach.getText(), row, 1);
											table.setValueAt((String)combtheloai.getSelectedItem().toString(),row,2);
											table.setValueAt(txthansx.getText(), row, 3);
											table.setValueAt(Double.parseDouble(txtgiathue.getText()), row, 4);
											table.setValueAt(txtghichu.getText(), row, 5);
											mokhoatextfield(false);
											
											mokhoacontrol(true);
											btnluu.setEnabled(false);
											btncapnhat.setText("Sửa");
											xoatrangactions();
											
											
										}
									} catch (Exception e2) {
										// TODO: handle exception
										JOptionPane.showMessageDialog(this,"ban nhap du lieu chua dung ! xin nhap lai");
									}
										
										
									}
								
							}
							
				}
				else
					if(obj.equals(btnxoa))
					{
						int row=table.getSelectedRow();
						if(row>=0)
							{
								String macd=(String) table.getValueAt(row, 0);
								int hoinhac=JOptionPane.showConfirmDialog(this,"Bạn Có Chắc chắn xóa không","chú ý",JOptionPane.YES_NO_OPTION);
								if(hoinhac==JOptionPane.YES_OPTION)
									if(dssach.delete(macd))
									{
										tablemodel.removeRow(row);
										xoatrangactions();
										
									}
							}
								
					}
			
		}
		if(obj.equals(btnthoat))
		{
			AppThueSach2 app=new AppThueSach2();
			app.main(null);
			setVisible(false);
		}
		if(obj.equals(btntim))
		{
			timbangsach app=new timbangsach();
			app.main(null);
			setVisible(false);
		}
		
	
		
	}
	

	
	public void exportExcel(JTable table) {
		 JFileChooser chooser = new JFileChooser();
		 
		 int i = chooser.showSaveDialog(chooser);
		 if (i == JFileChooser.APPROVE_OPTION) {
			 File file = chooser.getSelectedFile();
			 try {
				 	FileWriter out = new FileWriter(file + ".xls");
				 	BufferedWriter bwrite = new BufferedWriter(out);
				 	DefaultTableModel model = (DefaultTableModel) table.getModel();
				 	// ten Cot
				 	
				 	for (int j = 0; j < table.getColumnCount(); j++) {
				 		bwrite.write(model.getColumnName(j) + "\t");
				 		
				 	}
				 	bwrite.write("\n");
				 	// Lay du lieu dong
				 	
				 	for (int j = 0; j < table.getRowCount(); j++) {
				 		for (int k = 0; k < table.getColumnCount(); k++) {
				 			bwrite.write(model.getValueAt(j, k) + "\t");
				 		}
				 		bwrite.write("\n");
				 	}
				 	bwrite.close();
				 	
				 	JOptionPane.showMessageDialog(null, "Lưu file thành công!");
			 } catch (Exception e2) {
				 JOptionPane.showMessageDialog(null, "lưu file thất bại");
			 }
		 	
		 }
		
	}

	

	public void xoatrangactions()
	{
		txtmasach.setText("");
		txttensach.setText("");
		txthansx.setText("");
		txtgiathue.setText("");
		txtghichu.setText("");
				txtmasach.requestFocus();
		//txtmacd.setEditable(true);
	}
	public void thongke()
	{
		exportExcel(table);
	}
	



}
