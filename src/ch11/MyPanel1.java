package ch11;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class MyPanel1 extends JPanel implements ActionListener {
	private Timer timer;
	private BufferedImage image;
	private final int START_X = 0;
	private final int START_Y = 250;
	private int x, y;
	public MyPanel1() {
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(500, 300));
		this.setDoubleBuffered(true);
		
		File file = new File("image/space.jpg");
		System.out.println(file.getAbsoluteFile());
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		timer = new Timer(20, this);
		timer.start();
		
		x = START_X;
		y = START_Y;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 이미지의 x, y 좌표를 적적히 변경
		*/
		
		if(x>250) {
			x+=1;
			y+=1;
		}else {
			x += 1;
			y -= 1;
		}
		if(x>500) {
			x = START_X;
			y = START_Y;
		}
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new MyPanel1());
		frame.setTitle("애니메이션 테스트");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.setSize(500, 300);
		frame.setVisible(true);
	}
}
