

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class General {
	public static void createFile(String filename, String string, Boolean append)
	{
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(filename, append ? true : false));
			bw.write(string);
			System.out.println("File Written: " + filename);
		} catch (Exception e) {
			System.out.println("Error in 3: " + e);
		}
		finally
		{
		    try
		    {
		        if ( bw != null)
		        	bw.close( );
		    }
		    catch ( IOException e)
		    {
		    	System.out.println("Error in 4: " + e);
		    }
		}
	}
	
	public static BufferedReader readStream(String filename) throws UnsupportedEncodingException, FileNotFoundException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
		return br;
	}
	
	public static String getTime(){
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss SSS");
		return ft.format(dNow);
	}
	
	public static String getMemory()
    {
		HashMap<String, Double> hm = new HashMap<String, Double>();
        Runtime runtime = Runtime.getRuntime();
        hm.put("\nTotal Memory = ", (double) runtime.totalMemory()/(1024*1024));
        hm.put("\nFree Memory = ", (double) runtime.freeMemory()/(1024*1024));
        hm.put("\nUsedup Memory = ", (double) (runtime.totalMemory() - runtime.freeMemory())/(1024*1024));
        return hm.toString();
    }
	
	public static ArrayList<String> get_files_from_directory(String folder_path)
	{
		File folder = new File(folder_path);
		File[] listOfFiles = folder.listFiles();
		
		ArrayList<String> files = new ArrayList<String>();
		
	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	    	  files.add(listOfFiles[i].getName());
	      }
	    }
	    
		return files;
	}
	
	public static String md5(String s)
	{
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        md.update(s.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
    	return sb.toString();
	}
	
	/**
	 * Gets data from URL
	 * @param url
	 * @return BufferedReader
	 */
	public static BufferedReader readurl(String url)
	{
		BufferedReader in = null;
		URL urlElement;
		try {
			urlElement = new URL(url);
		
        in = new BufferedReader(
        		new InputStreamReader(urlElement.openStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return in;
	}
	
	/**
	 * Converts BufferedReader to String
	 * @param br
	 * @return String
	 */
	public static String br_toString(BufferedReader br)
	{
		String line = "";
		StringBuffer data = new StringBuffer();
		
		try {
			while( (line = br.readLine()) != null)
			{
				data.append(line.trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data.toString();
		
	}
	
}