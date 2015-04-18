

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MergeFiles {
	public static String input_folder = "C:\\Users\\Prashanth\\Desktop\\Vimal\\docs\\";
	public static String output_folder = "C:\\Users\\Prashanth\\Desktop\\Vimal\\merge\\all.txt";
	
	public static void main(String args[]) throws IOException
	{
		ArrayList<String> files_list = General.get_files_from_directory(input_folder);
		
		HashMap<String, String> hm = new HashMap<String, String>();
		StringBuilder data = new StringBuilder();
		int files_count = 1;
		General.createFile(output_folder, data.toString(), false);
		
		for(String s: files_list)
		{
			// Open each file
			BufferedReader br = General.readStream(input_folder + s);
			StringBuilder file_data = new StringBuilder();
			String line = "";
			while ( (line = br.readLine()) != null)
			{
				line = line.trim();
				file_data.append(line + " ");
			}
//			System.out.println("Running file: " + files_count);
			
			String file_d = file_data.toString();
			String md5 = General.md5(file_d);
			
			if(hm.get(md5) == null){
				hm.put(md5, md5);
				if( file_d != null)
					data.append( files_count + "," +
						file_d
						.replaceAll("[^A-z ]", " ")
						.replaceAll(" +", " ")
						.trim()
						+ "\r\n"
						);
			} else {
				files_count--;
			}
			
			if(files_count % 100 == 0)
			{
				System.out.println("Running file: " + files_count);
				General.createFile(output_folder, data.toString(), true);
				data = new StringBuilder();
			}
			files_count++;
		}
		
		General.createFile(output_folder, data.toString(), true);
		System.out.println("Done");
		
		
	}
	
	
	
}
