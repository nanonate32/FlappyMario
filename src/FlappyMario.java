

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlappyMario extends JFrame {
	public final static int HEIGHT = 800;
	public final static int WIDTH = 500;
	
	FlappyPanel game = new FlappyPanel();
	JFrame frame = new JFrame();
	public FlappyMario() {
		
	

    frame.addKeyListener(game);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
    
    frame.pack();
	
	}
	public static void main(String[] args) {
		FlappyMario flappy = new FlappyMario();
		flappy.setup();
		}



	
	void setup() {
		frame.add(game);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.pack();
    	
    	
}
	}

