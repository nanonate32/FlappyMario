import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Pipe extends FlappyObject {
	public static BufferedImage topImage;
	public static BufferedImage bottomImage;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	public boolean isTop;

	Pipe(int x, int y, int width, int height, boolean isTop) {
		super(x, y, width, height);
		this.isTop = isTop;
		System.out.println(isTop);
		speed = 1;

		if (needImage) {
			loadImage("topPipe.png");
		}

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				topImage = ImageIO.read(this.getClass().getResourceAsStream("pipeTop.png"));
				bottomImage = ImageIO.read(this.getClass().getResourceAsStream("pipeBottom.png"));
				gotImage = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			needImage = false;
		}
	}

	void update() {
		x -= speed;
		super.update();
	}

	void draw(Graphics g) {
		if (gotImage) {
			if (isTop) {
				g.drawImage(topImage, (int) x, (int) y, width, height, null);
			} else {
				g.drawImage(bottomImage, (int) x, (int) y, width, height, null);
			}
		} else {
			g.setColor(Color.ORANGE);
			g.fillRect((int) x, (int) y, width, height);
		}
	}

}
