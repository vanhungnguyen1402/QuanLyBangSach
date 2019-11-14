package khachhangmuon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.database;

public class themkhachhangmuon extends JFrame implements ActionListener {
	private JLabel lblmakhm,lblsophieu,lblngaythue,lblmanv,lblmabangsach,lbltenbangsach,lbltheloai,lbltinhtrang,lblsoluong,lblsongaymuon,lbldongia;
	private JTextField txtmakhm,txtsophieu,txtngaythe,txtmanv,txtmabangsach,txttenbangsach,txttheloai,txtsoluong,txtsongaymuon,txtdongia;
	private JComboBox< String> cobtinhtrang;
	private JButton btnsave,btncanel;
	//DefaultTableModel tablemodel;
	danhsachkhachhangmuon dskhm=new danhsachkhachhangmuon();
	private ArrayList<khachhangmuon> list;
	public themkhachhangmuon()
	{
		setTitle("Thêm khách hàng mượn");
		setBounds(400,100, 600, 500);
		addcontrol();
	}
	private void addcontrol() {
		// TODO Auto-generated method stub
		String [] s= {"cu","moi"};
		JPanel pnnorth=new JPanel();
		pnnorth.setPreferredSize(new Dimension(600, 500));
		
		int x=10,y=5,width=100,height=30;
		pnnorth.add(lblmakhm=new JLabel("Ma khach hang:",JLabel.RIGHT));
		lblmakhm.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lblsophieu=new JLabel("So phieu:",JLabel.RIGHT));
		lblsophieu.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lblngaythue=new JLabel("Ngay thue:",JLabel.RIGHT));
		lblngaythue.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lblmanv=new JLabel("Ma nhan vien:",JLabel.RIGHT));
		lblmanv.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lblmabangsach=new JLabel("Ma bang sach:",JLabel.RIGHT));
		lblmabangsach.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lbltenbangsach=new JLabel("Ten bang sach:",JLabel.RIGHT));
		lbltenbangsach.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lbltheloai=new JLabel("The loai:",JLabel.RIGHT));
		lbltheloai.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lbltinhtrang=new JLabel("Tinh Trang",JLabel.RIGHT));
		lbltinhtrang.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lblsoluong=new JLabel("So luong:",JLabel.RIGHT));
		lblsoluong.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lblsongaymuon=new JLabel("So ngay muon:",JLabel.RIGHT));
		lblsongaymuon.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(lbldongia=new JLabel("Don gia:",JLabel.RIGHT));
		lbldongia.setBounds(x, y, width, height);
		x=120;y=10; width=400;height=20;
		pnnorth.add(txtmakhm=new JTextField());
		txtmakhm.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(txtsophieu=new JTextField());
		txtsophieu.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(txtngaythe=new JTextField());
		txtngaythe.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(txtmanv=new JTextField());
		txtmanv.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(txtmabangsach=new JTextField());
		txtmabangsach.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(txttenbangsach=new JTextField());
		txttenbangsach.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(txttheloai=new JTextField());
		txttheloai.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(cobtinhtrang=new JComboBox<>(s));
		cobtinhtrang.setBounds(x, y, 100, height);
		y+=35;
		pnnorth.add(txtsoluong=new JTextField());
		txtsoluong.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(txtsongaymuon=new JTextField());
		txtsongaymuon.setBounds(x, y, width, height);
		y+=35;
		pnnorth.add(txtdongia=new JTextField());
		txtdongia.setBounds(x, y, width, height);
		
		pnnorth.add(btnsave=new JButton("SAVE"));
		btnsave.setBounds(x, y+40, 100, 40);
		pnnorth.add(btncanel=new JButton("CANEL"));
		btncanel.setBounds(350, y+40, 100, 40);
		
		add(pnnorth,BorderLayout.NORTH);
		pnnorth.setLayout(null);
		btnsave.addActionListener(this);
		btncanel.addActionListener(this);
		database.getinstance().connect();
		
		
	}
	public static void main(String[] args) {
		new themkhachhangmuon().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnsave))
		{

			try {
				dskhm.create(txtmakhm.getText(),txtsophieu.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(txtngaythe.getText()),
				txtmanv.getText(),txtmabangsach.getText(),txttenbangsach.getText(),txttheloai.getText(),
				cobtinhtrang.getSelectedItem().toString(),Integer.parseInt(txtsoluong.getText()),Integer.parseInt(txtsongaymuon.getText()),
				Float.parseFloat(txtdongia.getText()));
				Object [] rowdata= {txtmakhm.getText(),txtsophieu.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(txtngaythe.getText()),
						txtmanv.getText(),txtmabangsach.getText(),txttenbangsach.getText(),txttheloai.getText(),
						cobtinhtrang.getSelectedItem().toString(),Integer.parseInt(txtsoluong.getText()),Integer.parseInt(txtsongaymuon.getText()),
						Float.parseFloat(txtdongia.getText())};
				
			rowdata();
				
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(o.equals(btncanel))
		{
			AppkhachhangM appa=new AppkhachhangM();
			appa.main(null);
			setVisible(false);
		}
			
		
			
	}
	private Object[] rowdata() {
		// TODO Auto-generated method stub
		try {
			Object [] rowdata= {txtmakhm.getText(),txtsophieu.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(txtngaythe.getText()),
					txtmanv.getText(),txtmabangsach.getText(),txttenbangsach.getText(),txttheloai.getText(),
					cobtinhtrang.getSelectedItem().toString(),Integer.parseInt(txtsoluong.getText()),Integer.parseInt(txtsongaymuon.getText()),
					Float.parseFloat(txtdongia.getText())};
//			(AppkhachhangM) DefaultTableModel tableModel;
//			tableModel.addRow(rowdata);
			//return rowdata;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowdata();
		
		
	}

}