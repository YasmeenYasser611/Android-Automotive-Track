import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;

public class CountApplaet extends Applet 
{
    public class Line 
    {
        private int x1start, y1end, x2start, y2end;

        Line(int x1, int y1) 
        {
            x1start = x1;
            y1end = y1;
            x2start = x1;
            y2end = y1;
        }

        boolean isValid() 
        {
            return x1start != x2start || y1end != y2end;
        }
    }

    private ArrayList<Line> lines = new ArrayList<>(); 
    private Line currentLine = null;
    private boolean dragged = false;

    public void init() 
    {
        addMouseListener(new MouseAdapter() 
        {
            public void mousePressed(MouseEvent e) 
            {
                currentLine = new Line(e.getX(), e.getY());
                dragged = false;
            }

            public void mouseReleased(MouseEvent e) 
            {
                if (currentLine != null) 
                {
                    currentLine.x2start = e.getX();
                    currentLine.y2end = e.getY();

                    if (dragged && currentLine.isValid()) 
                    {
                        lines.add(currentLine);
                    }

                    currentLine = null;
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() 
        {
            public void mouseDragged(MouseEvent e) 
            {
                if (currentLine != null) {
                    currentLine.x2start = e.getX();
                    currentLine.y2end = e.getY();
                    dragged = true;
                    repaint();
                }
            }
        });
    }

    public void paint(Graphics g) 
    {
        for (Line line : lines) 
        {
            g.drawLine(line.x1start, line.y1end, line.x2start, line.y2end);
        }

        if (currentLine != null) 
        {
            g.drawLine(currentLine.x1start, currentLine.y1end, currentLine.x2start, currentLine.y2end);
        }
    }
}




