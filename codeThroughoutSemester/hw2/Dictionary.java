import java.util.*;
import java.io.*;
public class Dictionary{
    // read the word list one word at a time and store in a LinkedList
    // print the size of the wordlist
    public static void main(String[] args){
       long t1 = System.currentTimeMillis();
        LinkedList<String> dictionary = new LinkedList<>();
       Scanner fileScanner;      
       String word;
       // one
       try{
           fileScanner = new Scanner (new File("EnglishWordList.txt"));        
           while (fileScanner.hasNext()){
               word = fileScanner.nextLine();
               dictionary.add(word);
           }
       }
       catch (Exception e){
           System.out.println("file not found...");
       }
       System.out.println(dictionary.size()); // two
       
       
       
       long t2 = System.currentTimeMillis();
       System.out.println(t2-t1);
    }
}
