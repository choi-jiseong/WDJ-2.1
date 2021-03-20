package ch11;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class MoreShapes extends JFrame {
	
	public MoreShapes() {
		this.setSize(600, 130);
		this.setTitle("Java 2D Shapes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MyPanel();
		this.add(panel);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MoreShapes();
	}
}

class MyPanel extends JPanel {
	ArrayList<Shape> shapeArray = new ArrayList<Shape>();
	public MyPanel() {
//		 Shape rect = new Rectangle2D.Float(10, 10, 70, 80);
		 shapeArray.add(new Rectangle2D.Float(10, 10, 70, 80)); // �簢��
		 shapeArray.add(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20)); // �𼭸� ���� �簢��
		 shapeArray.add(new Ellipse2D.Float(210, 10, 80, 80)); //��
		 shapeArray.add(new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN)); //�
		 shapeArray.add(new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD)); // ���� ���� ������ ����
		 shapeArray.add(new Arc2D.Float(510, 10, 80, 80, 45, 45, Arc2D.PIE)); //��ä��
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		//���� �ε巴�� ���ֱ�
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.black);
		
		// �� ���� ����
		g2.setStroke(new BasicStroke(3));
		
	
		
		for(Shape s : shapeArray) {
			g2.draw(s);
		}
	}
}
