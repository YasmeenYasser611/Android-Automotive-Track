import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;


//test local inner class

public class RunningString extends Applet 
{
	private int x ;
	

	public void paint(Graphics g)
	{
		
		
		if(x< getWidth())
		{
		x++;
		g.drawString("o", x , getHeight()/2 - 2);
		g.drawString("|", x , getHeight()/2 +1);
		g.drawString("^", x , 
		()/2 +11);
		
		
		}
		else
		{
		x=0;
		
		}
		
	}

	public void init()
	{

	
	new Thread ()
	{
	public void run()
	{
		while(true)
		{
			repaint();
			try
			{
			Thread.sleep(50);
			}catch(InterruptedException ex)
			{
			ex.printStackTrace();
			}
		}
	}
	}.start();
	
	}


}

