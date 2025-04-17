package mypkg;

class Hello
{
	public static void main(String[] args)
	{
		//System.out.println("Hello , Yasmeen say Hiii!!!!!!!!");
		if (args.length > 0) 
		{
                	System.out.println(args[0]);
                } 
                else 
                {
                 	System.out.println("No argument provided!");
                	System.out.println("Hello , Yasmeen say Hiii!!!!!!!!");
                }
	}

}
