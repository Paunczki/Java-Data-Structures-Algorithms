import java.util.*;
// Question 6
// Time Complexity Estimate
// Three for loops present plus the nested get method
// O(n) = n^4
public class Concatenate {
    public String concatenate(ArrayList<String> arr){
        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<arr.size(); j++){
                String temp = arr.get(i) + arr.get(j);
                for(int k=0; k<arr.size(); k++){
                    if((arr.get(k)).equals(temp)){
                        return ("Yes, " + arr.get(i) + " at location " + i
                                + " and " + arr.get(j) + " at location " + j
                                + " together form " + temp + " at location " + k);
                    }
                }
            }
        }
        return "No, no concatenates here :(";
    }
}
