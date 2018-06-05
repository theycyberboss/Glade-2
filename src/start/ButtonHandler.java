package start;

import java.util.LinkedList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class ButtonHandler {
	
	public static LinkedList<Button> Buttons = new LinkedList<Button>();
	
	public ButtonHandler()
	{
		
	}
	
	public static void addButton(Button b)
	{
		Buttons.add(b);
	}
	
	public static void removeButton(Button b)
	{
		Buttons.remove(b);
	}
	
	public void update(GameContainer gc)
	{
		for(int i = 0; i < Buttons.size(); i++)
		{
			Button temp = Buttons.get(i); 
		}
		
	}
	
	public void render(Graphics g, GameContainer gc, StateBasedGame sbg)
	{
		Input input = gc.getInput();
		
		for(int i = 0; i < Buttons.size(); i++)
		{
			Button temp = Buttons.get(i);
			temp.render(g, gc);
			if(input.getMouseX() > temp.getX() && input.getMouseX() < temp.getX() + temp.getWidth())
			{
				if(input.getMouseY() > temp.getY() && input.getMouseY() < temp.getY() + temp.getHeight())
				{
					temp.mouseOver(g, gc);
				}
				
			}else {
				temp.mouseUp(g, gc);
			}
			
			if(input.getMouseX() > temp.getX() && input.getMouseX() < temp.getX() + temp.getWidth())
			{
				if(input.getMouseY() > temp.getY() && input.getMouseY() < temp.getY() + temp.getHeight() && input.isMousePressed(0))
				{
					temp.mouseDown(g, gc,sbg);
				}
				
			}
		}
		
	}

}
