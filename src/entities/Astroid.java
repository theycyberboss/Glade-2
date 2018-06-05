package entities;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import start.Application;
import start.Handler;
import start.Object;
import start.WaveSpawner;
import states.Game;

public class Astroid extends Object {

	float offsetX, offsetY;
	
	Random r = new Random();
	
	public Astroid(float x, float y, float width, float height, String ID) {
		super(x, y, width, height,ID);
		
		this.setTexture("Res/astroids/asteroid1.png");
		
		offsetX = r.nextInt(10) - 5;
		offsetY = r.nextInt(10) - 5;
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
		if(position.x + position.width < 0)
		{
			position.x = Application.WIDTH;
		}
		if(position.y + position.height < 0)
		{
			position.y = Application.HEIGHT;
		}
		if(position.x - position.width > Application.WIDTH)
		{
			position.x = 0;
		}
		if(position.y - position.height > Application.HEIGHT)
		{
			position.y = 0;
		}
		
		position.x += offsetX;
		position.y += offsetY;
		
		
		for(int i = 0; i < Handler.Objects.size(); i++ )
		{
			Object temp = Handler.Objects.get(i);
			
			if(temp.getID().startsWith("laser"))
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					Handler.removeObject(this);
					Handler.removeObject(temp);
					WaveSpawner.amountLeft -= 1;
					
					Game.SCORE += r.nextInt(350);
				}
			}
		}
			
		
			
		
	}
	
	
	

	@Override
	public void render(Graphics g) {
	
		g.drawImage(getTexture(),position.x - position.width/2, position.y - position.height/2);

		
	}

}
