package entities;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import start.Handler;
import start.Object;

public class Laser extends Object {

	public float speed = 0;
	
	public Laser(float x, float y, float width, float height, String ID) {
		super(x, y, width, height, ID);
		
		
		
		//this.setTexture("Res/ships/cruiser.png");
	}

	
	public void setAngle(float angle)
	{
		position.angle = angle;
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
		position.x += this.moveAngleX(speed, position.angle);
		position.y += this.moveAngleY(speed, position.angle);
		
		
		
		
	}
	
	
	public boolean checkAstroid()
	{
		for(int i = 0; i < Handler.Objects.size(); i++ )
		{
			Object temp = Handler.Objects.get(i);
			
			if(temp.getID().startsWith("astroid"))
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					return true;
				}else {
					return false;
				}
			}
		}
		
		return false;
	}

	@Override
	public void render(Graphics g) {
	
		g.setColor(Color.white);
		g.fillRect(position.x, position.y, position.width, position.height);
	
		
	}
	

}
