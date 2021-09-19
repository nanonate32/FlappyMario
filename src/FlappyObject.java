import java.awt.Rectangle;

public class FlappyObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	int jumpHeight = 0;
	boolean isActive = true;

	FlappyObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		jumpHeight = 10;
		collisionBox = new Rectangle(x, y, width, height);
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
}
