import java.util.*;
public class Solution {
    private Stack<String> p;
    private HashSet<Integer> check;
    public Solution(){
        p = new Stack<>();
        check = new HashSet<>();
    }
    public String solution(String S){
        check.clear();
        int s1 = Integer.parseInt(S.substring(0,2));
        int s2 = Integer.parseInt(S.substring(3,5));
        if((s1 > 23)||(s1<0)||(s2>59)||(s2<0)){
            return "This is not a valid time. Must be in the format HH:MM";
        }
        String temp = "";
        int u=s1;
        int v=s2;
        boolean ch = false;
        String u1 = ""+s1;
        String v1 = ""+s2;
        int counts = 0;
        for(int i=0; i< 25; i++){
            if(u>=24){
                u=0;
            }
            u1=""+u;
            for(int j=0; j<61; j++){
                ch=false;;v1=""+v;
                if(v>=60){
                    v = 0;
                    break;
                }
                if(counts == 1440){
                    break;
                }counts++;
                if(u<10){
                    u1 = "0"+u;
                    ch = true;
                }
                if(v<10){
                    v1 = "0"+v;
                    ch = true;
                }
                if(ch == true){
                    temp = u1+":"+v1;
                }
                if(ch == false){
                    temp = u+":"+v;
                }
                p.push(temp);
                v++;
            }
            u++;
        }
        // Now i need to loop through the substrings and check to see if the most recent is a character set, etc.
        int s3 = Integer.parseInt(S.substring(0,1));
        int s4 = Integer.parseInt(S.substring(1,2));
        int s5 = Integer.parseInt(S.substring(3,4));
        int s6 = Integer.parseInt(S.substring(4,5));
        check.add(s3);check.add(s4);check.add(s5);check.add(s6);

        String tempo; int a1; int a2; int a3; int a4; String x1 = "0"; String x3 ="0"; boolean sh; boolean ph;
        String answer = S;
        while(!p.isEmpty()){
            sh=false;ph=false;
            tempo = p.peek();
            a1 = Integer.parseInt(tempo.substring(0,1));
            a2 = Integer.parseInt(tempo.substring(1,2));
            a3 = Integer.parseInt(tempo.substring(3,4));
            a4 = Integer.parseInt(tempo.substring(4,5));
//            System.out.println(a1 + "  " + a2 + "  " + a3 + "  " + a4);
            if((!check.contains(a1))||(!check.contains(a2))||(!check.contains(a3))||(!check.contains(a4))){
                p.pop();
                continue;
            }
            if(a1<1){
                x1 = "0";
                sh = true;
            }
            if(a3<1){
                x3 = "0";
                ph = true;
            }
            if(sh == true){
                answer = x1+a2+":"+(a3*10)+a4;
            }
            if(ph==true){
                answer = ((a1*10)+a2)+":"+x3+a4;
            }
            else{
                answer = ((a1*10)+a2)+":"+((a3*10)+a4);
            }
            break;
        }
        return answer;
    }
}
