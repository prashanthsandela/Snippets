

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This program creates multiple copies of the file.
 * This will not stop execution. You have to manually stop it
 * @author Prashanth
 *
 */
public class GenerateData {
	public static void main(String args[]) throws IOException
	{
		System.out.println("Started");
		String file_input = "C:\\Users\\Prashanth\\Downloads\\Job_Title_Keywords0";
		String output_file = "D:\\generated_data.txt";
		StringBuilder sb = new StringBuilder();
		
		String line;
		
		BufferedReader br = General.readStream(file_input);
		
		while( (line = br.readLine()) != null)
		{
			sb.append(line + "\r\n");
		}
		
		line = sb.toString() + sb.toString() + sb.toString() + sb.toString() + sb.toString();
		
		int i = 0;
		while(true){
			i++;
			System.out.println("Written: " + i);
			General.createFile(output_file, line, true);
		}
		
	}
}
