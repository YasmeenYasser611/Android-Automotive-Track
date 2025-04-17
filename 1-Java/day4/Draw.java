import java.applet.Applet;
import java.awt.Graphics;

import java.awt.Color;


public class Draw extends Applet
{
	public void paint(Graphics g)
	{
	
		Color c = new Color(255 , 51 , 255 );
		g.setColor(c);
		g.fillOval(150, 175, 50, 150);
		g.fillOval(100, 180, 35, 120);
		g.fillOval(220, 180, 35, 120);
		
		
		g.fillOval(100, 100, 150, 50);
		
		
		g.setColor(Color.BLACK);
		g.drawArc(75, 250, 200, 100, 180, 180);
		
		g.drawLine(100, 125, 75, 300);
		g.drawLine(250, 125, 275, 300);
		
		
		g.drawRect(100, 450, 125, 50);
		
		g.drawLine(150, 350, 125, 450);
		g.drawLine(175, 350, 200, 450);
		


		
		


	}


}
