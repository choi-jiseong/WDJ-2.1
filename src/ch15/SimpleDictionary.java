package ch15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SimpleDictionary extends JPanel implements ActionListener{
   /*
      �ܾ� �Է� ���� �� �ִ� JTextField
      �˻� ��ư
      �߰� ��ư
      �ܾ��� ������ ���� �ڷᱸ���� Map ��ü
   */
   private JTextField inputField = new JTextField(30);
   private JButton searchBtn = new JButton("�˻�");
   private JButton addBtn = new JButton("�߰�");
   
   // Map ��ü�� �ܾ��� ���� ����Ҳ���.
   // <key, value> ������ ����. key�� �ѱ۴ܾ�, value�� �����Ǵ� ����ܾ�.
   private Map<String, String> words = new HashMap<>();
   private static final String DIC_FILE_NAME = "dict.props";
   private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   private static final String DB_SERVER_URL = "jdbc:mysql://localhost:3306/oop";
   private static final String DB_USER = "root";
   private static final String DB_USER_PW = "cjseong98";
   
   public SimpleDictionary() {
      // Panel�� �⺻ ���̾ƿ��� : FlowLayout
      this.add(inputField);
      this.add(searchBtn);
      this.add(addBtn);
      
      // searchBtn, addBtn�� Ŭ�� �̺�Ʈ�� �߻����� �� ó���� �����ʸ� ��������!
      searchBtn.addActionListener(this);
      addBtn.addActionListener(this);
      
      this.setPreferredSize(new Dimension(600, 50));
   
      // ���Ͽ� key=value ���·� ����� ��Ʈ������ �о, dict�� ��������.
      // DB���� ���ڵ带 �а�, �� ���ڵ带 �̿��� dict ���� ��������.
//      buildDictionaryFromFile();
      buildDictionaryFromDB();
   }
   
   private void buildDictionaryFromDB() {
      /*
         1. Database ����
            a. JDBC Driver�� �ε� Class.forName("com.mysql.jdbc.Driver");
            b. Connection con = DriverManager.getConnection();
              �޼��带 ȣ���� ������ establish
              �� �� ���� ������ getConnection() �޼��忡 ��������� ��.
              ��������: DB Server�� URL
               => (ip �ּ�, port��ȣ)
                db ������� ���̵�� ��ȣ
         2. Connection ��ü�� ���� SQL�� ������ ������ ��û�ϰ� �װ���� �޾Ƽ� ó���Ѵ�.
            ũ�� �� ���� �溡�� �ִ�.
            ù °�� con.createStatement() �޼ҵ� ȣ���� ���ؼ�
            ��ȯ�Ǵ� Statement ��ü�� �̿��ϴ� ��� (���� SQL ��)
               ���� SQL��: ���α׷��� ������ ������ SQL�� �����ǰ� ������ ���.
            �� ��°�� con.preparedStatement() �޼��� ȣ���� ���ؼ�
            ��ȯ�Ǵ� PreparedStatement ��ü�� �̿��ϴ� ��� (���� SQL ��)
               ���� SQL��: ���α׷��� ������ ������ SQL�� �������� �ʰ� ����Ǵ� SQL��
               select * from dict where han = ?
            �� �������� PreparedStatement ��ü�� �̿��Ѵ�.
               String sql = "select * from dict";
               PreparedStatement pstmt = con.preparedStatement(sql);
               ���� �غ� �� PreparedStatement�� �����Ű�� ����� ũ�� 2����
               ù ��°: ������ SQL ���� insert, delete, �Ǵ� update ���� ���
               insert into ...
               delete from dict ...
               update set eng = ... from ...
               
               pstmt.executeUpdate();
               �� ��°: ������ SQL ���� select ���� ���.
               select ...
               
               ResultSet rs = pstmt.executeQuery();
         3. DB Server���� ������ ����(close)�Ѵ�.
            con.close();
      */
      // MySQL JDBC ����̹��� �޸𸮿� ����
      // ����̹� Ŭ���� �̸��� DBMS���� �ٸ���.
      try {
         Class.forName(JDBC_DRIVER);
      } catch (Exception e) {
         System.out.println(e.getMessage());
         return;
      }
      
      // DB ������ ����
      try (Connection con = 
            DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW)) 
      {
         // SELECT �� ����
         String sql = "select * from dict";
         PreparedStatement pstmt = con.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            // ���� �����Ͱ� ����Ű�� Į�� ���� ������ ��.
            // �� Į���� Ÿ�Կ� ����, ȣ���� �޼��尡 �޶�����.
            // ���� �� char, varchar Ÿ���� Į����
            // getString("Į���̸�" �Ǵ� "Į�� ��ġ");
            // int Ÿ���� Į���� getInt(...);
            // DateTime, Date Ÿ���� Į�� ���� getDate();
            // rs.getString("han");
            String han = rs.getString(1);
            // rs.getString("eng");
            String eng = rs.getString(2);
            
            words.put(han, eng);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } 
   }
   
   private void buildDictionaryFromFile() {
      // Properties ������ Map�ε�
      // key, value�� Ÿ���� ���� String, String����
      // ������ ������ Map�̴�.
      Properties props = new Properties();
      
      // ���Ͽ��� �о props ��ü�� <key, value>
      // ���� ������ �� �ִ�.
      try (FileReader fReader = new FileReader(DIC_FILE_NAME)) {
         props.load(fReader);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      
      Set<Object> set = props.keySet();
      for (Object obj : set) {
         words.put((String)obj, (String)props.get(obj));
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String key = inputField.getText();
      if (key.trim().length() == 0) return; // ���鸸 �Էµ� ���� ����.
      
      if (e.getSource() == searchBtn) {
         /*
            �Էµ� �ܾ ����
            �� �ܾ key ������ ������ �����Ǵ� �� ��Ʈ���� �ִ��� �˻� -> dict.get(�ܾ�);
            �� �ܾ� �����Ǵ� ���� ������ JOptionPane.showMessageDialog() �޼��带 
            ȣ���ؼ� �� �����Ǵ� ���� �����ش�.
            ������ (null�̸�) JOptionPane.showMessageDialog() �޼��带 ȣ���ؼ� 
            �ܾ ã�� �� �����ϴ� ��� ������ش�.
            inputField�� �� ���ڿ��� ����.
         */
         String value = words.get(key);
         if (value != null) { // �����Ǵ� �ܾ �ִ� ���
            JOptionPane.showMessageDialog(this, value, key, 
                  JOptionPane.INFORMATION_MESSAGE);
         } else { // �����Ǵ� �ܾ ���� ���
            JOptionPane.showMessageDialog(this, "�ܾ ã�� �� �����ϴ�.", key, 
                  JOptionPane.ERROR_MESSAGE);
         }
      } else if (e.getSource() == addBtn) {
         /*
            �Էµ� �ܾ ����
            String value = JOptionPane.showInputDialog(); 
            �޼��带 ȣ���ؼ� �߰��� ���� �ܾ �Է� �޴´�.
            dict.put(�Է��ʵ忡 �Էµ� �ܾ�, inputDialog�� �Էµ� �ܾ�);
            inputField�� �� ���ڿ��� ����.
         */
         String value = JOptionPane.showInputDialog(this,
               key + "�� �����Ǵ� ����ܾ �Է��ϼ���");
         if (value.trim().length() == 0) return;
         words.put(key, value);
         words.put(value, key);
         // ���Ͽ��� key=value �� ������ ����س���.
         // DB���� <key, value>�� ���� �ϳ��� ���ڵ�� ��������.
         addToDB(key, value);
         addWordToFile(key, value);
         JOptionPane.showMessageDialog(this, "["+value+"]"+"����ܾ �߰��Ǿ����ϴ�", 
               key, JOptionPane.INFORMATION_MESSAGE);
      }
      inputField.setText("");
   
   }  
   private void addWordToDB(String key, String value) {
	   /*
	    * 1. db����
	    *    (1) jdbc ����̹� �޸� ����( �� ���� �ϸ� �Ǵϱ�, ���⼭�� ���ص� �ǰڴ�..)
	    *    (2) DriverManager.getConnection(url, id, ps) ȣ���ؼ�
	    *        Connection ��ü�� �����ϰ�
	    * 2. sql�� ����
	    *    (1) Connection ��ü���� ������ sql���� �����غ� ��û�ϰ� con.prepareStatement(sql);
	    *        PreparedStatement ��ü�� ��ȯ�ȴ�.
	    *    (2) PreparedStatement ��ü���� �������� �����û ������
	    *    	 PreparedStatement.executeUpdate() <- ������ sql���� insert, delete, �Ǵ� update �϶�
	    *        PreparedStatement.executeQuery(); <- ������ sql���� select ���� ��
	    * 3. db ���� ����
	    *    con.close();
	    */
	   
	   try (Connection con = DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW)){
		   String sql = "insert into dict values(?, ?)";
		   PreparedStatement pstmt = con.prepareStatement(sql);
		   // ? �� place horder �ϰ�, �����غ� ��Ų �Ŀ�,
		   // ���� ������ �� ? �ڸ��� ���� �����ϰ�, ���� ��û�� ������.
		   pstmt.setString(1, key);
		   pstmt.setString(2, value);
		   
		   // ������ sql���� insert, delete, �Ǵ� update ���� ��, executeUpdate �޼��� ȣ��
		   // �� ���� ���� insert, delete, update ���� �������� ����� ���ڵ��� ��
		   pstmt.executeUpdate(); //���� ��û
	   }catch(Exception e) {
		   System.out.println(e.getMessage());
		   e.printStackTrace();
	   }
   }
   
   private void addToDB(String key, String value) {
	  /*
	   * 1. ����̹� Ŭ������ �� �� ���� �޸𸮿� �����ϸ� ��.
	   *    �ٵ�, �̹� ��ü�� ������ ��, �����ڿ��� ����Ǿ���.
	   *    ���⼭�� ������ �ʿ䰡 ����.
	   *    
	   * 2. �����ͺ��̽��� ����
	   * 3. sql�� ����
	   * 4. �����ͺ��̽� ���� ����
	   */
	   
	   try (Connection con = DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW)){
		   String sql = "insert into dict values(?, ?)";
		   PreparedStatement pstmt = con.prepareStatement(sql);
		   
		   // ? �ڸ��� ���� ä�� �Ŀ�, ��������
		   // �����غ�� sql���� �����϶�� ��û�ؾ� �Ѵ�.
		   pstmt.setString(1, key);
		   pstmt.setString(2, value);
		   
		   pstmt.executeUpdate(); //���� ��û
	   }catch(Exception e) {
		   System.out.println(e.getMessage());
		   e.printStackTrace();
	   }
   }
   
   private void addWordToFile(String key, String value) {
      try (FileWriter fWriter = 
            new FileWriter(DIC_FILE_NAME, true)) {
         fWriter.write(key + "=" + value + "\n");
         
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
   
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      SimpleDictionary dictPanel = new SimpleDictionary();
      frame.add(dictPanel);
      frame.setTitle("���� �ѿ�����");
      
      frame.setResizable(false);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}