package ch11;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;

public class GradientPanel extends MyPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		GradientPaint gp = new GradientPaint(0, 10, Color.white, 0, 70, Color.red);
		for(Shape s: shapeArray) {
			g2.setPaint(gp);
			g2.fill(s);
			g2.draw(s);
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600, 130);
		frame.setTitle("Java 2D Shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GradientPanel());
		frame.setVisible(true);
	}
}
