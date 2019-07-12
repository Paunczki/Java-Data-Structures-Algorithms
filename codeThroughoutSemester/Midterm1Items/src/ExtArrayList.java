import java.util.*;
// Question 2
// Time Complexity Estimate
// Two separated for loops with nested get methods
// O(n) = 2* (n^2) = n^2
public class ExtArrayList<E> extends ArrayList<E> {
    public boolean equals(ExtArrayList<E> eal){
        /*
            First check, see if the sizes are the same, it may add a bit of time complexity, but it
                will cancel out many situations
            We are supposed to check over duplicates too, so maybe create a temporary array that will
                be the same as input and will delete the elements if the others are equal
                to check of completely true check to see if the temp array is empty
            Make sure to do run time complexity

         */
        if((this.size()) == (eal.size())){
            ExtArrayList<E> temp = new ExtArrayList<E>();
            for(int i=0; i<eal.size(); i++){
                temp.add(eal.get(i));
            }
            for(int i=0; i<eal.size(); i++){
                if(!temp.contains(this.get(i))){
                    return false;
                }
                if(temp.contains(this.get(i))){
                    temp.remove(this.get(i));
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
}
