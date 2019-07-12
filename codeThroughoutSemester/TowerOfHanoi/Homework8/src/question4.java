import java.util.*;

public class question4 {
    /*
        Your algorithm should run in O(m+n) time where m is the size of one list and n is the size of the other.
        Time Complexity O(m+n)
            m + n ==> m+n
     */
    ArrayList<String> alpha;
    ArrayList<String> beta;
    HashSet<String> result;
    public question4(ArrayList<String> a, ArrayList<String> b){
        alpha = a;
        beta = b;
        result = new HashSet<>();
    }
    public HashSet<String> union(){
        result.addAll(alpha); // O(m)
        result.addAll(beta);  // O(n)
        return result;
    }
}
