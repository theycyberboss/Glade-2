package start;

import java.util.LinkedList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class debug {
	
	float x,y,width,height;
	float alpha = .2f;
	int row = 0;
	static int outputSize = 0;
	static int totalSize = 0;
	
	boolean visible = true;
	Color c = new Color(211,211,211);
	Color c2 = new Color(255,0,0);
	
	static LinkedList Output = new LinkedList();
	
	int cells = 5;
	
	public debug(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		c.a = alpha;
		c2.a = .5f;
		
		visible = false;
	}
	
	public void render(Graphics g, GameContainer gc)
	{
		
		
		
		if(visible){
			
			
	
			
		 
		if(outputSize > 5) //Stop the text from going over the edge
		{
			//Output.removeFirst();
		
		   outputSize -= 1;
			row += 1;
			
		}
		
	
		
	
		if(gc.getInput().isKeyPressed(Input.KEY_F11)) 	//Input to move debug input
		{
			if(row > 0) {
				row -= 1;

			}
		}if(gc.getInput().isKeyPressed(Input.KEY_F12) && outputSize < Output.size())
		{
			if(row < Output.size() - 5) {
				row += 1;
			}
			
			
		}
		
		
		//Color and index
		g.setColor(c);
		g.fillRect(x, y, width, height);

		g.setColor(c2);
		int j = 0;
		
		
		//Determine the offset to render correct text
		
		for(int i = 0; i < 5 ; i++) 	//Draw the output
		{
		
			g.drawString((String) Output.get(i + row), x+15 , (j * height/cells) + y );
			
			j++;
		}
		

		
		}
		
		
	}
	
	public static void Log(String str)
	{
		
	
			
			Output.add(totalSize + " Log: " + str);
			outputSize += 1;
			totalSize += 1;
		
		
		
		
	}
	
	
	public void setVisible(boolean vis)
	{
		visible = vis;
	}
	
	public boolean isVisible()
	{
		return visible;
	}

}
