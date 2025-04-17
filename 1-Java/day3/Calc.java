

public class Calc
{
	public static void main(String[] args)
	{

		if (args.length == 3 ) 
		{
			int arg1 = Integer.parseInt(args[0]);
			int arg2 = Integer.parseInt(args[2]);
			String argu = args[1]; 
			int result=0;
			
			switch(argu)
			{
				case "+":
					result = arg1+arg2;
					System.out.println( args[0] + "+" + args[2] + "="+ result  );
					break;
				case "-":
					result = arg1-arg2;
					System.out.println( args[0] + "-" + args[2] + "="+ result  );
					break;
				case "x":
					result = arg1*arg2;
					System.out.println( args[0] + "*" + args[2] + "="+ result  );
					break;
				case "X":
					result = arg1*arg2;
					System.out.println( args[0] + "*" + args[2] + "="+ result  );
					break;
				case "/":
					if(arg2 == 0)
					{
					System.out.println( "Can not Divide by Zero!!!!" );
					}
					else
					{
					result = arg1/arg2;
					System.out.println( args[0] + "/" + args[2] + "="+ result  );
					
					}
					break;
				
				default : 
					System.out.println( "Wrong operation!!!!" );
					break;
					

					
			}
                	
                } 
                else 
                {
                
                	
                	System.out.println( "Wrong operation!!!!" );
                 	
                	
                }
	}

}
