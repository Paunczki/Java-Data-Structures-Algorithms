import java.util.*;
import java.io.*; 
public class DictionaryArray{
    ArrayList<String> words = new ArrayList<>(); 
    int duplicates = 0; 
    public void fileRead(){ 
           Scanner reader = null; 
           try{ reader = new Scanner(new File("EnglishWordList.txt"));
            }
           catch (FileNotFoundException ex){
               System.out.println(ex + " file not found ");
           }
           while(reader.hasNext()){
               String str = reader.nextLine();
               if(!words.contains(str)){
                   words.add(str);
               }
               else duplicates++; 
           }
       }
    
    public static void main(String[] args){
        DictionaryArray t = new DictionaryArray();
        long t1 = System.currentTimeMillis(); 
        t.fileRead();
        long t2 = System.currentTimeMillis();
        System.out.println(t.words.size());
        System.out.println("number of duplicates " + t.duplicates);
        System.out.println("time take (in seconds) = " + (t2-t1)/1000.0);
    }   
}