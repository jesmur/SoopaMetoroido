import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Oval extends Shape{

	public Oval(int x1, int y1, int x2, int y2, int xVel, int yVel, Color c){
		super(x1, y1, x2, y2, xVel, yVel, c, false, false);
	}

	@Override
	public void draw(JPanel p, Graphics g){
		g.setColor(c);
		g.fillOval(x1, y1, x2, y2);
		
		//Check X coordinate boundaries
		if (!reverseX){
			x1 += xVel;
			if (x1 + x2 > p.getWidth()){
				reverseX = true;
				g.fillOval(x1, y1, x2 -= 30, y2);
			}
		}
		
		if (reverseX){
			x1 -= xVel;
			if (x1 < 0){
				reverseX = false;
				g.fillOval(x1, y1, x2 += 30, y2);
			}
		}
		
		//Check Y coordinate boundaries
		if (!reverseY){
			y1 += yVel;
			if (y1 + y2 > p.getHeight()){
				reverseY = true;
				g.fillOval(x1, y1, x2, y2 += 30);
			}
		}
		
		if (reverseY){
			y1 -= yVel;
			if (y1 < 0){
				reverseY = false;
				g.fillOval(x1, y1, x2, y2 -= 30);
			}
		}

	}

}//end oval