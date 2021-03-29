package ch13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiniPingPongGame extends JPanel implements KeyListener {
	private Ball ball;
	private Racquet racquet1, racquet2;
	protected int player1;
	protected int player2;
	public MiniPingPongGame() {
		ball = new Ball(this, Color.white);
		this.setBackground(Color.black);
		racquet1 = new Racquet(this, 10, 150, Color.blue);
		racquet2 = new Racquet(this, 560, 150, Color.yellow);
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	void move() {
		ball.move();
		racquet1.move();
		racquet2.move();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.white);
		g.drawLine(300, 0, 300, 400);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
		
		g.drawString((player1/10)+String.valueOf(player1%10), 215, 50);
		g.drawString((player2/10)+String.valueOf(player2%10), 320, 50);
		
		ball.draw(g2d);
		racquet1.draw(g2d);
		racquet2.draw(g2d);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		racquet1.keyPressed(e);
		racquet2.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		racquet1.keyReleased(e);
		racquet2.keyReleased(e);
		
	}
	
	class Ball {
		private static final int RADIUS = 10;
		private int x = 280, y =180, xSpeed = 1, ySpeed = 1;
		private MiniPingPongGame game;
		private Color color;
		
		public Ball(MiniPingPongGame game, Color color) {
			this.game = game;
			this.color = color;
		}
		
		void move() {
			if(x + xSpeed <0) {
				xSpeed = 1;
				player2 +=1;
				x = 280;
				y =180;
				xSpeed = -xSpeed;
				}
			if(x + xSpeed > game.getWidth() - 2*RADIUS) {
				xSpeed = -1;
				player1 +=1;
				x = 280;
				y =180;
				xSpeed = -xSpeed;
				}
			if(y + ySpeed <0)
				ySpeed = 1;
			if(y + ySpeed > game.getHeight() - 2*RADIUS)
				ySpeed = -1;
			if(collision()) {
				if(xSpeed <0) {
					xSpeed = -(xSpeed-1);
				}else {
					xSpeed = -(xSpeed+1);
				}
				if(ySpeed <0) {
					ySpeed -= 1;
				}
				if(ySpeed > 0){
					ySpeed += 1;
				}
			}
				
			x += xSpeed;
			y += ySpeed;
		}
		
		private boolean collision() {
//			return game.racquet1.getBounds().intersects(getBounds())
//					|| game.racquet2.getBounds().intersects(getBounds());
			
			Rectangle r1 = game.racquet1.getBounds();
			Rectangle r2 = game.racquet2.getBounds();
			Rectangle myr = getBounds();
			Boolean r1r = r1.intersects(myr);
			Boolean r2r = r2.intersects(myr);
					return r1r || r2r;
					
		}
		
		public void draw(Graphics2D g) {
			g.setColor(color);
			g.fillOval(x, y, 2*RADIUS, 2*RADIUS);
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, 2*RADIUS, 2*RADIUS);
		}
		
		
	}
	
	class Racquet{
		private static final int WIDTH = 10;
		private static final int HEIGHT = 80;
		private int x=0, y=0;
		private int xSpeed = 0;
		private int ySpeed = 0;
		private MiniPingPongGame game;
		private Color color;
		
		public Racquet(MiniPingPongGame game, int x, int y, Color color) {
			this.game = game;
			this.x = x;
			this.y = y;
			this.color = color;
			
		}
		
		public void move() {
			if(y + ySpeed > 0 && y + ySpeed < game.getHeight() - HEIGHT)
				y += ySpeed;
		}
		
		public void draw(Graphics2D g) {
			g.setColor(color);
			g.fillRect(x, y, WIDTH, HEIGHT);
			}
		
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				racquet2.ySpeed = 3;
			}else if(e.getKeyCode() == KeyEvent.VK_UP) {
				racquet2.ySpeed = -3;
			}else if(e.getKeyCode() == KeyEvent.VK_W) {
				racquet1.ySpeed = -3;
			}else if(e.getKeyCode() == KeyEvent.VK_S) {
				racquet1.ySpeed = 3;
			}
		}
		
		public void keyReleased(KeyEvent e) {
			ySpeed = 0;
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, WIDTH, HEIGHT);
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("PingPong Game");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		MiniPingPongGame game = new MiniPingPongGame();
		frame.add(game);
		frame.setVisible(true);
		while (true) {
			game.move();
			game.repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
