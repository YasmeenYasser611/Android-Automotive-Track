class Complex
{
	private int real;
	private int img;
	Complex(int r , int i)
	{
		this.real=r;
		this.img=i;
	}
	public void setReal(int r)
	{
		this.real=r;
	}
	public void setImg(int i)
	{
		this.img=i;
	}
	public int getReal()
	{
		return this.real;
	}
	public int getImg()
	{
		return this.img;
	}
	public void print()
	{
		/*if(this.img < 0 && this.real !=0 )
			System.out.println(this.real + this.img + "i" );
		else if(this.img > 0 && this.real !=0 )

			System.out.println(this.real +"+" + this.img + "i" );
		else if(this.img ==0 && this.real !=0 )
			System.out.println(this.real );
		else if(this.real ==0 && this.img != 0)
		{
			System.out.println(this.img + "i" );
		}*/
		if(img < 0){
			System.out.println("" + real + " " + img + "I");
		}
		else
			System.out.println("" + real + "+" + img + " I");
	}
	public static Complex sum(Complex c1 , Complex c2)
	{
		Complex res = new Complex(0,0);
		res.real = c1.real + c2.real;
		res.img=c1.img +c2.img;
		return res;
	}
	public static Complex abstr(Complex c1 , Complex c2)
	{

		Complex res= new Complex(0,0);
                res.real = c1.real - c2.real;
                res.img=c1.img - c2.img;
                return res;
	}
}

class Main
{
	public static void main(String [] args)
	{
		Complex c1 = new Complex(1,2);
		Complex c2 = new Complex(3,4);
		Complex add = new Complex(0,0);
		Complex sub= new Complex(0,0);
		c1.print();
		c2.print();

		add =Complex.sum(c1 , c2);
		add.print();
		sub = Complex.abstr(c1 , c2 );
		sub.print();

	}
}
