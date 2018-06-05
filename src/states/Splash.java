package states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import start.Application;

public class Splash extends BasicGameState {

	Image splashImg;
	
	Color c = new Color(0,0,0);
	float alpha = 1f;

	int timer = 100;
	boolean fading = false;
	boolean count = false;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame sbg) throws SlickException {
	
		splashImg = new Image("Res/images/splash.jpg");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	
		
		g.drawImage(splashImg,-118,20);
		g.setColor(c);
		g.fillRect(0, 0, Application.WIDTH, Application.HEIGHT);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		
		if(fading)
		{
			if(timer <= 0) {
				alpha += .005;
				c.a = alpha;
			}
		}else if(!fading) {
			alpha -= .005;
			c.a = alpha;
		}
		
		
		
		if(alpha <= 0)
		{
			fading = true;
			count = true;
		}
		
		if(fading && alpha >= 1)
		{
			sbg.enterState(Application.GAME);
		}

		
		if(count)
		{
			timer -= 1;
		}
		
	}

	@Override
	public int getID() {
	
		return Application.SPLASH;
	}

}
