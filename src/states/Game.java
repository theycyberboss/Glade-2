package states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.Astroid;
import entities.Ship1;
import start.Application;
import start.AudioManager;
import start.Handler;
import start.Hud;
import start.WaveSpawner;
import start.debug;

public class Game extends BasicGameState {

	
	public static int SCORE = 0;
	public static int LIVES = 3;
	public static int IRON = 0;
	public static boolean GAMEOVER = false;
	
	private Image background;

	Hud hud;
	WaveSpawner waveSpawner;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		hud = new Hud();
		waveSpawner = new WaveSpawner();
		background = new Image("Res/images/space.png");
		
		//Handler.addObject(new Ship1(100,100, 64, 64));
	
	
		
		Ship1 player = new Ship1(Application.WIDTH/2,Application.HEIGHT/2,64,64,"ship");

		Handler.addObject(player);
		Handler.addObject(new Astroid(100,100,64,64,"astroid"));
		
		AudioManager.addFile("Song1", new Sound("Res/music/NightOfDizzy.wav"));
		AudioManager.addFile("Song2", new Sound("Res/music/AllOfUs.wav"));
		AudioManager.addFile("Song3", new Sound("Res/music/ChibiNinja.wav"));
		
		AudioManager.getFile("Song3").loop(1.0f, .2f);
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.drawImage(background,-300,-180,-150,-150,Application.WIDTH,Application.HEIGHT);
		
		Application.debug.render(g,gc);
		Application.Handler.render(g);
		
		hud.render(g, gc);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Application.Handler.update(gc, delta);	
		
		hud.update(gc, delta);
		
		if(GAMEOVER)
		{
			sbg.enterState(Application.GameOver);
			debug.Log("Game State: " + sbg.getCurrentStateID());
		}
		
		
		waveSpawner.spawn();
		//handle debug and Application input
		
		if(gc.getInput().isKeyPressed(Input.KEY_F5))
		{
			if(Application.debug.isVisible())
			{
				Application.debug.setVisible(false);
				Application.DEBUGMODE = false;
			}else {
				Application.debug.setVisible(true);
				Application.DEBUGMODE = true;
			}
		}
		
		
		
		
		if(gc.getInput().isKeyPressed(Input.KEY_P))
		{
			if(gc.isFullscreen())
			{
				gc.setFullscreen(false);
				
			}else {
				gc.setFullscreen(true);
				
			}
		}
	}

	@Override
	public int getID() {

		return Application.GAME;
	}

}
