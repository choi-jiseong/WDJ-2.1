package ch12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Capture extends JFrame {
	
	private Rectangle rect;
	private Dimension d;
	private JPanel panel;
	public Capture() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rect = new Rectangle (500, 500);
		this.setSize(d = new Dimension(500, 500));
		try {
			
			Robot robot = new Robot();
			final BufferedImage image = robot.createScreenCapture(rect);
			image.flush();
			
			panel = new JPanel() {
				public void paintComponent (Graphics g) {
					g.drawImage(image, 0, 0, d.width, d.height, this);
				}
			};
			panel.setOpaque(false);
			panel.prepareImage(image, panel);
			panel.repaint();
			this.getContentPane().add(panel);
		} catch (AWTException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Capture();
	}
	
}
