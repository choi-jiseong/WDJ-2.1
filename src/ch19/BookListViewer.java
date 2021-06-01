package ch19;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

public class BookListViewer extends JFrame implements ActionListener {
	private JTextField idField, titleField, publisherField, yearField, priceField;
	private JButton previousBtn, nextBtn, insertBtn, finishBtn;
	private ResultSet rs;
	private Connection con;
	
	public BookListViewer() throws Exception {
		
		/*
		 * DB���� å ���ڵ���� ��������.
		 * 1. JDBC ����̹� ����
		 * 2. DB ����
		 * 3. PreparedStatement ��ü ����
		 * 4. SQL�� ����
		 */
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2", "root", "cjseong98");
		String sql = "select * from books order by book_id desc";
		PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		// select ���� ������ ���� executeQuery() �޼��带 ����ϰ� �� ��, insert, delete, update ���� ������ ����
		// executeUpdate() �޼��带 ����Ѵ�.
		
		rs  = pstmt.executeQuery();
		
		
		//�� JFrame ��ü(this)�� Layout�� GridLayout���� ���� (0, 2)
		this.setLayout(new GridLayout(0, 2));
		//������Ʈ���� ����
		this.add(new JLabel("ID", JLabel.CENTER));
		idField = new JTextField(10);
		this.add(idField);
		
		this.add(new JLabel("TITLE", JLabel.CENTER));
		titleField = new JTextField(10);
		this.add(titleField);
		
		this.add(new JLabel("Publisher", JLabel.CENTER));
		publisherField = new JTextField(10);
		this.add(publisherField);
		
		this.add(new JLabel("Year", JLabel.CENTER));
		yearField = new JTextField(10);
		this.add(yearField);
		
		this.add(new JLabel("Price", JLabel.CENTER));
		priceField = new JTextField(10);
		this.add(priceField);
		
		previousBtn = new JButton("Previoues");
		previousBtn.addActionListener(this);
		this.add(previousBtn);
		
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		this.add(nextBtn);
		
		insertBtn = new JButton("����");
		insertBtn.addActionListener(this);
		this.add(insertBtn);
		
		finishBtn = new JButton("����");
		finishBtn.addActionListener(this);
		this.add(finishBtn);
		
		//������ ������Ʈ���� JFrame ��ü(this)�� �߰��Ѵ�.
		
		//��ư ������Ʈ���� �׼Ǹ����ʸ� �� ��ü(this)�� �����Ѵ�.
		this.setSize(350, 200);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getSource() == previousBtn) {
			// ��������� Ŀ���� �������� �̵��ϰ� �� Ŀ���� ����Ű�� ��� ���ڵ��� Į������ �̾� �ͼ� ������ JTextField������ ����.
			rs.previous();
			setCurrentBookInfo2TextField();
		}else if(e.getSource() == nextBtn) {
			// ��������� Ŀ���� �������� �̵��ϰ� �� Ŀ���� ����Ű�� ��� ���ڵ��� Į������ �̾� �ͼ� ������ JTextField������ ����.
			rs.next();
			setCurrentBookInfo2TextField();
		}else if(e.getSource() == insertBtn) {
			
		}else if(e.getSource() == finishBtn) {
			System.out.println("���α׷��� �����մϴ�..");
			con.close();
			System.exit(0);  //���μ��� �����Ų��.
		}
		}catch(Exception err) {
			System.out.println(err.getMessage());
		}
	}
	
	private void setCurrentBookInfo2TextField() throws Exception {
		// book_id, title, publisher, year, price
		int bookId = rs.getInt("book_id");
		String title = rs.getString("title");
		String publisher = rs.getString("publisher");
		Date year = rs.getDate("year");
		int price = rs.getInt("price");
		
		idField.setText(String.valueOf(bookId));
		titleField.setText(title);
		publisherField.setText(publisher);
		yearField.setText(year.toString());
		priceField.setText(String.valueOf(price));
	}
	public static void main(String[] args) {
		// BookListViewer Ŭ������ �ν��Ͻ� ����
		try {
			new BookListViewer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
