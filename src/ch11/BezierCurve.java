package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class BezierCurve extends JPanel implements MouseListener, MouseMotionListener{
	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	
	private int drageIndex = -1;

	public BezierCurve() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//점 4개 찍기
		g.setColor(Color.blue);
		g.fillRect(xs[0], ys[0], 16, 16);
		g.fillRect(xs[2], ys[2], 16, 16);
		g.setColor(Color.red);
		g.fillRect(xs[1], ys[1], 16, 16);
		g.fillRect(xs[3], ys[3], 16, 16);
		
		//점 4개를 이용해서 베지어 곡선 그리기
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		GeneralPath path = new GeneralPath();
		path.moveTo(xs[0], ys[0]);
		path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
		
		g2d.draw(path);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new BezierCurve());
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(drageIndex  != -1) {
			xs[drageIndex] = e.getX();
			ys[drageIndex] = e.getY();
		}
		
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 4개의 점 중에서 어떤 점을 찍었는지 검사..
//		e.getX();
//		e.getY();
		
		for(int i=0; i<4; i++) {
			Rectangle r = new Rectangle(xs[i]-4, ys[i]-4, 20, 20);
			if(r.contains(e.getX(), e.getY())) {
				drageIndex = i;
				
			}
		}
//		repaint();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		drageIndex = -1;
//		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
