import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class Shape {
	
	protected int x1;
	protected int y1;
	protected int x2;
	protected int y2;
	protected int xVel;
	protected int yVel;
	protected Color c;
	protected boolean reverseX;
	protected boolean reverseY;

	public Shape(int x1, int y1,int x2, int y2, int xVel, int yVel, Color c, boolean reverseX, boolean reverseY){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.xVel = xVel;
		this.yVel = yVel;
		this.c = c;
		this.reverseX = false;
		this.reverseY = false;
	}
	
	//Overload specific to polygon
	public Shape(int xVel, int yVel, Color c, boolean reverseX, boolean reverseY){
		this.xVel = xVel;
		this.yVel = yVel;
		this.c = c;
		this.reverseX = false;
		this.reverseY = false;
	}
	
	//Abstract method for implementation
	public abstract void draw(JPanel p, Graphics g);
}