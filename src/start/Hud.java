package start;



import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import states.Game;

public class Hud {
	
	Font font = new Font("Jokerman",Font.PLAIN,25);
	TrueTypeFont ttf = new TrueTypeFont(font,true);
	
	Color backColor = new Color(130,130,130);
	
	public Hud()
	{
		backColor.a = .9f;
	}
	
	public void update(GameContainer gc, int delta)
	{
		
	}
	
	public void render(Graphics g, GameContainer gc)
	{
		g.setColor(backColor);
		
		g.fillRect(0, Application.HEIGHT - 50, Application.WIDTH, Application.HEIGHT);
		
		g.setFont(ttf);
		g.setColor(Color.white);
		g.drawString("LIVES: " + Game.LIVES, 10, Application.HEIGHT - 40);
		g.drawString("IRON: " + Game.IRON, (Application.WIDTH / 2)-75, Application.HEIGHT - 40);
		g.drawString("SCORE: " + Game.SCORE, Application.WIDTH - 230, Application.HEIGHT - 40);
		
	}

}
