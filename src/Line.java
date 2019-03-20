import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class Line extends Shape{
	
	public Line(int x1, int y1, int x2, int y2, int xVel, int yVel, Color c){
		super(x1, y1, x2, y2, xVel, yVel, c, false, false);
	}

	@Override
	public void draw(JPanel p, Graphics g){	
		//Pattern for ball
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(new GradientPaint(50, 50, c, 150, 150, Color.WHITE, true));
		g2d.fill(new Ellipse2D.Double(x1, y1, x2, y2));
		
		//Check X coordinate boundaries
		if (!reverseX){
			x1 += xVel;
			if (x1 + x2 > p.getWidth()){
				reverseX = true;
			}
		}
		
		if (reverseX){
			x1 -= xVel;
			if (x1 < 0){
				reverseX = false;
			}
		}
		
		//Check Y coordinate boundaries
		if (!reverseY){
			y1 += yVel;
			if (y1 + y2 > p.getHeight()){
				reverseY = true;
			}
		}
		
		if (reverseY){
			y1 -= yVel;
			if (y1 < 0){
				reverseY = false;
			}
		}
	}
}