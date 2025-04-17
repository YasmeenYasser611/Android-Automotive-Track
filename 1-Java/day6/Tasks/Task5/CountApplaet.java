
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class CountApplaet extends Applet 
{

	private int x1start=-1 ;
	private int y1end =-1;
	private int x2start=-1 ;
	private int y2end =-1;

	

	
	
	public void init()
	{


	addMouseListener(new MouseAdapter() 
	{
           
             	public void mousePressed(MouseEvent e) {
                x1start = e.getX() ; 
                y1end = e.getY() ;
                //repaint();
                
            }
            
               public void  mouseReleased(MouseEvent e) {
                x2start = e.getX() ; 
                y2end = e.getY();
                repaint();
            }
        });
        

	addMouseMotionListener(new MouseMotionAdapter() {
            
            public void mouseDragged(MouseEvent e) {
               
                x2start = e.getX() ; 
                y2end = e.getY();
                repaint();
            }
        });
	
	
	
	}



	public void paint(Graphics g)
	{
	if (x1start != -1 && y1end != -1 && x2start != -1 && y2end != -1) {
            g.drawLine(x1start, y1end, x2start, y2end);
        }
	
		
	}

	
	


}


