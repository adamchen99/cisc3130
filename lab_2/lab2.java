
package Lab2;

import java.io.*;

import java.util.Collections;

import java.util.HashSet;

import java.util.Set;

import java.util.ArrayList;

public class Lab2 {

	public static void main(String[] args) throws FileNotFoundException {

			//Store Names
		ArrayList Names= new ArrayList();

			//For reading name and puting into array
		String line = "";
			//For putting number of time the artist appear

		ArrayList<Integer>  number = new ArrayList();
			//Created a path for bufferedreader
		
		String path = "C:\\Users\\adamc\\Desktop\\Java3130\\regional-global-daily-latest.csv";
			
			//path to new note file with writer
		File write = new File("C:\\Users\\adamc\\Desktop\\Java3130\\Lists.txt");
		PrintWriter printwriter = new PrintWriter(write);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
					//This code read which col is the name
				//System.out.println(values[2]);
					//Add the col that has name into the arraylist
				Names.add(values[2]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(Names);
			
		
		Set<String> unique = new HashSet<String>(Names);
		
		for (String key : unique) {
		    //System.out.println(key + ": " + Collections.frequency(Names, key));
		    printwriter.println(key + ": " + Collections.frequency(Names, key));
		}
		
		printwriter.close();
		
		
	}
}
