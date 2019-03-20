import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Controller {
	
	// Generating random values
	private Random myRandom = new Random();
	
	// Array holding all available colors 
	private Color colorArray[] = {Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.ORANGE};
	
	// Roll for a random color
	public Color randColor(){
		return colorArray[myRandom.nextInt(colorArray.length)];
	}
	
	// Getters and setters for ArrayList
	public ArrayList<Shape> getShapes(){
		return Shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		Shapes = shapes;
	}
	
	// ArrayList containing all shapes added via button
	private ArrayList <Shape> Shapes = new ArrayList<Shape>();

	// Randomly determines which shape will be created
	public void newShape(){
		
		int randomShape = myRandom.nextInt(4);
		
		switch (randomShape){
			case 0:
				Shapes.add(createLine());
				break;
			
			case 1:
				Shapes.add(createRect());
				break;
			
			case 2:
				Shapes.add(createOval());
				break;
			
			case 3:
				Shapes.add(createPolygon());
				break;		
		}
	}
	
	// Create a new shape via upcasting
	public Shape createLine(){
		Shape pLine = (Shape) new Line(0, 0, 40, 40, 1, 1, randColor());
		return pLine;
	}
	public Shape createRect(){
		Shape pRect = (Shape) new Rectangle(50, 50, 50, 50, 1, 1, randColor());
		return pRect;
	}
	public Shape createOval(){
		Shape pOval = (Shape) new Oval(200, 50, 50, 50, 3, 3, randColor());
		return pOval;
	}
	public Shape createPolygon(){
		Shape pPolygon = (Shape) new Polygon(1, 1, randColor());
		return pPolygon;
	}
}