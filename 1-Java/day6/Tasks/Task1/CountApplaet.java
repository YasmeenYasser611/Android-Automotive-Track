
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.applet.Applet;
import java.awt.Graphics;

public class CountApplaet extends Applet 
{
	 int counter=0;
	private Button btnIncremant;
	private Button btnDecrement;
	
	
	public void init()
	{

	btnIncremant = new Button("+");
	btnDecrement = new Button("-");
	
	IncrementListener INCListener = new IncrementListener();
	btnIncremant.addActionListener(INCListener);
	
	btnDecrement.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	counter--;
	if(counter < 0)
		counter =0;
	repaint();
	}
	});
	
	add(btnIncremant);
	add(btnDecrement);
	
	}

	public void paint(Graphics g)
	{
	g.drawString("count="+ counter , getWidth()/2 ,getHeight()/2 );
		
	}

	
	class IncrementListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e)
	{
	counter++;
	repaint();
	}
	}


}


