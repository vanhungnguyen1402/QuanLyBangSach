package Lietke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AppLietKe extends JFrame implements ActionListener, ItemListener{
	JCheckBox checkMa;
	JCheckBox checkTen;
	JCheckBox checkTheloai;
	
	JButton btnLietke;
	JButton btnThoat;
	
	JTable table;
	DefaultTableModel tableModel;
	public AppLietKe() {
		setTitle("App Liệt kê");
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		
		JScrollPane scroll;
		String [] headers = "Mã Sách; Tên Sách; Thể loại; Hãng xuất bản; Giá thuê; Ghi chú".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.NORTH);
		scroll.setPreferredSize(new Dimension(200, 210));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách sách"));
		table.setRowHeight(20);
		
		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		pnCenter.setPreferredSize(new Dimension(0, 200));
		pnCenter.setBorder(BorderFactory.createTitledBorder(""));
		pnCenter.setBackground(Color.GRAY);
		pnCenter.setLayout(null);
		
		pnCenter.add(checkMa = new JCheckBox("Liệt kê theo mã"));
		checkMa.setBounds(0, 0, 180, 20);
		
		pnCenter.add(checkTen = new JCheckBox("Liệt kê theo tên"));
		checkTen.setBounds(200, 0, 180, 20);
		
		pnCenter.add(checkTheloai = new JCheckBox("Liệt kê theo thể loại"));
		checkTheloai.setBounds(400, 0, 180, 20);
		
		pnCenter.add(btnLietke = new JButton("Liệt kê"));
		pnCenter.add(btnThoat = new JButton("Thoát"));
		
		btnLietke.setBounds(180, 40, 80, 30);
		btnThoat.setBounds(300, 40, 80, 30);
		
	
		checkMa.addItemListener(this);
		checkTen.addItemListener(this);
		checkTheloai.addItemListener(this);
		btnLietke.addActionListener(this);
		btnThoat.addActionListener(this);	
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnLietke))
			LietkeActions();
		if(o.equals(btnThoat))
			ThoatActions();
		
		
	}
	private void ThoatActions() {
		// TODO Auto-generated method stub
		setVisible(false);
	}
	private void LietkeActions() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppLietKe alk = new AppLietKe();
		alk.setVisible(true);
	}
	

}
