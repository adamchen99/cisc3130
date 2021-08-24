package Lab5M;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Lab5.Song;
import Lab5.SongPlaylist;


public class Lab5M {
		   static SongPlaylist lst = new SongPlaylist();

		   public static void main(String[] args) throws IOException {
		       //Set to 500 just incase there a lot.
		       ArrayList<String> songList = new ArrayList<>();
		       songList.ensureCapacity(500);
		       ArrayList<String> artistList = new ArrayList<>(); 
		       artistList.ensureCapacity(500);
		       ArrayList<Integer> streamList = new ArrayList<>();
		       streamList.ensureCapacity(500);
		       
		       String path = ("C:\\Users\\adamc\\Desktop\\Java3130\\Lab5\\File\\regional-global-daily-1.csv");
				 //For reading name and puting into array
					String line = "";
					String line2 = "";
		       try {
					BufferedReader br = new BufferedReader(new FileReader(path));
					while((line = br.readLine()) != null) {
						//For this line, I had problem with value 3 which because I had to change it to parseInt but
						//on the top first value is not a nummber so I whole this code and maunal deleted the top value from the file
						//for some reason and unknown reason this always remove the top first line of the csv file
						for(int skip2 = 0; skip2<=0; skip2++) {
							String[] value1 = line.split(",");
							if(skip2==0) {
								while((line2 = br.readLine()) != null) {
								String[] values = line2.split(",");
								//This code read which col is the name
								//System.out.println(values[3]);
								//Add the col that has name into the arraylist
								songList.add(values[1]); //add track name into songlist
								artistList.add(values[2]); // add artist name to list
								streamList.add(Integer.parseInt(values[3]));
								}
							}	
						}
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				} 
		//File 2
		       String path1 = ("C:\\Users\\adamc\\Desktop\\Java3130\\Lab5\\File\\regional-global-daily-2.csv");
				 //For reading name and puting into array
					String line3 = "";
					String line4 = "";
		       try {
					BufferedReader br = new BufferedReader(new FileReader(path1));
					while((line3 = br.readLine()) != null) {
						//For this line, I had problem with value 3 which because I had to change it to parseInt but
						//on the top first value is not a nummber so I whole this code and maunal deleted the top value from the file
						//for some reason and unknown reason this always remove the top first line of the csv file
						for(int skip2 = 0; skip2<=0; skip2++) {
							String[] value1 = line3.split(",");
							if(skip2==0) {
								while((line4 = br.readLine()) != null) {
								String[] values = line4.split(",");
								//This code read which col is the name
								//System.out.println(values[3]);
								//Add the col that has name into the arraylist
								songList.add(values[1]); //add track name into songlist
								artistList.add(values[2]); // add artist name to list
								streamList.add(Integer.parseInt(values[3]));
								}
							}	
						}
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				} 
		       
		  //file 3
		       String path2 = ("C:\\Users\\adamc\\Desktop\\Java3130\\Lab5\\File\\regional-global-daily-3.csv");
				 //For reading name and puting into array
					String line5 = "";
					String line6 = "";
		       try {
					BufferedReader br = new BufferedReader(new FileReader(path2));
					while((line5 = br.readLine()) != null) {
						//For this line, I had problem with value 3 which because I had to change it to parseInt but
						//on the top first value is not a nummber so I whole this code and maunal deleted the top value from the file
						//for some reason and unknown reason this always remove the top first line of the csv file
						for(int skip2 = 0; skip2<=0; skip2++) {
							String[] value1 = line5.split(",");
							if(skip2==0) {
								while((line6 = br.readLine()) != null) {
								String[] values = line6.split(",");
								//This code read which col is the name
								//System.out.println(values[3]);
								//Add the col that has name into the arraylist
								songList.add(values[1]); //add track name into songlist
								artistList.add(values[2]); // add artist name to list
								streamList.add(Integer.parseInt(values[3]));
								}
							}	
						}
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
		       
//I know theres a more efficient way of read the csv file from a folder but I cant seem to make it work, I'll 
//research more later.
		     makeBST(songList, artistList, streamList); // make BST
		       lst.inorderTransversal();
		   }
		   
		   public static void makeBST(ArrayList<String> songLst, ArrayList<String> artistLst, ArrayList<Integer> streamLst) {
		       for (int i=0; i<songLst.size(); i++) {
		           Song artist = new Song(songLst.get(i), artistLst.get(i), streamLst.get(i)); 
		           lst.insert(artist);
		       }
		    
	}		   
} 

package Lab5;
//SongPlaylist
public class SongPlaylist{
	  public Song root;
	  
	  public SongPlaylist(){
	      root=null;
	      }
	   //BST is empty
	   public boolean isEmpty(){
	       return root == null;
	   }
	   
	//This code I took from online.
	   public void insert(Song obj){
		   	if(root==null) {
		   		root=obj;
	  	       }
	  	    else{
	  	    	Song current=root;
	  	    	Song parent;
	        while(true){
	            parent = current;
	               if (obj.songTitle.compareToIgnoreCase(current.songTitle) == 0){
	                   current.setArtistAverage(obj);
	                   return;
	               }
	               else if (obj.songTitle.compareToIgnoreCase(current.songTitle) < 0){
	                   current = current.left;
	                   if (current == null) {
	                       parent.left = obj;
	                       return;
	                   }
	               }
	               else {
	                   current = current.right;
	                   if (current == null){  
	                       parent.right = obj;
	                       return;
	                   }
	               }
	           }
	       }
	   }
	  
	   public void inorderTransversal(){
	       inorder(root);
	   }
	   
	   public void inorder(Song root){
	       if (root == null) {
	           return;
	       }
	       inorder(root.left);
	       System.out.println(root);
	       inorder(root.right);
	   }
	  
	   //subset
	   public void subset(String song1, String song2){
	       subset(root, song1, song2); 
	   }
	   
	   public Song subset(Song root, String song1, String song2){ 
	       if(root == null){
	           return root;
	       }
	  
	       Song current = root;
	       if(song1.compareTo(current.songTitle)<0){
	           subset(current.left, song1, song2);
	       }
	       if((song1.compareTo(current.songTitle)<=0) && (song2.compareTo(current.songTitle)>=0)){
	           System.out.println(current);
	       }
	       if(song2.compareTo(current.songTitle)>0){
	           subset(current.right, song1, song2);
	       }
	       return root;
	   }
	}

package Lab5;
//Song
public class Song implements Comparable<Song>{
	   String songTitle;
	   String artistName;
	   int streamCount;
	   int artistAverage;
	   Song left;
	   Song right;
	   		//empty constructor
	   		public Song(){
	   			this.songTitle = null;
	   			this.streamCount = 0;
	   			this.artistName = null;
	   			this.artistAverage = 0;
	   			left = null;
	   			right = null;
	   		}
	   		//constructor
	   		public Song(String songTitle, String artistName, int streamCount){
	   			this.songTitle = songTitle;
	   			this.streamCount = streamCount;
	   			this.artistName = artistName;
	   			this.artistAverage = streamCount;
	   			left = null;
	   			right = null;
	   		}
	  
	   //set songTitle method
	   public void setSongTitle(String songTitle){
	       this.songTitle = songTitle;
	   }
	  
	   //return songTitle
	   public String getSongTitle(){
	       return this.songTitle;
	   }
	  
	   //set streamCount method
	   public void setStreamCount(int streams){
	       this.streamCount = streams;
	   }
	      
	   //return streamCount
	   public int getStreamCount(){
	       return this.streamCount;
	   }
	  
	   //set artistName
	   public void setArtistName(String name){
	       this.artistName = name;
	   }
	  
	   //return artistName
	   public String getArtistName(){
	       return this.artistName;
	   }
	   
	   //Avg calculation
	   public void setArtistAverage(Song obj){
	       this.artistAverage = (this.streamCount + obj.streamCount) / 2;
	   }

	   public int compareTo(Song obj){
	       return this.songTitle.compareToIgnoreCase(obj.songTitle);
	   }
	   
	   //toString Method
	   public String toString(){
	       return this.songTitle + " by " + this.artistName + " Stream Averaging: " + this.artistAverage + " times";
	   }
	}
