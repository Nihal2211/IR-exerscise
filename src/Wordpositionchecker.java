
//import

//version which retruns the linenumber and position number

//package javax.annotation.processing;
//import edu.princeton.cs.algs4.StdIn;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import java.util.TreeMap;
public class Wordpositionchecker {
    
    
	public static TreeMap<String,HashMap <Integer, ArrayList>> printer (String args) {
        // arg2 = Boolean.parseBoolean(args[1]);
     HashMap <String, HashMap <Integer, ArrayList>> hash = new HashMap<String,HashMap <Integer, ArrayList>>();
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
    	   ArrayList <Integer> positionnumber = new ArrayList <Integer>();
    	   HashMap <Integer, ArrayList> value  = hash.get(wordlist[i]);
    	   if (value != null) {positionnumber= value.get(linenumber);}
           // System.out.println(hash.get(wordlist[i]));
          // System.out.println(delims[i]);
            if (wordlist[i].endsWith(".") ){
               wordlist[i]= wordlist[i].substring(0, wordlist[i].length() - 1);         
           }
          if(wordlist[i].matches("[a-zA-Z]*$") && !wordlist[i].matches("^\\s*$")){ //"[a-zA-Z]*$"
           //System.out.println(linenumber);
           //System.out.println(value);
           if (value == null ) {value = new HashMap <Integer, ArrayList>();
              positionnumber = new ArrayList <Integer>();
              positionnumber.add(0,i);
                           value.put(linenumber,positionnumber);}
           else if (positionnumber ==null ) {
        	   positionnumber = new ArrayList <Integer>();
               positionnumber.add(i);
                            value.put(linenumber,positionnumber);
           }
           else {
        	 positionnumber.add(i);
             value.put(linenumber, positionnumber) ;}
           hash.put(wordlist[i], value); 
           }  
       }
       linenumber = linenumber + 1;
   }        
   }
   catch (IOException e) {
   e.printStackTrace();
  }   
   
   TreeMap <String,HashMap <Integer, ArrayList>> map = new TreeMap <String, HashMap <Integer, ArrayList>>(hash);
   return map;
    }
  
public static void main(String[] args) {
     System.out.println(printer(args[0]));
    }
 
}

