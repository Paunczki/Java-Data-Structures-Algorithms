import java.util.*;
import java.io.*;

public class PrimitiveJavaEditor 

{
PrintWriter printWriter=null;

/*

  public boolean find (String x) 
  { String word;
      ListIterator<String> itr = ReadFiles.textFile.listIterator();
     while (itr.hasNext()){
     word=  itr.next().trim();
    //word= word.replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
    // System.out.println(word);
     if (word.equals(x)) {
         return true; 
        }
    }
        return false;
    }
    // Looks for a word "x" in the file and returns true if found or false otherwise.


public  boolean findReplace (String find, String replace) 

   {
       int index;
      index = ReadFiles.textFile.indexOf(find);
       if (index != -1) {
           String prev = ReadFiles.textFile.set(index,replace);
           return true;
        }
        else return false;
    }
           
       // looks for the first occurrence of word "x" in the file and replaces it with word "y" if found returning true, false otherwise.



public  boolean findInsert (String find, String insert) { 
 // looks for the first occurrence of word "x" in the file and then insert "y" right after "x", if x is found, returning true, false otherwise.  

    int index;
       index = ReadFiles.textFile.indexOf(find);
       if (index != -1) {
          ReadFiles.textFile.add(index+1,insert);
           return true;
        }
        else return false;
    }



 public boolean delete (String del) {
     // looks for the first occurrence of word "x" in the file and deletes it from the file, returning true if x is found, returning false otherwise.
     
     return (ReadFiles.textFile.removeFirstOccurrence(del));
    }
     


     public String spellCheck () { // finds the first occurrence of spelling error and returns the misspelled word. If no word is misspelled returns "Spell Check Passed".
         
    String word;
    ListIterator<String> itr = ReadFiles.textFile.listIterator();

     while (itr.hasNext()){
     word=  itr.next().trim();
     
    // word= word.replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
     if (!ReadFiles.wordList.contains(word)) return word;
    }
    return "no spelling errors";
     
 }



     public void spellCheckAll() {

    // find all misspelled words and output them to the screen.
 
         String word;
         boolean spellPass=true;
        ListIterator<String> itr = ReadFiles.textFile.listIterator();
        while (itr.hasNext()){
        word= itr.next().trim();
         //word= word.replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
        // word=word.replaceAll("[]","");
        // System.out.println(word);
         if (!ReadFiles.wordList.contains(word)) {System.out.println(word);
            spellPass=false;
        }
    }
    if (spellPass) System.out.println("no misspelled words, spellcheck passed   ");
     
 }



 public void save() {
     // saves file with the changes made
      
       ListIterator itr = ReadFiles.textFile.listIterator();
       int count=0;
     try
               {
                   printWriter = new PrintWriter (new FileWriter ("newTextFile.txt"));
                   while (itr.hasNext()){
                        printWriter.print(itr.next());
                        count++;
                        if (count % 10 ==0) printWriter.print ("\n");
                    }
                        
                    }
               
               catch (IOException e)
               {
                   System.out.println(e);
               }
          // }
       
       

          printWriter.close();
        
   }

 
 public void print() 
 // saves file with the changes and outputs the contents of the file to the screen.
 {
     this.save();
     Scanner sc;
     
     
     try
               {
                   sc = new Scanner("newTextFile.txt");
                   while (sc.hasNext())
                        System.out.println(sc.nextLine());
                    }
               
               catch (Exception e)
               {
                   System.out.println(e);
               }
    }
    
    public void quit() {
        
        save();
        
    }
    
    public boolean findReplaceAll(String x, String y) {
        
        boolean found=false; 
        int index=0;
      ListIterator<String> itr = ReadFiles.textFile.listIterator();
     while (itr.hasNext()){
     String word=  itr.next().trim();
     if (word.equals(x)) {
         ReadFiles.textFile.set(index,y);
         found=true;
        index++;
    }
    }
        return found;
        
    }
    */
}
