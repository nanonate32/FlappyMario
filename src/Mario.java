import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Mario extends FlappyObject {

		public static BufferedImage image;
		public static boolean needImage = true;
		public static boolean gotImage = false;	
		Mario(int x, int y, int width, int height) {
			super(x, y, width, height);
			speed = 1;
			jumpHeight = 1;
			if (needImage) {
			    loadImage ("MarioKart.png");
			}
			
		}
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
	void update() {
		
		y+=velocity;
		
		velocity+=1;
		
		super.update();
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	}


	


