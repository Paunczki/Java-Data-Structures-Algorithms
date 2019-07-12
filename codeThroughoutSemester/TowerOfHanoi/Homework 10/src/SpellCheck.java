import java.util.*;
import java.io.*;

public class SpellCheck {
    public String spellCheck (String a) {
        String word;
        for(String key: ReadFiles.textFile.keySet()) {
            word = key.trim();
            word = word.replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
            if (!ReadFiles.wordList.contains(word)) return word;
        }
        return "No spelling errors";
    }
    public void spellCheckAll() {
        // find all misspelled words and output them to the screen.
        String word;
        boolean spellPass=true;
        for(String key: ReadFiles.textFile.keySet()){
            word = key.trim();
            word = word.replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
            if(!ReadFiles.wordList.contains(word)){
                spellPass = false;
                ReadFiles.textFile.remove(word);
            }
        }
        if(spellPass){
            System.out.println("no misspelled words, spellcheck passed   ");
        }
    }



}
