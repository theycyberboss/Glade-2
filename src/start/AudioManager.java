package start;

import java.util.HashMap;

import org.newdawn.slick.Sound;

public class AudioManager {
	
	private static HashMap<String, Sound> audioMap = new HashMap<String, Sound> ();
	
	public AudioManager()
	{
		
	}
	
	public static void addFile(String name, Sound sound)
	{
		audioMap.put(name, sound);
		debug.Log("Sound File Loaded: " + sound);
	}
	
	public static Sound getFile(String name)
	{
		return audioMap.get(name);
	}

}
