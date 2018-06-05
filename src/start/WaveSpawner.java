package start;

import java.util.Random;

import entities.Astroid;

public class WaveSpawner {
	
	public int wave = 1;
	public static int amountToSpawn = 5;
	public static int amountLeft = amountToSpawn;
	
	private Random r = new Random();
	
	public WaveSpawner()
	{
			for(int i = 0; i < amountToSpawn; i++)
			{
				Handler.addObject(new Astroid(0,0,64,64,"Astroid"));
			}
		
	}
	
	public void spawn()
	{
		if(amountLeft == 0)
		{
			for(int i = 0; i < amountToSpawn; i++)
			{
				Handler.addObject(new Astroid(0,0,64,64,"Astroid"));
			}
			
			amountLeft = amountToSpawn;
			amountToSpawn += 2;
			
		}
	}

}
