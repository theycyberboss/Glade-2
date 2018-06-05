package componenets;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import start.debug;

public class Texture {
	
	public Image img;
	
	public Texture(String path)
	{
		try {
			img = new Image(path);
			debug.Log("Image Loaded: " + img);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
