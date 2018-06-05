package start;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import start.Application;
import start.Button;

public class startButton extends Button {

	public startButton(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(GameContainer gc) {
		
		
	}

	@Override
	public void render(Graphics g, GameContainer gc) {
		g.setColor(Color.gray);
		g.fillRect(x, y, width, height);
		
		
	}

	@Override
	public void mouseOver(Graphics g, GameContainer gc) {
		g.setColor(Color.darkGray);
		g.fillRect(x, y, width, height);
		
	}


	@Override
	public void mouseUp(Graphics g, GameContainer gc) {
		
		
	}

	@Override
	public void mouseDown(Graphics g, GameContainer gc, StateBasedGame sbg) {
	sbg.enterState(Application.GAME);
		
	}

}
