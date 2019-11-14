package khachhangmuon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import GiaoDien.AppThueSach2;
import database.database;




public class AppkhachhangM extends JFrame implements ActionListener, MouseListener{
	
	String []s = {"Mới", "Cũ"};
	
	
	JTextField txtSophieu, txtManv, txtMabangsach, txtTenbangsach, txtTheloai, txtSoluong, txtSongaymuon, txtDongia, txtTim,txtkhhm;
	JComboBox cboTinhtrang;
	JDateChooser txtngaythue;
	
	
	JButton btnThem, btnSua, btnLuu, btnXoa, btnThoat, btnTim,btnxoatrang;
	 danhsachkhachhangmuon dskhm=new danhsachkhachhangmuon();
	 
	

	 private ArrayList<khachhangmuon> list;
	JTable table;
	 private DefaultTableModel tableModel;
	public AppkhachhangM() {
		setTitle("Khách hàng mượn");
		setBounds(180, 40,1000,650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblTieude;
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		
		pnNorth.add(lblTieude = new JLabel("THÔNG TIN KHÁCH HÀNG MƯỢN"));
		lblTieude.setFont(new Font("Arial", Font.BOLD, 30));
		lblTieude.setForeground(Color.GRAY);
		
		
		JLabel lblSophieu, lblNgaythue, lblManv, lblMabangsach, lblTenbangsach, lblTheloai, lblTinhtrang, lblSoluong, lblSongaymuon, lblDongia, lblTim,lblkhm;
		JPanel pnWest = new JPanel();
		add(pnWest, BorderLayout.WEST);
		pnWest.setLayout(null);
		pnWest.setPreferredSize(new Dimension(340, 0));
		pnWest.setBorder(BorderFactory.createTitledBorder("Thông Tin chi tiết"));
		pnWest.add(lblkhm=new JLabel("Mã khách HM:",JLabel.RIGHT));           pnWest.add(txtkhhm=new JTextField());
		pnWest.add(lblSophieu = new JLabel("Số phiếu:",JLabel.RIGHT));				pnWest.add(txtSophieu = new JTextField());
		pnWest.add(lblNgaythue= new JLabel("Ngày thuê:",JLabel.RIGHT));			pnWest.add(txtngaythue=new JDateChooser());
		pnWest.add(lblManv = new JLabel("Mã nhân viên:",JLabel.RIGHT));				pnWest.add(txtManv = new JTextField());
		pnWest.add(lblMabangsach = new JLabel("Mã băng sách:",JLabel.RIGHT));		pnWest.add(txtMabangsach= new JTextField());
		pnWest.add(lblTenbangsach = new JLabel("Tên băng sách:",JLabel.RIGHT));		pnWest.add(txtTenbangsach = new JTextField());
		pnWest.add(lblTheloai = new JLabel("Thể lọai:",JLabel.RIGHT));				pnWest.add(txtTheloai = new JTextField());
		pnWest.add(lblTinhtrang = new JLabel("Tình trạng thẻ:",JLabel.RIGHT));	pnWest.add(cboTinhtrang = new JComboBox(s));
		pnWest.add(lblSoluong = new JLabel("Số lượng:",JLabel.RIGHT));				pnWest.add(txtSoluong = new JTextField());
		pnWest.add(lblSongaymuon = new JLabel("Số ngày mượn:",JLabel.RIGHT));		pnWest.add(txtSongaymuon = new JTextField());
		pnWest.add(lblDongia = new JLabel("Đơn giá:",JLabel.RIGHT));				pnWest.add(txtDongia = new JTextField());
		
		lblkhm.setToolTipText("Mã khách hàng mượn");
		txtngaythue.setDateFormatString("dd-MM-yyyy");

		lblkhm.setBounds(10, 40, 100, 25);                           txtkhhm.setBounds(130, 40,170,20);
		lblSophieu.setBounds(10, 80, 100, 25);						txtSophieu.setBounds(130, 80, 170, 20);
		lblNgaythue.setBounds(0, 120, 100, 25);						txtngaythue.setBounds(130, 120, 170, 20);
		lblManv.setBounds(10, 160, 100, 25);							txtManv.setBounds(130, 160, 170, 20);
		
		lblMabangsach.setBounds(10, 200, 100, 25);						txtMabangsach.setBounds(130, 200, 170, 20);
		lblTenbangsach.setBounds(10, 240, 100, 25);					txtTenbangsach.setBounds(130, 240, 170, 20);
		lblTheloai.setBounds(10, 280, 100, 25);						txtTheloai.setBounds(130, 280, 170, 20);
		lblTinhtrang.setBounds(10, 320, 100, 25);					cboTinhtrang.setBounds(130, 320, 80, 20);
		lblSoluong.setBounds(10, 360, 100, 25);						txtSoluong.setBounds(130, 360, 170, 20);
		lblSongaymuon.setBounds(0, 400, 100, 25);					txtSongaymuon.setBounds(130, 400, 170, 20);
		lblDongia.setBounds(10, 440, 100, 25);						txtDongia.setBounds(130, 440, 170, 20);
		
		


		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		
		JScrollPane scroll;
		String [] headers = "Mã khách hàng mượn;Số Phiếu; Ngày Thuê; Mã nhân viên; Mã bảng sách;Tên bảng sách;Thể Loại;Tình trạng thẻ; Số Lượng;Số ngày Mượn;Đơn giá".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		scroll.setPreferredSize(new Dimension(200, 0));
		
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách"));
		table.setRowHeight(20);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN); //tu chinh kich thuoc cot so voi noi dung.
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		

		
		JPanel pnSouth = new JPanel();
		add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setLayout(null);
		
		pnSouth.setPreferredSize(new Dimension(0, 80));
		pnSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác Vụ"));
		int x=20,y=20,width=120,height=40;
		
		pnSouth.add(btnThem=new JButton("Thêm",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\them.PNG")));
		btnThem.setBounds(x, y, width, height);
		x+=130;
		pnSouth.add(btnLuu=new JButton("Lưu",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\luu.PNG")));
		btnLuu.setBounds(x, y, width, height);
		x+=130;
		pnSouth.add(btnSua=new JButton("Sửa",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\capnhat.PNG")));
		btnSua.setBounds(x, y, width, height);
		x+=130;
		pnSouth.add(btnXoa=new JButton("xóa",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\xoa.PNG")));
		btnXoa.setBounds(x, y, width, height);
		x+=130;
		pnSouth.add(btnTim=new JButton("Tìm",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\tim.PNG")));
		btnTim.setBounds(x, y, width, height);
		x+=130;
		
		pnSouth.add(btnThoat=new JButton("Thoát",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\thoat.PNG")));
		btnThoat.setBounds(x, y, width, height);
		
		

		btnThoat.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTim.addActionListener(this);
		table.addMouseListener(this);

		database.getinstance().connect();
		updatetabledata();
		btnLuu.setEnabled(false);
		mokhoatextfield(false);
		
		
	}
	
	private void updatetabledata() {
		// TODO Auto-generated method stub
		danhsachkhachhangmuon ds=new danhsachkhachhangmuon();
		List<khachhangmuon> list=ds.doctubangkhachhangmuon();
		for(khachhangmuon kh:list)
		{
			
			Object [] rowdata= {kh.getMakhhm(),kh.getSophieu(),kh.getNgaythue(),kh.getManv(),kh.getMabangsach(),kh.getTenbangsach(),kh.getTheloai(),kh.getTinhtrang(),kh.getSoluong(),kh.getSongaymuon(),kh.getDongia()};
			tableModel.addRow(rowdata);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppkhachhangM akhm = new AppkhachhangM();
		akhm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem))
		{
			if(btnThem.getText().equals("Thêm"))
			{
				mokhoatextfield(true);
				mokhoacontrol(false);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(true);
				Xoatrangactions();
				btnThem.setText("Hủy");
			}
			else
			{
				if(btnThem.getText().equalsIgnoreCase("Hủy"))
				{
					mokhoatextfield(false);
					mokhoacontrol(true);
					btnLuu.setEnabled(false);
					btnThem.setText("Thêm");
					Xoatrangactions();
					txtkhhm.setEditable(false);
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
					naplophockhachhangmuonvaotextfield();
					mokhoacontrol(false);
					btnLuu.setEnabled(true);
					btnSua.setEnabled(true);
					btnSua.setText("Hủy");
					txtkhhm.setEditable(false);
					
					
				}
				else
				{
					if(btnSua.getText().equalsIgnoreCase("Hủy"))
					{
						mokhoacontrol(true);
						mokhoatextfield(false);
						btnSua.setText("Sửa");
						btnLuu.setEnabled(false);
						naplophockhachhangmuonvaotextfield();
						
						Xoatrangactions();
					}
				}
			}
			else if(o.equals(btnLuu))
			{
				if(btnThem.getText().equalsIgnoreCase("Hủy"))
				{
					try {
						if(dskhm.create(txtkhhm.getText(),txtSophieu.getText(),txtngaythue.getDate(),
						txtManv.getText(),txtMabangsach.getText(),txtTenbangsach.getText(),txtTheloai.getText(),
						cboTinhtrang.getSelectedItem().toString(),Integer.parseInt(txtSoluong.getText()),Integer.parseInt(txtSongaymuon.getText()),
						Float.parseFloat(txtDongia.getText()))&&dskhm.createkhtr(txtkhhm.getText(),txtManv.getText(),txtTenbangsach.getText(),txtngaythue.getDate(),txtSophieu.getText()))
						{
							Object [] rowdata= {txtkhhm.getText(),txtSophieu.getText(),((JTextField)txtngaythue.getDateEditor().getUiComponent()).getText(),txtManv.getText(),txtMabangsach.getText(),txtTenbangsach.getText(),txtTheloai.getText(),(String)cboTinhtrang.getSelectedItem().toString(),Integer.parseInt(txtSoluong.getText()),Integer.parseInt(txtSongaymuon.getText()),Float.parseFloat(txtDongia.getText())};
							tableModel.addRow(rowdata);
							mokhoatextfield(false);
							mokhoacontrol(true);
							btnLuu.setEnabled(false);
							btnThem.setText("Thêm");
							Xoatrangactions();
							
						}
						
						
						
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return ;
					}
				}
				else if(btnSua.getText().equalsIgnoreCase("Hủy"))
				{
					int row=table.getSelectedRow();
					if(row>=0)
					{
						try {
							
							if(dskhm.update(txtkhhm.getText(),txtSophieu.getText(),txtngaythue.getDate(),
									txtManv.getText(),txtMabangsach.getText(),txtTenbangsach.getText(),txtTheloai.getText(),
									cboTinhtrang.getSelectedItem().toString(),Integer.parseInt(txtSoluong.getText()),Integer.parseInt(txtSongaymuon.getText()),
									Float.parseFloat(txtDongia.getText())))
							{
								//table.setValueAt(txtkhhm.getText(), row,1);
								table.setValueAt(txtSophieu.getText(), row, 1);
								table.setValueAt( ((JTextField)txtngaythue.getDateEditor().getUiComponent()).getText(), row,2);
								table.setValueAt(txtManv.getText(), row, 3);
								table.setValueAt(txtMabangsach.getText(), row,4);
								table.setValueAt(txtTenbangsach.getText(), row, 5);
								table.setValueAt(txtTheloai.getText(), row, 6);
								table.setValueAt(cboTinhtrang.getSelectedItem().toString(),row,7);
								table.setValueAt(Integer.parseInt(txtSoluong.getText()), row, 8);
								table.setValueAt(Integer.parseInt(txtSongaymuon.getText()), row,9);
								table.setValueAt(Float.parseFloat(txtDongia.getText()), row, 10);
								
							mokhoatextfield(false);
							mokhoacontrol(true);
							btnLuu.setEnabled(false);
							btnSua.setText("Sửa");
							Xoatrangactions();
							
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			else if(o.equals(btnXoa))
			{
				int row=table.getSelectedRow();
				if(row>=0)
				{
					String makh=(String) table.getValueAt(row, 0);
					int hoinhac=JOptionPane.showConfirmDialog(this,"Bạn Có Chắc chắn xóa không","chú ý",JOptionPane.YES_NO_OPTION);
					if(hoinhac==JOptionPane.YES_OPTION)
						if(dskhm.delete(makh))
						{
							tableModel.removeRow(row);
							Xoatrangactions();
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
		if(o.equals(btnTim))
		{
			timkhachhangmuon app=new timkhachhangmuon();
			app.main(null);
			setVisible(false);
		}
	}

	private void Xoatrangactions() {
		txtkhhm.setText("");
		txtSophieu.setText("");
		txtngaythue.setToolTipText("");
		txtManv.setText("");
		txtMabangsach.setText("");
		txtTenbangsach.setText("");
		txtTheloai.setText("");
		txtSoluong.setText("");
		txtSongaymuon.setText("");
		txtDongia.setText("");
		txtkhhm.requestFocus();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row=table.getSelectedRow();
		
		txtkhhm.setText(table.getValueAt(row, 0).toString());
		txtSophieu.setText(table.getValueAt(row, 1).toString());
//		txtngaythue.setDateFormatString( (String)table.getValueAt(row, 2).toString());
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row, 2).toString());
			txtngaythue.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtManv.setText(table.getValueAt(row, 3).toString());
		txtMabangsach.setText(table.getValueAt(row, 4).toString());
		txtTenbangsach.setText(table.getValueAt(row, 5).toString());
		txtTheloai.setText(table.getValueAt(row, 6).toString());
		cboTinhtrang.setSelectedItem(table.getValueAt(row, 7).toString());
		txtSoluong.setText(table.getValueAt(row, 8).toString());
		txtSongaymuon.setText(table.getValueAt(row, 9).toString());
		txtDongia.setText(table.getValueAt(row, 10).toString());
		
		
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
	private void naplophockhachhangmuonvaotextfield()
	{
		int row=table.getSelectedRow();
		try {
			
			txtkhhm.setText(table.getValueAt(row, 0).toString());
			txtSophieu.setText(table.getValueAt(row, 1).toString());
//			txtngaythue.setDateFormatString((String)table.getValueAt(row, 2).toString());
			
			Date date=new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row, 2).toString());
			txtngaythue.setDate(date);
			
			txtManv.setText(table.getValueAt(row, 3).toString());
			txtMabangsach.setText(table.getValueAt(row, 4).toString());
			txtTenbangsach.setText(table.getValueAt(row, 5).toString());
			txtTheloai.setText(table.getValueAt(row, 6).toString());
			cboTinhtrang.setSelectedItem(table.getValueAt(row, 7).toString());
			txtSoluong.setText(table.getValueAt(row, 8).toString());
			txtSongaymuon.setText(table.getValueAt(row, 9).toString());
			txtDongia.setText(table.getValueAt(row, 10).toString());
		
		} catch (Exception e) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(this,"bạn cần chọn dòng cần sửa !");
			return ;
		}
			
			
		
		
	}

	private void mokhoacontrol(boolean b)
	{
		btnThem.setEnabled(b);
		btnSua.setEnabled(b);
		btnXoa.setEnabled(b);
		btnThoat.setEnabled(b);
		btnLuu.setEnabled(b);
		btnTim.setEnabled(b);
	}
	private void mokhoatextfield(boolean b)
	{
		txtkhhm.setEditable(b);
		txtSophieu.setEditable(b);
		txtngaythue.setEnabled(b);
		txtManv.setEditable(b);
		txtMabangsach.setEditable(b);
		txtTenbangsach.setEditable(b);
		txtTheloai.setEditable(b);
		cboTinhtrang.setEnabled(b);
		txtSoluong.setEditable(b);
		txtSongaymuon.setEditable(b);
		txtDongia.setEditable(b);
		
		
	}

}
