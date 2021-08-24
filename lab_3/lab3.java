package Lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class Lab3 {
	public static void main(String[] args) throws FileNotFoundException {
		TopStreamingArtists artistNames = new TopStreamingArtists();
		
		ArrayList names = new ArrayList();
			
		String line = "";

		String path = "C:\\Users\\adamc\\Desktop\\Java3130\\regional-global-daily-latest.csv";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				artistNames.insert(values[2]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//this code sort the linkedlist
		Collections.sort(artistNames);
		
		//this print the list
		artistNames.print();
		
	}
}

class Artist {
    String name;
    Artist next;
    
    	public Artist() {
    		this.name = name;
    		this.next = next;
    	}
 }

class TopStreamingArtists {
    private Artist first;
    
    public void TopStreamingArtists(){
      first = null;
    }
    public boolean isEmpty(){
     return (first == null);
    }
    
    public void insert(String name) {
    	Artist artist = new Artist();
    	artist.name = name;
    	artist.next = null;
    	
    		if(first==null) {
    			first = artist;
    		}
    		else {
    			Artist n = first;
    				while(n.next != null) {
    					n = n.next;
    				}
    				n.next = artist;
    		}
    }
    
    public void print() {
    	Artist artist = first;
    		while(artist.next != null) {
    			System.out.println(artist.name);
    			artist = artist.next;
    		}
    	System.out.println(artist.name);
    }
 }
