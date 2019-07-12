import java.util.*;
//Question 3
public class CharReplace {
    public String replaceChar(String p, int k, String c){
        /*
        that given a String p, an int k, and a char c, returns a String with the kth character replaced by c.
        Of course, 0<=k<=p.length()-1, otherwise handle it via an exception or error.
         */
        if((k<0) || (k>p.length()-1)){
            return "Invalid bounds of string";
        }
        String[] word = p.split("(?!^)");
        word[k] = c;
        String wordEnd = "";
        for(int i=0; i<p.length(); i++){
            wordEnd += word[i];
        }
        return wordEnd;
    }
}
