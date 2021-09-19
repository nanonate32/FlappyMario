

	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.awt.image.BufferedImage;

	import javax.imageio.ImageIO;
	import javax.swing.JPanel;
	import javax.swing.Timer;

	public class GamePanel extends JPanel implements ActionListener, KeyListener {
		public static BufferedImage image;
		public static boolean needImage = true;
		public static boolean gotImage = false;
		boolean shotFired = false;
		FlappyObject manager;
		Mario mario;
		
		final int MENU = 0;
		final int GAME = 1;
		final int END = 2;
		Font titleFont;
		Font menuFont;
		int currentState = MENU;
		
		public GamePanel() {
			if (needImage) {
			//	loadImage("MarioBackground-scrolling-top.png");
			
			}
				
			} 
			public void paintComponent(Graphics g) {
				if (currentState == MENU) {
				//	drawMenuState(g);
				} else if (currentState == GAME) {
				//	drawGameState(g);
				} else if (currentState == END) {
				//	drawEndState(g);
				}

			}
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

