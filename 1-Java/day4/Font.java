import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;


public class Fonts extends Applet
{
	public void paint(Graphics g)
	{
	
		Toolkit t = Toolkit.getDefaultToolkit();
		String [] names = t.getFontList();
		int y=0;
		for(int i =0 ; i< names.length ; i++)
		{
		Font f = new Font(names[i] , Font.BOLD, 20);
		g.setFont(f);
		g.drawString(names[i], 50 , y);
		y+=25;

		}

	}


}
