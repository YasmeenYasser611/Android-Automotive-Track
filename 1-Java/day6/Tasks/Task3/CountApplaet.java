

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class CountApplaet extends Applet implements Runnable 
{
	 int counter=0;
	private Button btnIncremant;
	private Button btnDecrement;
	private int x ;
	private int y;
	private boolean direction;
	private Thread th = null;
	
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
	
	
	
	public void init()
	{
	direction = true;


	
        //Thread th = new Thread(this );
        
	btnIncremant = new Button("Start");
	btnDecrement = new Button("Pause");
	
	btnIncremant.addActionListener(new  ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	if(th == null)
	{
	th = new Thread(CountApplaet.this );
	th.start();
	
	}
	else
	{
	th.resume();
	}
	
	repaint();
	}
	});
	
	btnDecrement.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	th.suspend();
	repaint();
	}
	});
	
	add(btnIncremant);
	add(btnDecrement);
	
	
	
	
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
		
	g.fillOval(x, getHeight()/2, 50, 50);
		
	}

	
	


}
