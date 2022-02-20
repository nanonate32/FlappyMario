
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class FlappyManager implements ActionListener {
Random randy = new Random();
	public static Mario mario;
	int score = 0;

	static ArrayList<Pipe> pipes = new ArrayList<Pipe>();
	static ArrayList<Fireball> fireballs = new ArrayList<Fireball>();
	
	
		
	   
	

	Random random = new Random();

	FlappyManager(Mario mario2) {
		mario = mario2;
	}

	void addPipes() {
		int pipeHeight1 = random.nextInt(400) + 100;
		int pipeHeight2 = pipeHeight1 + 200;

		pipes.add(new Pipe(FlappyMario.WIDTH, 0, 50, pipeHeight1, true));
		pipes.add(new Pipe(FlappyMario.WIDTH, pipeHeight2, 50, FlappyMario.HEIGHT - pipeHeight2, false));
		if (pipeHeight1 > 800 - pipeHeight2) {

		}

	}

	void update() {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).update();
			if (pipes.get(i).x > FlappyMario.WIDTH) {
				pipes.get(i).x = 200;
                
			}
			if (mario.x == pipes.get(i).x) {
             score++;
			}
			
		
		}
		for (int i = 0; i < fireballs.size(); ) {
			fireballs.get(i).update();
			if(fireballs.get(i).x >= FlappyMario.WIDTH + 20000 || fireballs.get(i).x + fireballs.get(i).width <= 0 ) {
				fireballs.remove(i);
			
			}
			else {
				i++;
			}
		}
		

		mario.update();
		checkCollision();
		purgeObjects();
		
	}

	void draw(Graphics g) {
		mario.draw(g);
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).draw(g);
		
		}
		for (int i = 0; i < fireballs.size(); i++) {
			fireballs.get(i).draw(g);
		}

	}

	void purgeObjects() {
		for (int i = 0; i < pipes.size(); i++) {

			if (pipes.get(i).isActive == false) {
				pipes.remove(i);

			}

		}

		for (int i = 0; i < fireballs.size(); i++) {

			if (fireballs.get(i).isActive == false) {
				fireballs.remove(i);

			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  	 
        if(e.getSource() == FlappyPanel.pipeSpawn) {
        	addPipes();
        }
        if(e.getSource() == FlappyPanel.fireballSpawn) {
        	fireballs.add(new Fireball(0, randy.nextInt(FlappyMario.HEIGHT)));
        }
	}

	void checkCollision() {

		for (int j = 0; j < pipes.size(); j++) {
			if (pipes.get(j).collisionBox.intersects(mario.collisionBox)) {
				pipes.get(j).isActive = false;
				mario.isActive = false;
				score++;
			}
		}
		for(Fireball f: fireballs){
			if(f.collisionBox.intersects(mario.collisionBox)) {
				mario.isActive = false;
			}
		}
			
			if(mario.y >= 800) {
				mario.isActive = false;
			}

		
	}
	public static void setPipeSpeed(int speed) {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).speed = speed;
		}
		
	}
	

	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	
		

	
}
