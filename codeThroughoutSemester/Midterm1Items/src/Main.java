import java.util.*;
// Question 1
// Time Complexity Estimate
// One for loop present plus the nested get method
// O(n) = n^2
public class Main {
    public boolean isFibonacci(LinkedList<Long> li){
        /*
            Here I will need to use most likely a listIterator to iterate through each element
            I need to check two numbers next to each other and see if the third is the sum of others
            If it returns true for the entire sequence, return true, else false

            Special Case: Make sure the value of the sum is greater than or equal to one
                This is because 0's will not be considered fibonacci

            Make sure to return the time complexity
         */
        for(int i=0; i<li.size()-2; i++){
            if(li.get(i) + li.get(i+1) < 1){
                return false;
            }
            if((li.get(i) + li.get(i+1)) != li.get(i+2)){
                return false;
            }
        }
        return true;
    }
}
