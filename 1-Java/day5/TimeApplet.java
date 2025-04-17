import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class TimeApplet extends Applet implements Runnable 
{
	public void run()
	{
		while(true)
		{
			repaint();
			try
			{
			Thread.sleep(1000);
			}catch(InterruptedException ex)
			{
			ex.printStackTrace();
			}
		}
	}
	public void paint(Graphics g)
	{
		
		Date d =new Date();
		g.drawString(d.toString(), getWidth()/2 , getHeight()/2);
		
	}
	public void init()
	{
	Thread th = new Thread(this );
	th.start();
	}


}
