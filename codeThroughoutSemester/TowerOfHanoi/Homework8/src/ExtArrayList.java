import java.util.*;

public class ExtArrayList<E> extends ArrayList<E>{
    /*
        Your algorithm should run in O(n) time or better.
            Time Complexity O(n)
            [n * 1] + [n * 1] = 2n ==> n
     */
    private HashMap<E, Integer> reference;
    public boolean equals(ExtArrayList<E> eal){
        reference = new HashMap<>();
        for(int j=0; j<this.size(); j++){
            E val = this.get(j);
            if(!reference.containsKey(val)){
                reference.put(val, 1);
            }
            else{
                int temp = reference.get(val);
                reference.put(val,temp++);
            }
        }
        if(!(this.size() == eal.size())){
            return false;
        }
        for(int i=0; i<eal.size(); i++){
            try {
                E val = eal.get(i);
                if (!reference.containsKey(val)) {
                    if ((reference.get(val) < 1) || (reference.get(val) == null)) {
                        return false;
                    }
                }
                else {
                    int temp = reference.get(val) - 1;
                    reference.put(val, temp);
                }
            }
            catch(Exception IndexOutOfBoundsException){
                return false;
            }
        }
        return true;
    }
}
