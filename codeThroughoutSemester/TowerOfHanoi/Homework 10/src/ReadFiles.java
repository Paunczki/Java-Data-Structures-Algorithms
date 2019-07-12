

import java.util.*;
import java.io.*;
public class ReadFiles {

    
     Scanner fileScanner;
     static HashMap<String, Integer> textFile;
     static HashSet<String> wordList;
     static HashSet<String> stopList;
     String dictionaryFile = "/Users/JohnMikos/IdeaProjects/TowerOfHanoi/Homework 10/EnglishWordList.txt";
     String textFileName ="/Users/JohnMikos/IdeaProjects/TowerOfHanoi/Homework 10/Automotive_5.txt";
     String stopListName = "/Users/JohnMikos/IdeaProjects/TowerOfHanoi/Homework 10/stop_words.txt";
     
     public ReadFiles () {
         
         fileScanner=null;
         textFile = new HashMap<>();
         wordList = new HashSet<>();
         stopList = new HashSet<>();
     }
        
        
        public void readTextFile() {
       
          String line=null;
          //String[] words;
               try {
                  
                   fileScanner = new Scanner (new File (textFileName));
                   
                   while (fileScanner.hasNext()) {
           
                    line = fileScanner.nextLine();
                    String[] words=line.split(" ");
                    int temp;
                    for (int i=0;i<words.length;i++) {
                        String s = words[i].replaceAll("[\\[\\]_:\"'`?;\\”0-9—;“()-/.,*! ]", "").trim().toLowerCase();
                        if (!s.isEmpty()){
                            if(s.length() > 1) {
                                if (textFile.containsKey(s)) {
                                    temp = textFile.get(s) + 1;
                                    textFile.put(s, temp);
                                } else {
                                    textFile.put(s, 1);
                                }
                            }
                            else{
                                continue;
                            }
                        }
                    }
                    
                }
               }
               catch (IOException e) {
                   System.out.println(e);
               }
       
   }
     
   public void readStopList(){
       String word=null;
       try {

           fileScanner = new Scanner (new File (stopListName));

           while (fileScanner.hasNext()){
               word = fileScanner.nextLine();
               word = word.replaceAll("[\\[\\]_:\"'`?;\\”0-9—;“()-/.,*! ]", "").trim().toLowerCase();
               stopList.add(word);
           }

       }
       catch (IOException e) {
           System.out.println(e);
       }

   }
   
   public void readDictionary() {
       
          String word=null;
               try {
                  
                   fileScanner = new Scanner (new File (dictionaryFile));
                   
                   while (fileScanner.hasNext()){
           
                    word = fileScanner.nextLine();
                    wordList.add(word);
                }
       
               }
               catch (IOException e) {
                   System.out.println(e);
               }
       
   }
   public void removal(){
       HashSet<String> toRemove= new HashSet<>();
       for(String key: textFile.keySet()){
           if (!wordList.contains(key)) {
               toRemove.add(key);
           }
           if (stopList.contains(key)) {
               toRemove.add(key);
           }
       }
       for(String key: toRemove){
           textFile.remove(key);
       }
   }
   public void highestFrequency(){
       String max1 = "glade"; // glade because it only occurs once
       String max2 = "glade";
       String max3 = "glade";
       String max4 = "glade";
       String max5 = "glade";
       int temp;
       for(String key:textFile.keySet()){
           temp = textFile.get(key);
           if(temp > textFile.get(max1)){
               max5 = max4;
               max4 = max3;
               max3 = max2;
               max2 = max1;
               max1 = key;
           }
           if((temp<textFile.get(max1))&&(temp > textFile.get(max2))){
               max5 = max4;
               max4 = max3;
               max3 = max2;
               max2 = key;
           }
           if((temp<textFile.get(max2))&&(temp > textFile.get(max3))){
               max5 = max4;
               max4 = max3;
               max3 = key;
           }
           if((temp<textFile.get(max3))&&(temp > textFile.get(max4))){
               max5 = max4;
               max4 = key;
           }
           if((temp<textFile.get(max4))&&(temp > textFile.get(max5))){
               max5 = key;
           }
       }
       System.out.println("1st highest occurring = " + max1 + " with " + textFile.get(max1) + " occurrences");
       System.out.println("2nd highest occurring = " + max2 + " with " + textFile.get(max2) + " occurrences");
       System.out.println("3rd highest occurring = " + max3 + " with " + textFile.get(max3) + " occurrences");
       System.out.println("4th highest occurring = " + max4 + " with " + textFile.get(max4) + " occurrences");
       System.out.println("5th highest occurring = " + max5 + " with " + textFile.get(max5) + " occurrences");
   }
   public void lowestFrequency(){
       String min1 = "overall"; // overall because it occurs the most
       String min2 = "overall";
       String min3 = "overall";
       String min4 = "overall";
       String min5 = "overall";
       int temp;
       for(String key:textFile.keySet()){
           temp = textFile.get(key);
           if(temp <= textFile.get(min1)){
               min5 = min4;
               min4 = min3;
               min3 = min2;
               min2 = min1;
               min1 = key;
           }
           if((temp > textFile.get(min1))&&(temp < textFile.get(min2))){
               min5 = min4;
               min4 = min3;
               min3 = min2;
               min2 = key;
           }
           if((temp > textFile.get(min2))&&(temp < textFile.get(min3))){
               min5 = min4;
               min4 = min3;
               min3 = key;
           }
           if((temp > textFile.get(min3))&&(temp < textFile.get(min4))){
               min5 = min4;
               min4 = key;
           }
           if((temp > textFile.get(min4))&&(temp < textFile.get(min5))){
               min5 = key;
           }
       }
       System.out.println("1st lowest occurring = " + min1 + " with " + textFile.get(min1) + " occurrence(s)");
       System.out.println("2nd lowest occurring = " + min2 + " with " + textFile.get(min2) + " occurrence(s)");
       System.out.println("3rd lowest occurring = " + min3 + " with " + textFile.get(min3) + " occurrence(s)");
       System.out.println("4th lowest occurring = " + min4 + " with " + textFile.get(min4) + " occurrence(s)");
       System.out.println("5th lowest occurring = " + min5 + " with " + textFile.get(min5) + " occurrence(s)");
   }
}

