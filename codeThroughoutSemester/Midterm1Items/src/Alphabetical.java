import java.util.*;
// Question 7
public class Alphabetical {
    public LinkedList<String> alphabet(LinkedList<String> a, LinkedList<String> b){
        LinkedList<String> temp1 = new LinkedList<String>();
        LinkedList<String> temp2 = new LinkedList<String>();
        LinkedList<String> third = new LinkedList<String>();
        if(a.isEmpty() || b.isEmpty()){
            System.out.println("Empty linked lists, returning empty linked list");
            return third;
        }
        for(int i=0; i<a.size(); i++){
            temp1.add(a.get(i));
        }
        for(int i=0; i<b.size(); i++){
            temp2.add(b.get(i));
        }
        while(!temp1.isEmpty() && !temp2.isEmpty()){
            if((temp1.get(0).compareTo(temp2.get(0)) >0)){
                third.add(temp2.get(0));
                temp2.remove(0);
                continue;
            }
            if((temp1.get(0).compareTo(temp2.get(0)) <0)){
                System.out.println(temp1.get(0).compareTo(temp2.get(0)));
                third.add(temp1.get(0));
                temp1.remove(0);
                continue;
            }
            if((temp1.get(0).compareTo(temp2.get(0)) ==0)){
                third.add(temp1.get(0));
                temp1.remove(0);
                third.add(temp2.get(0));
                temp2.remove(0);
                continue;
            }
        }
        if(temp1.isEmpty()){
            for(int i=0; i<temp2.size(); i++){
                third.add(temp2.get(i));
            }
        }
        if(temp2.isEmpty()){
            for(int i=0; i<temp1.size(); i++){
                third.add(temp1.get(i));
            }
        }
        return third;
    }
}
