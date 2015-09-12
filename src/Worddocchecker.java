
//version which asks to look at a folder 
//go through documents and check the position numbers

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Worddocchecker {
	
	
	public static TreeMap<String,HashMap <Integer, ArrayList>> printer () {
		
		ArrayList<String> Docarray = new ArrayList();
		File directory = new File("C:/Users/syedkhadri/workspace2/Trail/src/Wordfrequency");
		
		//File[] filelist = directory.listFiles();
		 //System.out.println(filelist.length);
		 for (final File file : directory.listFiles()) {
			 System.out.println(file);
		    Docarray.add("C:/Users/syedkhadri/workspace2/Trail/src/Wordfrequency/" + file.getName());
		}
     HashMap <String, HashMap <Integer, ArrayList>> hash = new HashMap<String,HashMap <Integer, ArrayList>>();
    
     for (int docno = 0; docno <Docarray.size(); docno++ ){
     
     try (BufferedReader br = new BufferedReader(new FileReader(Docarray.get(docno))))
  {

   String line;
   int positionnumber=0;

   while ((line = br.readLine()) != null) {
       
       line = line.toLowerCase(); // process the line.
       if (line == null) {break;}
       line = line.trim();
       //System.out.print(line);
       String[] wordlist = line.split(" ");
       
       for ( int i = 0; i <wordlist.length; i ++) {
    	    positionnumber = positionnumber + 1;
    	   ArrayList <Integer> positionsarray = new ArrayList <Integer>();
    	   HashMap <Integer, ArrayList> Dococcurence  = hash.get(wordlist[i]);
    	   if (Dococcurence != null) {positionsarray= Dococcurence.get(docno+1);}
            if (wordlist[i].endsWith(".") || wordlist[i].endsWith("?")){
               wordlist[i]= wordlist[i].substring(0, wordlist[i].length() - 1);         
           }
          if(wordlist[i].matches("[a-zA-Z]*$") && !wordlist[i].matches("^\\s*$")){ //"[a-zA-Z]*$"
           //System.out.println(linenumber);
           //System.out.println(value);
           if (Dococcurence == null ) {Dococcurence = new HashMap <Integer, ArrayList>();
              positionsarray = new ArrayList <Integer>();
              positionsarray.add(0,positionnumber);
              Dococcurence.put(docno+1,positionsarray);}
           else if (positionsarray ==null ) {
        	   positionsarray = new ArrayList <Integer>();
               positionsarray.add(positionnumber);
                            Dococcurence.put(docno+1,positionsarray);
           }
           else {
        	 positionsarray.add(positionnumber);
        	 Dococcurence.put(docno+1,positionsarray);}
           hash.put(wordlist[i], Dococcurence); 
           }  
       }
       
   }        
   }
   catch (IOException e) {
   e.printStackTrace();
  }   
     }
   TreeMap <String,HashMap <Integer, ArrayList>> map = new TreeMap <String, HashMap <Integer, ArrayList>>(hash);
   return map;
    }
  
public static void main(String[] args) {
     System.out.println(printer());
    }
 
}



/*Path dir = ...;
try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
for (Path file: stream) {
    System.out.println(file.getFileName());
}
} catch (IOException | DirectoryIteratorException x) {
// IOException can never be thrown by the iteration.
// In this snippet, it can only be thrown by newDirectoryStream.
System.err.println(x);
}*/