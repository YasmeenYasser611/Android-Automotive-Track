import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;


public class Fonts extends Applet
{
	public String [] names ;
	
	public void init()
	{
		Toolkit t = Toolkit.getDefaultToolkit();
		names = t.getFontList();
	}
	public void paint(Graphics g)
	{
	

		int y=50;
		for(int i =0 ; i< names.length ; i++)
		{
		//Font f = new Font( names[i] , Font.PLAIN, 10);
		g.setFont(new Font( names[i] , Font.PLAIN, 20));
		g.drawString(names[i], 50 , y);
		y+=25;

		}

	}


}
