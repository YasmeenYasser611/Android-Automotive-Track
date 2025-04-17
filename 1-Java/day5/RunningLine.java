import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;
import java.awt.Color;

public class RunningLine extends Applet implements Runnable 
{
	private int x ;
	private int y;
	private boolean direction;
	private boolean up;
	
	public void run()
	{
		while(true)
		{
			repaint();
					if(x>=getWidth())
		{
		direction=false;
		}
		if(x<=0)
		{
		direction=true;
		}
		if(y>=getHeight())
		{
		up =true;
		}
		if(y<=0)
		{
		up =false;
		}
		
		if(direction == true)
		{
		x+=1;
		}
		else if (direction == false)
		{
		x-=1;
		}
		if(up == false)
		{
		y+=1;
		}
		else if (up == true)
		{
		y-=1;
		}
			try
			{
			Thread.sleep(1);
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
		
		

		

		g.fillOval(x, y, 50, 50);


		
	}
	public void init()
	{
	direction = true;
	up = false;
	x=0;
	y=getHeight() / 2;
	Thread th = new Thread(this );
	th.start();
	}


}


