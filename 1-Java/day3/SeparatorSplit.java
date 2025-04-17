
public class SeparatorSplit
{
	public static void main(String[] args)
	{
		if (args.length > 0 || args.length < 2 ) 
		{
			int num=Integer.parseInt(args[0]);
			
			//String regex = "\\.";
			String regex = "[.]";
			
			String input = args[1];
			
			String [] arr = new String[num] ;
		
			arr = input.split(regex);
	
			for(int iter =0 ; iter < arr.length ; iter++)
			{
			if(arr[iter] != null) 
			{
			System.out.println(arr[iter] + "\n") ;
			}
			else
				break;
			
			}
			

                	
                } 
                else 
                {
                 	System.out.println("WRONG INPUT !!!!! ");
                	
                }
	}

}




