package ch13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
	private JPanel panel;
	private JTextField textField;
	private JButton [] numBtn;
	private JButton addBtn, subBtn, mulBtn, divBtn, decBtn, equBtn, delBtn, clrBtn, negBtn;
	
	private double num1, num2, result;
	private String operator;
	
	public Calculator() {
		this.setSize(430, 550);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setEnabled(false);
		textField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		numBtn = new JButton[10];
		
		for(int i =0; i<numBtn.length; i++) {
			numBtn[i] = new JButton(String.valueOf(i));
			
			numBtn[i].addActionListener(this);
		}
		addBtn = new JButton("+");
		addBtn.addActionListener(this);
		subBtn = new JButton("-");
		subBtn.addActionListener(this);
		mulBtn = new JButton("*");
		mulBtn.addActionListener(this);
		divBtn = new JButton("/");
		divBtn.addActionListener(this);
		decBtn = new JButton(".");
		decBtn.addActionListener(this);
		equBtn = new JButton("=");
		equBtn.addActionListener(this);
		delBtn = new JButton("Delete");
		delBtn.addActionListener(this);
		delBtn.setBounds(150, 430, 100, 40);
		clrBtn = new JButton("Clear");
		clrBtn.addActionListener(this);
		clrBtn.setBounds(250, 430, 100, 40);
		negBtn = new JButton("(-)");
		negBtn.addActionListener(this);
		negBtn.setBounds(50, 430, 100, 40);
		
		panel.add(numBtn[1]);
		panel.add(numBtn[2]);
		panel.add(numBtn[3]);
		panel.add(addBtn);
		panel.add(numBtn[4]);
		panel.add(numBtn[5]);
		panel.add(numBtn[6]);
		panel.add(subBtn);
		panel.add(numBtn[7]);
		panel.add(numBtn[8]);
		panel.add(numBtn[9]);
		panel.add(mulBtn);
		panel.add(decBtn);
		panel.add(numBtn[0]);
		panel.add(equBtn);
		panel.add(divBtn);
		
		this.add(negBtn);
		this.add(delBtn);
		this.add(clrBtn);
		this.add(textField);
		this.add(panel);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = textField.getText();
		for(int i=0; i<numBtn.length; i++) {
			if(e.getSource() == numBtn[i]) {
				
				textField.setText(str.concat(String.valueOf(i)));
				break;
			}
		}
		
		if(e.getSource() == clrBtn) {
			textField.setText("");
		}else if(e.getSource() == decBtn) {
			textField.setText(str.concat("."));
		}else if(e.getSource() == delBtn) {
			textField.setText(str.substring(0, str.length()-1));
		}else if(e.getSource() == negBtn) {
			double temp = Double.parseDouble(str);
			temp = temp*(-1);
			textField.setText(String.valueOf(temp));
		}else if(e.getSource() == addBtn || e.getSource() == subBtn || e.getSource() == mulBtn || e.getSource() == divBtn) {
			num1 = Double.parseDouble(str);
			operator = ((JButton)(e.getSource())).getText();
			textField.setText("");
		}else if(e.getSource() == equBtn) {
			num2 = Double.parseDouble(str);
			switch(operator) {
			case "+" :
				result = num1 + num2;
				break;
			case "-" :
				result = num1 - num2;
				break;
			case "*" :
				result = num1 * num2;
				break;
			case "/" :
				result = num1 / num2;
			}
			textField.setText(String.valueOf(result));
		}
		
		
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

}
