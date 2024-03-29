package khachhangtra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import GiaoDien.AppThueSach2;
import database.database;
import khachhangmuon.AppkhachhangM;
import khachhangmuon.danhsachkhachhangmuon;
import khachhangmuon.khachhangmuon;

public class khachhangtra extends JFrame implements ActionListener, MouseListener{
	
	JCheckBox ckTra;
	JComboBox cboTensach;
	JDateChooser jdcNgaytra;
	JTextField txtTim, txtTinhtrang, txtGhichu,txtmakhhm;
	JButton btnTim, btnSua, btnThoat, btnThem,btnxoa,btnluu;
	
	JTable table;
	DefaultTableModel tableModel;
	private ArrayList<khachhantr> list;
	danhsachkhachhangtr dskhtr=new danhsachkhachhangtr();
	
	public khachhangtra() {
		setTitle("Khách hàng mượn");
		setBounds(180, 40,1000,650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		JLabel lblTieude;
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		
		pnNorth.add(lblTieude = new JLabel("THÔNG TIN KHÁCH HÀNG TRẢ"));
		lblTieude.setFont(new Font("Arial", Font.BOLD, 30));
		lblTieude.setForeground(Color.GRAY);
		
		
		JLabel lblngaytra, lbltinhtrang, lblghichu, lblmakhhm;
		JPanel pnWest = new JPanel();
		add(pnWest, BorderLayout.WEST);
		pnWest.setLayout(null);
		pnWest.setPreferredSize(new Dimension(430, 0));
		pnWest.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));
		
		pnWest.add(lblngaytra = new JLabel("Ngày trả:"));			pnWest.add(jdcNgaytra = new JDateChooser());
		pnWest.add(lbltinhtrang = new JLabel("Tình trạng trả:"));		pnWest.add(txtTinhtrang = new JTextField());
		pnWest.add(lblghichu = new JLabel("Ghi chú:"));			pnWest.add(txtGhichu = new JTextField());
		pnWest.add(lblmakhhm = new JLabel("Mã kh Mượn:"));	pnWest.add(txtmakhhm=new JTextField());
		//pnWest.add(lbltenbangdia = new JLabel("Tên băng đĩa:"));	
		
		pnWest.add(ckTra = new JCheckBox("Trả"));
		
		lblmakhhm.setBounds(30, -20, 100, 180);				txtmakhhm.setBounds(125, 60, 180, 20);
		lblngaytra.setBounds(30, 110, 100, 20);					jdcNgaytra.setBounds(125, 110, 180, 20);
		//ckTra.setBounds(355, 110, 80, 20);
		lbltinhtrang.setBounds(30, 160, 100, 20);				txtTinhtrang.setBounds(125, 160, 180, 20);
		lblghichu.setBounds(30, 210, 100, 20);					txtGhichu.setBounds(125, 210, 280, 80);
		
		jdcNgaytra.setDateFormatString("dd-MM-yyyy");
		
	
		
		
		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		
		JScrollPane scroll;
		String [] headers = "Mã Kh mượn;Mã nhân viên; Tên sách; Ngày thuê; Số phiếu; Ngày trả; Tình trạng; Ghi chú".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		scroll.setPreferredSize(new Dimension(200, 0));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách"));
		table.setRowHeight(20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN); //tu chinh kich thuoc cot so voi noi dung.
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JLabel lblTim;
		JPanel pnSouth = new JPanel();
		add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setLayout(null);
		
		pnSouth.setPreferredSize(new Dimension(0, 130));
		pnSouth.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
		
		int x=10,y=50,width=100,height=40;
//		pnSouth.add(btnThem=new JButton("Thêm",new ImageIcon("them.png")));
//		btnThem.setBounds(x, y, width, height);
		x+=110;
		pnSouth.add(btnluu=new JButton("Lưu",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\luu.PNG")));
		btnluu.setBounds(x, y, width, height);
		x+=110;
		pnSouth.add(btnSua=new JButton("Sửa",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\capnhat.PNG")));
		btnSua.setBounds(x, y, width, height);
		x+=110;
		
		pnSouth.add(btnxoa=new JButton("Xóa",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\xoa.PNG")));
		btnxoa.setBounds(x, y, width, height);
		x+=110;
		
		pnSouth.add(btnThoat=new JButton("Thoát",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\thoat.PNG")));
		btnThoat.setBounds(x, y, width, height);
		x+=110;
		
		pnSouth.add(btnTim=new JButton("Tìm",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\tim.PNG")));
		btnTim.setBounds(x, y, width, height);
		
		
		
		
		
	
		
		
			btnThoat.addActionListener(this);
			btnSua.addActionListener(this);
			btnxoa.addActionListener(this);
			btnluu.addActionListener(this);
			btnTim.addActionListener(this);
			table.addMouseListener(this);
			
			database.getinstance().connect();
			updatetabledata();
			btnluu.setEnabled(false);
			moikhoatextfield(false);
			
			
		}
	
	private void updatetabledata() {
		danhsachkhachhangtr ds=new danhsachkhachhangtr();
		List<khachhantr> list=ds.doctubangkhachhangtr();
		for(khachhantr kh:list)
		{
			
			Object [] rowdata= {kh.getMakhhm(),kh.getManv(),kh.getTensach(),kh.getNgaythue(),kh.getSophieu(),kh.getNgaytr(),( kh).getTinhtrang(),kh.getGhichu()};
			tableModel.addRow(rowdata);
		}
		
		
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		khachhangtra akhm = new khachhangtra();
		akhm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnSua))
		{
			if(btnSua.getText().equalsIgnoreCase("Sửa"))
			{
				moikhoatextfield(true);
				naolopkhachhangtrvaotextfield();
				moikhoacontrol(false);
				btnluu.setEnabled(true);
				btnSua.setEnabled(true);
				btnSua.setText("Hủy");
				txtmakhhm.setEditable(false);
				
			}
			else
			{
				if(btnSua.getText().equalsIgnoreCase("Hủy"))
				{
					moikhoacontrol(true);
					moikhoatextfield(false);
					btnSua.setText("Sửa");
					btnluu.setEnabled(false);
					naolopkhachhangtrvaotextfield();
					xoatrangactrtion();
					
				}
			}
		}
		else if(o.equals(btnluu))
		{
			if(btnSua.getText().equalsIgnoreCase("Hủy"))
			{
				int row=table.getSelectedRow();
				if(row>=0)
				{
					try {
						
						
						if(dskhtr.update(txtmakhhm.getText(),jdcNgaytra.getDate(),txtTinhtrang.getText(),txtGhichu.getText()))         
						{
//							
							table.setValueAt( ((JTextField)jdcNgaytra.getDateEditor().getUiComponent()).getText(), row,5);
							table.setValueAt(txtTinhtrang.getText(),row,6);
							table.setValueAt(txtGhichu.getText(), row,7);
							
							
							moikhoatextfield(false);
							moikhoacontrol(true);
							btnluu.setEnabled(false);
							btnSua.setText("Sửa");
							xoatrangactrtion();
						}
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
//					moikhoatextfield(false);
//					moikhoacontrol(true);
//					btnluu.setEnabled(false);
//					btnSua.setText("Sửa");
					
				}
			}
		
		}
		else if(o.equals(btnxoa))
		{
			int row=table.getSelectedRow();
			if(row>=0)
			{
				String makhm=(String) table.getValueAt(row, 0);
				int hoinhac=JOptionPane.showConfirmDialog(this,"Bạn Có Chắc chắn xóa không","chú ý",JOptionPane.YES_NO_OPTION);
				if(hoinhac==JOptionPane.YES_OPTION)
					if(dskhtr.delete(makhm))
					{
						tableModel.removeRow(row);
						xoatrangactrtion();
					}
			}
		}
		if(o.equals(btnThoat)) {
			AppThueSach2 atcd2 = new AppThueSach2();
			atcd2.main(null);
			setVisible(false);
		}
		if(o.equals(btnTim))
		{
			timkhachhangtra app=new timkhachhangtra();
			app.main(null);
			setVisible(false);
		}
		
	}

	private void naolopkhachhangtrvaotextfield() {
		// TODO Auto-generated method stub
		
		int row=table.getSelectedRow();
		try {
			txtmakhhm.setText(table.getValueAt(row, 0).toString());
			java.util.Date date=new SimpleDateFormat("yyyy-MM-dd").parse((String) table.getValueAt(row, 5).toString());
			jdcNgaytra.setDate(date);
			
			txtTinhtrang.setText(table.getValueAt(row, 6).toString());
			if(txtTinhtrang.getText().equalsIgnoreCase(""))
				txtTinhtrang.setText("");
			
			txtGhichu.setText(table.getValueAt(row, 7).toString());
			if(txtGhichu.getText().equalsIgnoreCase(""))
				txtGhichu.setText("");
			
		} catch (Exception e) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(this,"bạn cần chọn dòng cần sửa !");
			return ;
		}
	}

	private void xoatrangactrtion() {
		// TODO Auto-generated method stub
		txtmakhhm.setText("");
		txtTinhtrang.setText("");
		txtGhichu.setText("");
		jdcNgaytra.setToolTipText("");
		ckTra.setToolTipText("");
		
	}

	private void  moikhoacontrol(boolean b) {
		// TODO Auto-generated method stub
		btnSua.setEnabled(b);
		btnluu.setEnabled(b);
		btnxoa.setEnabled(b);
		btnThoat.setEnabled(b);
		btnTim.setEnabled(b);
		
	}

	private void moikhoatextfield(boolean b) {
		// TODO Auto-generated method stub
		txtmakhhm.setEditable(b);
		txtGhichu.setEditable(b);
		txtTinhtrang.setEditable(b);
		jdcNgaytra.setEnabled(b);
		ckTra.setEnabled(b);
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		try {
			txtmakhhm.setText(table.getValueAt(row, 0).toString());
			
			java.util.Date date=new SimpleDateFormat("yyyy-MM-dd").parse((String) table.getValueAt(row, 5).toString());
			jdcNgaytra.setDate(date);
			
			txtTinhtrang.setText(table.getValueAt(row, 6).toString());
			if(txtTinhtrang.getText().equalsIgnoreCase(""))
				txtTinhtrang.setText("");
			
			txtGhichu.setText(table.getValueAt(row, 7).toString());
			if(txtGhichu.getText().equalsIgnoreCase(""))
				txtGhichu.setText("");
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		
		
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

}

