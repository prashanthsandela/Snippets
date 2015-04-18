

import java.io.BufferedReader;
import java.io.IOException;

public class WordCount {
	
	private static String file_name = "D:\\generated_data.txt";
	private static String regEx_delimiter = "\n";
	
	public static void main(String args[]) throws IOException
	{
		test_word_count();
	}
	
	private static void wordCount() throws IOException
	{
		BufferedReader br = General.readStream(file_name);
		String line = null;
		
		double wordCount = 0;
		
		while ( (line = br.readLine()) != null)
		{
			wordCount += line.trim().split(regEx_delimiter).length;
		}
		
		System.out.println("Total Word Count = " + wordCount);
	}
	
	private static void test_word_count()
	{
		String test = "Hai this is Prashanth. What are you doing?";
		
		int wordCount = test.trim().split(regEx_delimiter).length;
		String[] str = test.trim().split(regEx_delimiter);

		for(String s: str)
		System.out.println(s);

		System.out.println("Total Test Word Count = " + wordCount);
	}
}
