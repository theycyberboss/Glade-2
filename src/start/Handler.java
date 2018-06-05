package start;

import java.util.LinkedList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Handler {
	
	public static LinkedList<Object> Objects = new LinkedList<Object>();
	
	public Handler()
	{
		
	}
	
	public static void addObject(Object o)
	{
		Objects.addFirst(o);
	}
	
	public static void removeObject(Object o)
	{
		Objects.remove(o);
	}
	
	public void update(GameContainer gc, int delta) {
		for(int  i = 0; i < Objects.size(); i++)
		{
			Object temp = Objects.get(i);
			temp.update(gc, delta);

			temp.getBounds().setLocation(temp.position.x - temp.position.width/2, temp.position.y - temp.position.height/2);
			
			
			
		}
	}
	
	public void render(Graphics g)
	{
		for(int  i = 0; i < Objects.size(); i++)
		{
			
			Object temp = Objects.get(i);
			g.pushTransform();
			
			g.rotate(temp.position.x, temp.position.y, temp.position.angle);
			temp.render(g);
			
			g.setColor(Color.red);
		
			g.popTransform();
			
			if(Application.DEBUGMODE == true) {
				g.drawRect(temp.getBounds().getX(),temp.getBounds().getY(),temp.getBounds().getWidth(),temp.getBounds().getHeight());
			}
		}
		
	}

}
