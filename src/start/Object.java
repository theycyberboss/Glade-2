package start;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import componenets.Position;
import componenets.Texture;

public abstract class Object {
	
	protected Position position;
	protected Texture texture;
	protected String ID = "";
	private Rectangle bounds;
	
	
	public Object(float x, float y, float width, float height, String ID)
	{
		position = new Position(x,y,width, height, 0);
		texture = null;
		this.ID = ID;
		bounds = new Rectangle(x,y,width,height);
		bounds.setCenterX(x - position.width/2);
		bounds.setCenterY(y - position.height/2);
		
	}
	
	public void setTexture(String path)
	{
		texture = new Texture(path);
	}
	
	public Image getTexture()
	{
		if(texture.img != null)
		{
			return texture.img;
		}else {
			return null;
		}
	}
	
	
	
	public float pointDirection(float x1, float y1, float x2, float y2)
	{
		double angle = Math.atan2(y2 - y1, x2 - x1);
		
	float rotation = (float) Math.toDegrees(angle);
	return rotation;
	} 
	
	public float moveAngleX(float speed, float angle)
	{
		return (float) Math.cos(Math.toRadians(angle)) * speed;
	}
	public float moveAngleY(float speed, float angle)
	{
		return (float) Math.sin(Math.toRadians(angle)) * speed;
	}
	
	public abstract void update(GameContainer gc, int delta);
	public abstract void render(Graphics g);

	public Shape getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
}
