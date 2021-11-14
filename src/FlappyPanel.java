
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

public class FlappyPanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean shotFired = false;
	FlappyManager manager;
	Mario mario;

	final static int MENU = 0;
	final static int GAME = 1;
	final static int END = 2;
	Font titleFont;
	Font menuFont;
	static int currentState = MENU;
	Timer pipeSpawn;

	public FlappyPanel() {
		if (needImage) {
			loadImage("MarioBackground-scrolling-top.png");

		}
		mario = new Mario(250, 200, 50, 50);
		manager = new FlappyManager(mario);
		titleFont = new Font("Comic Sans", Font.PLAIN, 48);
		menuFont = new Font("Comic Sans", Font.PLAIN, 24);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

	}

	Timer frameDraw;

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
				pipeSpawn.stop();

			} else if (currentState == MENU) {
				startGame();
				currentState = GAME;
			} else {
				currentState++;

			}
		}
		if (currentState == GAME) {

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
              mario.velocity -= 5; 
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		// System.out.println("action");
		System.out.println(FlappyPanel.currentState);
		repaint();
	}

	void startGame() {
		pipeSpawn = new Timer(7000, manager);
		pipeSpawn.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		if (mario.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, FlappyMario.WIDTH, FlappyMario.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Flappy Mario", 40, 50);
		g.setFont(menuFont);
		g.drawString("Press ENTER to start", 125, 300);

	}

	void drawGameState(Graphics g) {
		g.drawImage(image, 0, 0, FlappyMario.WIDTH, FlappyMario.HEIGHT, null);
		manager.draw(g);
		g.drawString("score:" + manager.getScore(), 100, 100);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, FlappyMario.WIDTH, FlappyMario.HEIGHT);

	}
}
