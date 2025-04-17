class Disc
{
	//instance member
	private int size;
	private int noOfPins;

	//class member or static member
	private static String name;
	public void setSize(int s)
	{
		size =s; //access instance member
		name="hamada"; //access class member , name exists one time and before object creation 
	}

	public static String getName()
	{
		//size =0; xxxx no size exist in this static 
		return name;
	}
	public static void setName(String n)
	{
		name = n;
		
	}



}

class Main
{
	public static void main(String [] args )
	{
		System.out.println(Disc.getName());

		Disc.setName("EZZ");
		Disc d1 = new Disc();
		Disc d2 =  new Disc();
		
		d1.setSize(5);
		System.out.println(d2.getName());


		d1.setName("EZZ -el dekhaila ");
		d2.setName("el-dekhaila");

		System.out.println(Disc.getName());
		System.out.println(d1.getName());

		System.out.println(d2.getName());


	}
}
