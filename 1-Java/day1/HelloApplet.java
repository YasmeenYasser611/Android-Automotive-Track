import java.applet.Applet;
import java.awt.Graphics;
public class HelloApplet extends Applet
{
	public void paint(Graphics g)
	{
		g.drawString("Yasmeen Say HIII!!!", 50 , 100);
		String name = getParameter("Name");
		System.out.println( name );

	}


}
