import java.util.*;

public class question2 {
    /*
        Your algorithm should run in O(n^2)time-complexity or better.
        Time Complexity O(n^2)
            n + n*n*(1+1+1) + n(1) = n + n^2 + n ==> n^2
     */
    ArrayList<String> alpha;
    public question2(ArrayList<String> a){
        alpha = a;
    }

    HashSet<String> tot;
    public String sumString(){
        tot = new HashSet<>();
        tot.addAll(alpha);
        // Now need to test every two word pair
        int n1 = -1;
        int n2 = -1;
        boolean p=false;
        String joint = "";
        for(int j=0; j<alpha.size(); j++){
            for(int k=0; k<alpha.size(); k++){
                joint = alpha.get(j) + alpha.get(k);
                if(tot.contains(joint)){
                    n1 = j;
                    n2= k;
                    p = true;
                    break;
                }
            }
            if(p){
                break;
            }
        }
        if(p) {
            for(int z=0; z<alpha.size(); z++) {
                if(joint.equals(alpha.get(z))) {
                    return "Yes, " + alpha.get(n1) + " at location " + n1 + " and " +
                            alpha.get(n2) + " at location " + n2 + " together form " +
                            joint + " at location " + z;
                }
            }
        }
        return "No, no pairs found";
    }
}
