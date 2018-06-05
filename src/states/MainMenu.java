package states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import start.Application;
import start.ButtonHandler;
import start.startButton;

public class MainMenu extends BasicGameState {


	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		ButtonHandler.addButton(new startButton(200,200,200,50));
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Application.BHandler.render(g, gc,sbg);
		
	}


	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		Application.BHandler.update(gc);
		
	}

	public int getID() {
		// TODO Auto-generated method stub
		return Application.MAINMENU;
	}

}
