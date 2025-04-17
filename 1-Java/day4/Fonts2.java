import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;

public class Fonts2 extends Applet
{
	public String [] names ;
	
	public void init()
	{
		//Toolkit t = Toolkit.getDefaultToolkit();
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		names = env.getAvailableFontFamilyNames();
	}
	
	public void paint(Graphics g)
	{
	
		int y=50;
		for(int i =0 ; i< names.length ; i++)
		{
		Font f = new Font( names[i] , Font.BOLD, 20);
		System.out.println(names[i]);
		g.setFont(f);
		g.drawString(names[i], 50 , y);
		y+=25;

		}

	}


}
