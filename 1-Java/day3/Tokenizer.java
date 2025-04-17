import java.util.StringTokenizer;

public class Tokenizer
{
	public static void main(String[] args)
	{
		if (args.length == 2 ) 
		{
			int num=Integer.parseInt(args[0]);
			

			String input = args[1];
			StringTokenizer st = new StringTokenizer(input, ".");
			
			while(st.hasMoreTokens() )
			{
			System.out.println(st.nextToken() + "\n") ;
			}
		
                } 
                else 
                {
                 	System.out.println("WRONG INPUT !!!!! ");
                	
                }
	}

}




