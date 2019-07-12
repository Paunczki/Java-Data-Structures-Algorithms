//Question 8
public class Differ {
    public String differByK(int[] a, int k){
        if(k==0){
            return "difference of 0 is not allowed";
        }
        String message = "";
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                if(a[i] + k == a[j]){
                    message += ("("+a[i]+","+a[j]+"),");
                }
            }
        }
        if(message.equals("")){
           return "Difference of k was not found among any";
        }
        return message;
    }
}
