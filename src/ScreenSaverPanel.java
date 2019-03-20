/* Screen Saver Assignment
 * Author: Jessica Murray
 * A screen saver application that simulates a screen saver. 
 * The application contains at least four moving shapes, including one irregular shape.
 * The application demonstrates a variety of at least four unique visual state changes.
 * Additional shapes may be added to the panel at run time with a button.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import javax.swing.JPanel;

public class ScreenSaverPanel extends JPanel {

	/* Create the panel. */	
	
	// Controller for application 
	private Controller controller = new Controller(); //Application has a controller 
	private JButton btnAddShape;
	
	// Timer
	private final int animationDelay = 5;
	Timer animationTimer = new Timer(animationDelay, new TimerHandler());
	
	public ScreenSaverPanel() {
		setLayout(null);
		btnAddShape = new JButton("Add Shape");
		btnAddShape.setBounds(139, 11, 144, 23);
		
		// Adds a new random shape to ArrayList when button is pressed
		btnAddShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				controller.newShape(); 
			}
		});
		setLayout(null);
		add(btnAddShape);
		
		animationTimer.start();

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); // Prevents anomalies
		this.setBackground(Color.BLACK);
		
		// Run through list of shapes and draw them
		for (int i=0; i< controller.getShapes().size(); i++)
		{
			controller.getShapes().get(i).draw(this, g);
		}
	}
	
	private class TimerHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent actionEvent){
			repaint(); //call paintComponent
		}
	}

}
