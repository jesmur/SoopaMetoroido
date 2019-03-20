import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.nio.file.Path;

import javax.swing.JPanel;

public class Polygon extends Shape{
	public Polygon(int xVel, int yVel, Color c)
	{
		super(xVel, yVel, c, false, false);
	}
	
	// Coordinates of star points
	int xPoints[] = {55,67,109,73,83,55,27,37,1,43}; 
	int yPoints[] = {0,36,36,54,96,72,96,54,36,36};
	
	public void draw(JPanel p, Graphics g){	
		
		Graphics2D g2d = (Graphics2D) g;
		
		// Create star
		GeneralPath star = new GeneralPath();
		star.moveTo(xPoints[0], yPoints[0]);
		
		for (int i = 1; i < xPoints.length; i++){
			star.lineTo(xPoints[i], yPoints[i]);
		}
		
		star.closePath();
		
		//Pattern for star
		BufferedImage buffImage = new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
		Graphics2D gg = buffImage.createGraphics();
		gg.setColor(Color.YELLOW);
		gg.fillRect(5, 5, 10, 10);
		gg.setColor(Color.GREEN);
		gg.drawRect(1, 1, 6, 6);
		gg.setColor(Color.BLUE);
		gg.fillRect(1, 1, 6, 6);
		gg.setColor(Color.RED);
		gg.fillRect(4, 4, 3, 3);
		
		g2d.setPaint(new TexturePaint(buffImage, new Rectangle(10,10)));
		g2d.fill(star);
		
		//Collision for star - move from coordinates
		for (int i = 0; i<xPoints.length; i++){
			xPoints[i] += xVel;
			yPoints[i] += yVel;
		}
		
		for (int i = 0; i< xPoints.length; i++){	
			
			//Check X coordinate boundaries
			if (!reverseX){	
				if (xPoints[i]> p.getWidth()){
					xVel = -xVel;
					reverseX = true;
				}
			}
			
			if (reverseX){	
				if (xPoints[i] < 0){
					xVel = -xVel;
					reverseX = false;
				}
			}
				
			//Check Y coordinate boundaries
			if (!reverseY){	
				if (yPoints[i]> p.getHeight()){
					yVel = -yVel;
					reverseY = true;
				}
			}
			
			if (reverseY){	
				if (yPoints[i] < 0){
					yVel = -yVel;
					reverseY = false;
				}
			}
		}
	}
}