package start;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import states.Game;
import states.GameOver;
import states.MainMenu;
import states.Splash;

public class Application extends StateBasedGame {
	
	//Game state prop.
	public static final int GAME       = 0;
	public static final int MAINMENU   = 1;
	public static final int SPLASH     = 2;
	public static final int GameOver   = 3;
	
	//Game Objects
	public static Handler Handler = new Handler();
	public static debug debug = new debug(0,0,720,100);
	public static AudioManager AudioManager = new AudioManager();
	public static ButtonHandler BHandler = new ButtonHandler();
	
	//Application prop.
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	public static final int FPS = 60;
	public static final double VERSION = 1.0;
	public static boolean DEBUGMODE = false;
	
	
	

	public Application(String name) {
		super(name);
	
	
		
	}
	


	public void initStatesList(GameContainer gc) throws SlickException {
		
		gc.setVSync(true);
		
		this.addState(new Splash());
		debug.Log("Added Splash Screen");
		this.addState(new Game());
		debug.Log("Added Game State");
		this.addState(new MainMenu());
		debug.Log("Added MainMenu State");
		this.addState(new GameOver());
		debug.Log("Added GameOver State");
		debug.Log("Game Started");
		
		
		this.enterState(MAINMENU);
		debug.Log("Game State: " + this.getCurrentStateID());

	}
	
	public static void main(String args[])
	{
		try {
			AppGameContainer app = new AppGameContainer(new Application("Glade 2 v"+VERSION));
			app.setDisplayMode(WIDTH, HEIGHT, false);
			app.setTargetFrameRate(FPS);
			app.setShowFPS(false);
			app.start();
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
