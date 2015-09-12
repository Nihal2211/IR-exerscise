//import
//version which just changed string to using an arraylist
//package javax.annotation.processing;
//import edu.princeton.cs.algs4.StdIn;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import java.util.TreeMap;
public class Wordfrequencychecker {
    
    
	public static TreeMap<String, ArrayList> printer (String args) {
        // arg2 = Boolean.parseBoolean(args[1]);
     HashMap <String, ArrayList> hash = new HashMap<String,ArrayList>();
         try (BufferedReader br = new BufferedReader(new FileReader(args)))
  {

   String line;
   int linenumber=0;

   while ((line = br.readLine()) != null) {
       
       line = line.toLowerCase(); // process the line.
       if (line == null) {break;}
       line = line.trim();
       //System.out.print(line);
       String[] wordlist = line.split(" ");
       
       for ( int i =0 ; i <wordlist.length; i ++) {
    	   ArrayList <Integer> value  = hash.get(wordlist[i]);
           // System.out.println(hash.get(wordlist[i]));
          // System.out.println(delims[i]);
            if (wordlist[i].endsWith(".") ){
               wordlist[i]= wordlist[i].substring(0, wordlist[i].length() - 1);         
           }
          if(wordlist[i].matches("[a-zA-Z]*$") && !wordlist[i].matches("^\\s*$")){ //"[a-zA-Z]*$"
           //System.out.println(linenumber);
           //System.out.println(value);
           if (value == null ) {value = new ArrayList<Integer>();
                           value.add(0,linenumber);}
           else value.add(linenumber);
           hash.put(wordlist[i], value); 
           }
         
           
       }
       linenumber = linenumber + 1;
   }        
   }
   catch (IOException e) {
   e.printStackTrace();
  }   
   
   TreeMap <String, ArrayList> map = new TreeMap <String, ArrayList>(hash);
   return map;
    }
  
public static void main(String[] args) {
     System.out.println(printer(args[0]));
    }
 
}

