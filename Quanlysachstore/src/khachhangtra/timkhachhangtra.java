package khachhangtra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import database.database;
import khachhangmuon.danhsachkhachhangmuon;
import khachhangmuon.khachhangmuon;

public class timkhachhangtra extends JFrame implements ActionListener {

	private JButton btnsearch,btnexit;
	private ArrayList<khachhantr> list;
	private JTable table;
	private DefaultTableModel tablemodel;
	danhsachkhachhangtr dskhtr=new danhsachkhachhangtr();
	private JLabel lbltimma;
	private JTextField txttim;
	public timkhachhangtra()
	{
		setTitle("thông tin khách hàng Trả");
		setBounds(300, 200,900,400);
		JPanel pnnourth=new JPanel();
		pnnourth.setPreferredSize(new Dimension(0, 100));
		pnnourth.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.red),"tìm theo mã khách hàng Trả"));
		int x=50,y=40,width=100,height=30;
		pnnourth.add(txttim=new JTextField());
		txttim.setBounds(x, y, 200, height);
		x+=210;
		pnnourth.add(btnsearch=new JButton("Search",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\tim.PNG")));
		btnsearch.setBounds(x, y, 120, height);
		x+=130;
		pnnourth.add(btnexit=new JButton("Exit",new ImageIcon("K:\\qlbangsach\\Quanlysachstore\\thoat.PNG")));
		btnexit.setBounds(x, y, width, height);
		add(pnnourth,BorderLayout.NORTH);
		pnnourth.setLayout(null);
		
		Box b=Box.createVerticalBox();
		Box b1;
//		JPanel pnsouth=new JPanel();
		b.setPreferredSize(new Dimension(0,320));
		b.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.RED),"Danh sách các Các khách hàng trả"));
		
		
		b.add(b1=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		String [] headers = "Mã Kh mượn;Mã nhân viên; Tên sách; Ngày thuê; Số phiếu; Ngày trả; Tình trạng; Ghi chú".split(";");
		tablemodel =new DefaultTableModel(headers, 0);
		JScrollPane scroll=new JScrollPane();
		scroll.setViewportView(table=new JTable(tablemodel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		b1.add(scroll);
		add(b,BorderLayout.CENTER);
		btnsearch.addActionListener(this);
		btnexit.addActionListener(this);
		
		database.getinstance().connect();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new timkhachhangtra().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnexit))
		{
			khachhangtra app=new khachhangtra();
			app.main(null);
			setVisible(false);
		}
		else
			if(o.equals(btnsearch))
			{
				String khm=txttim.getText();
				danhsachkhachhangtr ds=new danhsachkhachhangtr();
				List<khachhantr> list=ds.doctubangkhachhangtr();
				for(khachhantr kh:list)
				{
					if(kh.getMakhhm().equalsIgnoreCase(khm))
					{
						Object [] rowdata= {kh.getMakhhm(),kh.getManv(),kh.getTensach(),kh.getNgaythue(),kh.getSophieu(),kh.getNgaytr(),( kh).getTinhtrang(),kh.getGhichu()};
						tablemodel.addRow(rowdata);
					}
					
				}
			}
		
	}

}
