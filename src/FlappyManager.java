


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class FlappyManager implements ActionListener {

	 Mario mario;
	int score = 0;
	
	ArrayList<Pipe> pipes = new ArrayList<Pipe>();
	
	Random random = new Random();

	FlappyManager(Mario mario) {
		this.mario = mario;
	}


	void addPipes() {
		int pipeHeight1 = random.nextInt(400) + 100;
		int pipeHeight2 = pipeHeight1 + 200;
	
		pipes.add(new Pipe(FlappyMario.WIDTH, 0, 50, pipeHeight1  ));
		pipes.add(new Pipe(FlappyMario.WIDTH, pipeHeight2, 50, 1000  ));
		if(pipeHeight1 > 800 - pipeHeight2) {
			
		}
			
	    
		
		
	}

	void update() {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).update();
			if (pipes.get(i).x > FlappyMario.WIDTH) {
				pipes.get(i).x= 200;
             
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
			
		}
		
	

	void purgeObjects() {
		for (int i = 0; i < pipes.size(); i++) {

			if (pipes.get(i).isActive == false) {
				pipes.remove(i);

			}

		}

		for (int i = 0; i < pipes.size(); i++) {

			if (pipes.get(i).isActive == false) {
				pipes.remove(i);

			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addPipes();
		
	}

	void checkCollision() {
		
			for (int j = 0; j < pipes.size(); j++) {
				if (pipes.get(j).collisionBox.intersects(mario.collisionBox)) {
                   pipes.get(j).isActive = false;
                   mario.isActive = false;
                   score++;
				}
				
			}
		}
	
	public int getScore() {
	return score;	
	}
	
}
