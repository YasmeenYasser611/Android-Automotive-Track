class Main
{
	public static void main(String[] args)
	{
		Integer i = new Integer(5);
		System.out.println("i="+ i );
		int i_prem = i.intValue();
		System.out.println("i="+ i );

		i_prem =i; //outo outboxing
		System.out.println("i="+ i );

		i=10; //auto inboxing = auto boxing
		System.out.println("i="+ i );

		double d= 0.5 ; // if float error the defult os double, 0.5F is float
		double n=0.0;

		System.out.println(d/n ); //Infinity , -Infinity . NaN(NOT A NUMBER)
					  
		System.out.println(i instanceof Integer );




	}
}
