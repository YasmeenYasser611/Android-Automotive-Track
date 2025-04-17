import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;


//test normal inner class

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
		g.drawString("^", x , getHeight()/2 +11);
		
		
		}
		else
		{
		x=0;
		
		}
		
	}
	Thread th =null;
	public void init()
	{
	myRunnable runnable = new myRunnable();
	th = new Thread(runnable );
	th.start();
	}

	//normal inner class
class myRunnable implements Runnable 
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
}

}

