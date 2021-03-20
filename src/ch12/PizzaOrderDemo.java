package ch12;
import javax.swing.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class PizzaOrderDemo extends JFrame implements ActionListener{
	private int sum, temp1, temp2, temp3;
	
	private JButton orderBtn, cancelBtn;
	private JPanel orderPanel;
	private JTextField priceField;
	
	JPanel welcomePanel = new WelcomePanel();
	
	JPanel typePanel = new TypePanel();
	JPanel toppingPanel = new ToppingPanel();
	JPanel sizePanel = new SizePanel();
	
	public PizzaOrderDemo() {
		this.setSize(500, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("���� �ֹ�");
		
		orderBtn = new JButton("�ֹ�");
		orderBtn.addActionListener(this);
		
		cancelBtn = new JButton("���");
		cancelBtn.addActionListener(this);
		
		priceField = new JTextField();
		priceField.setEditable(false);
		priceField.setColumns(6);
		
		orderPanel = new JPanel();
		orderPanel.add(orderBtn);
		orderPanel.add(cancelBtn);
		orderPanel.add(priceField);
		
		this.add(welcomePanel, BorderLayout.NORTH);
		this.add(orderPanel, BorderLayout.SOUTH);
		this.add(sizePanel, BorderLayout.EAST);
		this.add(typePanel, BorderLayout.WEST);
		this.add(toppingPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			int op1, op2, op3;
			if(e.getSource() == orderBtn) {
				if(temp1 == 0) {
					op1 = 0;
				}else if(temp1 == 1) {
					op1 = 1000;
					
				}else {
					op1 = 2000;
				}
				if(temp2 == 0) {
					op2 = 0;
				}else if(temp2 == 1) {
					op2 = 1000;
					
				}else if(temp2 == 2) {
					op2 = 2000;
				}else {
					op2 = 3000;
				}
				if(temp3 == 0) {
					op3 = 10000;
				}else if(temp3 == 1) {
					op3 = 15000;
					
				}else {
					op3 = 20000;
				}
				sum = op1 + op2 + op3;
				priceField.setText(String.valueOf(sum));
				
				System.out.println("temp1:"+ temp1 + ", temp2:" + temp2 + ", temp3:" + temp3);
				System.out.println("sum: " + sum);
			}else if(e.getSource() == cancelBtn){
//				temp1 = 0;
//				temp2 = 0;
//				temp3 = 0;
				sum = 0;
				priceField.setText(String.valueOf(sum));
			
			}
		
		}
	
	class WelcomePanel extends JPanel{
		private JLabel message;
	
		public WelcomePanel() {
			message = new JLabel("�ڹ� ���ڿ� ���Ű��� ȯ���մϴ�.");
			this.add(message);
			}
	}
	class TypePanel extends JPanel implements ActionListener{
		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup btnGroup;
	
		public TypePanel() {
			this.setLayout(new GridLayout(3, 1));
			combo = new JRadioButton("�޺�", true);
			combo.addActionListener(this);
			potato = new JRadioButton("��������");
			potato.addActionListener(this);
			bulgogi = new JRadioButton("�Ұ��");
			bulgogi.addActionListener(this);
		
			btnGroup = new ButtonGroup();
			btnGroup.add(combo);
			btnGroup.add(potato);
			btnGroup.add(bulgogi);
		
			this.setBorder(BorderFactory.createTitledBorder("����"));
		
			this.add(combo);
			this.add(potato);
			this.add(bulgogi);
		}
	
	
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("TypePanel stateChanged... " + ((JRadioButton)e.getSource()).getActionCommand());
			if(e.getSource() == combo) {
				temp1 = 0;
				
			
			}else if(e.getSource() == potato) {
				temp1 =1;
			}else {
				temp1 = 2;
			}
		
		}
	
	}
	class ToppingPanel extends JPanel implements ActionListener{
		private JRadioButton pepper, cheese, peperoni, bacon;
		private ButtonGroup btnGroup;
	
		public ToppingPanel() {
			this.setLayout(new GridLayout(4, 1));
		
			pepper = new JRadioButton("�Ǹ�", true);
			pepper.addActionListener(this);
			cheese = new JRadioButton("ġ��");
			cheese.addActionListener(this);
			peperoni = new JRadioButton("����δ�");
			peperoni.addActionListener(this);
			bacon = new JRadioButton("������");
			bacon.addActionListener(this);
		
			btnGroup = new ButtonGroup();
			btnGroup.add(pepper);
			btnGroup.add(cheese);
			btnGroup.add(peperoni);
			btnGroup.add(bacon);
		
			this.setBorder(BorderFactory.createTitledBorder("�߰�����"));
		
			this.add(pepper);
			this.add(cheese);
			this.add(peperoni);
			this.add(bacon);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("ToppingPanel stateChanged... " + ((JRadioButton)e.getSource()).getActionCommand());
			if(e.getSource() == pepper) {
				temp2 = 0;
			}else if(e.getSource() == cheese) {
				temp2 =1;
			}else if(e.getSource() == peperoni) {
				temp2 = 2;
			}else if(e.getSource() == bacon){
				temp2 = 3;
			}
		
		}
	
	}
	class SizePanel extends JPanel implements ActionListener{
		private JRadioButton small, medium, large;
		private ButtonGroup btnGroup;
	
		public SizePanel() {
			this.setLayout(new GridLayout(3, 1));
			small = new JRadioButton("small", true);
			small.addActionListener(this);
			medium = new JRadioButton("medium");
			medium.addActionListener(this);
			large = new JRadioButton("large");
			large.addActionListener(this);
		
			btnGroup = new ButtonGroup();
			btnGroup.add(small);
			btnGroup.add(medium);
			btnGroup.add(large);
		
			this.setBorder(BorderFactory.createTitledBorder("ũ��"));
		
			this.add(small);
			this.add(medium);
			this.add(large);
		
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("SizePanel stateChanged... " + ((JRadioButton)e.getSource()).getActionCommand());
			if(e.getSource() == small) {
				temp3 = 0;
			}else if(e.getSource() == medium) {
				temp3 = 1;
			}else {
				temp3 =2;
			}
		
		}
	
	}
	public static void main(String[] args) {
		new PizzaOrderDemo();
	}
}
