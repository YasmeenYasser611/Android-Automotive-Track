
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class CountApplaet extends Applet implements Runnable 
{

	private int x = getWidth()/2;
	private int y= getHeight()/2;
	private boolean running = true;
	
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
	
        Thread th = new Thread(this );
        th.start();

	
	addMouseMotionListener(new MouseAdapter() 
	{
           
            public void mouseDragged(MouseEvent e) {
                x = e.getX() - 25; 
                y = e.getY() - 25;
                repaint();
            }
        });
	
	
	
	
	}



	public void paint(Graphics g)
	{
	Color c = new Color(255 , 51 , 255 );
	g.setColor(c);
	g.fillOval(x, y, 50, 50);
		
	}

	
	


}


