import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CountApplaet extends Applet 
{
    private int x, y; 

    public void init() 
    {
        x = getWidth() / 2;
        y = getHeight() / 2;

        addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent e) 
            {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP:
                        y -= 10; // Move up
                        break;
                    case KeyEvent.VK_DOWN:
                        y += 10; // Move down
                        break;
                    case KeyEvent.VK_LEFT:
                        x -= 10; // Move left
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += 10; // Move right
                        break;
                }
                repaint();
            }
        });

        setFocusable(true); 
    }

    public void paint(Graphics g) 
    {
        g.drawString("Java", x, y);
    }
}



