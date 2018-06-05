package entities;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import start.Application;
import start.Handler;
import start.Object;
import start.debug;
import states.Game;

public class Ship1 extends Object {
	
	private float velx, vely;
	private float acc = .2f;
	private int maxSpeed = 8;
	
	
	
	public Ship1(float x, float y, float width, float height, String ID) {
		super(x, y, width, height,ID);
		
		this.setTexture("Res/ships/stinger.png");
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
	
		Input input = gc.getInput();
		
		if(gc.getInput().isKeyDown(Input.KEY_W))
		{
			vely  = vely -= acc;
		}
		
		if(gc.getInput().isKeyDown(Input.KEY_S))
		{
			vely = vely += acc ;
		}
		
		if(gc.getInput().isKeyDown(Input.KEY_A))
		{
			velx = velx -= acc ;
		}
		
		if(gc.getInput().isKeyDown(Input.KEY_D))
		{
			velx = velx + acc ;
		}
		
		if(velx > maxSpeed)
		{
			velx = maxSpeed;
		}
		if(vely > maxSpeed)
		{
			vely = maxSpeed;
		}
		
		
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
		
		
		
		
		position.x += velx;
		position.y += vely;

		position.angle = this.pointDirection(position.x, position.y, gc.getInput().getMouseX(), gc.getInput().getMouseY());

		
		
		
		if(gc.getInput().isMousePressed(0))
		{
			Laser ls = new Laser(position.x,position.y,4,4,"laser");
			ls.speed = 10;
			ls.setAngle(position.angle);
			
			
			Handler.addObject(ls);
			
		}
		
		for(int i = 0; i < Handler.Objects.size(); i++ )
		{
			Object temp = Handler.Objects.get(i);
		
			if(temp.getID().startsWith("Astroid"))
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					Handler.removeObject(temp);
					position.x = Application.WIDTH/2;
					position.y = Application.HEIGHT/2;
					velx = 0f;
					vely = 0f;
					
					Game.LIVES -= 1;
					
					if(Game.LIVES <= 0)
					{
						Game.GAMEOVER = true;
					}
				
				}
			}
		}
			


		
		
	}
	

	@Override
	public void render(Graphics g) {

		g.drawImage(getTexture(),position.x - position.width/2, position.y - position.height/2);

		
	}

}
