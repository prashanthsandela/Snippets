

import java.io.BufferedReader;
import java.io.IOException;

public class LineCount {
	private static String file_name = "generated_data.txt";
	
	public static void main(String args[]) throws IOException
	{
		
		System.out.println("Started");
		
		BufferedReader br = General.readStream(file_name);
		
		String line = null;
		double i = 0;
		
		while( (line = br.readLine()) != null)
		{
			i++;
			if(i % 100000 == 0)
				System.out.println("Lines Read: " + i);
		}
		
		System.out.println("Line Count = " + i);
	}
}
