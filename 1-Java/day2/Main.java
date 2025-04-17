abstract class GeoShapes 
{
    protected int dim1;
    protected int dim2;

    GeoShapes(int d1, int d2) 
    {
        this.dim1 = d1;
        this.dim2 = d2;
    }

    public abstract double CalcArea();
}

class Rect extends GeoShapes 
{
    Rect(int d1, int d2) 
    {
        super(d1, d2);
    }

    public double CalcArea() 
    {
        return dim1 * dim2;
    }
}

class Circle extends GeoShapes 
{
    private int radius;

    Circle(int r) 
    {
        super(r, r);
        this.radius = r;
    }

    public double CalcArea() 
    {
        return 3.14 * radius * radius;
    }
}

class Triangle extends GeoShapes 
{
    Triangle(int h, int w) 
    {
        super(h, w);
    }

    public double CalcArea() 
    {
        return 0.5 * dim1 * dim2;
    }
}

class CalcArea 
{
    public static double SumArea(GeoShapes s1, GeoShapes s2, GeoShapes s3) 
    {
        return s1.CalcArea() + s2.CalcArea() + s3.CalcArea();
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Rect r = new Rect(2, 2);
        Triangle t = new Triangle(2, 2);
        Circle c = new Circle(2);

        double rArea = r.CalcArea();
        double tArea = t.CalcArea();
        double cArea = c.CalcArea();
        double Total = CalcArea.SumArea(r, t, c);

        System.out.println("Rectangle Area: " + rArea);
        System.out.println("Triangle Area: " + tArea);
        System.out.println("Circle Area: " + cArea);
   	System.out.println("Total Area: " + Total);

	Total = CalcArea.SumArea( t, c , r);

        System.out.println("Total Area: " + Total);

    }
}

