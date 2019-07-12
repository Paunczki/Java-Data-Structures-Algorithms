import java.util.*;
// Question 5
// Time Complexity Estimate
// One for loop present plus the nested get method
// O(n) = n^2
public class Pairwise {
    public String pairwiseSums(LinkedList<Integer> li){
        if(li.size() < 2){
            return "Not a valid list for pairwise summation, at least 2 numbers needed";
        }
        String message="";
        for(int i=0; i<li.size()-1; i++){
            if(i==li.size()-2){
                message+=(li.get(i) + li.get(i+1));
            }
            else{
                message+=(li.get(i) + li.get(i+1) + ", ");
            }
        }
        return message;
    }
}
