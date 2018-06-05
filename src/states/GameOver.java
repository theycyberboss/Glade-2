package states;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import start.Application;

public class GameOver extends BasicGameState {

	private Image background;
	
	
	Font font = new Font("Monospaced",Font.PLAIN,50);
	TrueTypeFont ttf = new TrueTypeFont(font,true);
	
	
	
	Color backColor = new Color(130,130,130);
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("Res/images/space.png");
		backColor.a = .6f;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	
		g.drawImage(background,-300,-180,-150,-150,Application.WIDTH,Application.HEIGHT);

		
		g.setColor(backColor);
		g.fillRect(0, 180, Application.WIDTH, Application.HEIGHT/2-50);
		g.setFont(ttf);
		g.setColor(Color.white);
		g.drawString("GAME OVER", Application.WIDTH / 2 - 145, 200);
		//g.drawString("LIVES: " + Game.LIVES, 10, Application.HEIGHT - 40);
		g.drawString("IRON: " + Game.IRON, 150, Application.HEIGHT/2);
		g.drawString("SCORE: " + Game.SCORE, Application.WIDTH - 375, Application.HEIGHT/2);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Application.GameOver;
	}

}
