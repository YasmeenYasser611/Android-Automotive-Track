public class Star
{
	public static void main(String[] args)
	{
		if (args.length == 1 ) 
		{
			int num=Integer.parseInt(args[0]);
			
			for(int i= 1 ; i<= num  ; i++)
			{
				for(int j=0 ; j< 2*num   ; j++)
				{
				if(j<i)
					System.out.print("*");
				else 
					System.out.print("");
				}
	                     
				for(int j=3*num-1  ; j>=0 ; j--)
				{
				
				if( j< 2*i-1)
				{
				if(j %2 ==0)
					System.out.print("*");
				else
					System.out.print(" ");
				}
				else
					System.out.print(" ");
				
			 	}	

				
				

				System.out.println();
			}
                	
                } 
                else 
                {
                 	System.out.println("WRONG INPUT !!!!! ");
                	
                }
	}

}



	
	
	

