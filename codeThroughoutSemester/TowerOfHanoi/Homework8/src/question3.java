import java.util.*;
public class question3 {
    /*
        Your algorithm should run in O(n) time-complexity
        Time Complexity O(n)
            n * (1 * 1 * 1) ==> n
     */
    private ArrayList<Integer> alpha;
    private HashSet<Integer> beta;
    public question3(ArrayList<Integer> a){
        alpha = a;
        beta = new HashSet<>();
        beta.addAll(alpha);
    }
    public String kDiff(int k){
        if(k==0){
            return "Cannot have k=0";
        }
        String combinations = "";
        for(int i=0; i<alpha.size(); i++){
            if((beta.contains(alpha.get(i)+k))){
                int temp1 = alpha.get(i) + k;
                combinations += "(" + alpha.get(i) + "," + temp1 + ") ";
            }
        }
        if (combinations == ""){
            return "No pairs found";
        }
        return combinations;
    }
}
