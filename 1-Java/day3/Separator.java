
public class Separator
{
	public static void main(String[] args)
	{
		if (args.length == 2 ) 
		{
			String input = args[1];
			int num=Integer.parseInt(args[0]);
			String [] arr = new String[num] ;
			int aryindex=0;
			int index=0;
			int start=0;
			
			while(index != -1)
			{
			index = input.indexOf('.',start);
			if(index == -1)
			{
             	        arr[aryindex] = input.substring(start);
			}
			else
			{
			arr[aryindex] = input.substring(start, index);
			start = index + 1;
			}
			aryindex++;
			
			}
			
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




