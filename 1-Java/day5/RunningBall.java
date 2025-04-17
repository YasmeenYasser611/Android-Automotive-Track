import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;
import java.awt.Color;

public class RunningBall extends Applet implements Runnable 
{
	private int x ;
	private int y;
	private boolean direction;
	
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
	public void paint(Graphics g)
	{
		Color c = new Color(255 , 51 , 255 );
		g.setColor(c);
		
		if((x< getWidth() && direction == true))
		{
		x+=50;
		
		}
		else if(x== getWidth() )
		{
		direction = false;
		x-=50;
		
		}
		else if((x >= 0  && direction == false))
		{
		
		x-=50;
		if(x==0)
		{
		direction = true;
		}
		}
	
		g.fillOval(x, y, 50, 50);


		
	}
	public void init()
	{
	direction = true;
	Thread th = new Thread(this );
	th.start();
	}


}
