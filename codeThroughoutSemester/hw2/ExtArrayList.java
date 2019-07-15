import java.util.*;
public class ExtArrayList<E> extends ArrayList<E>{
    ArrayList E;
    public ExtArrayList<E> append(ArrayList<E> ea){
        this.add(E ea);
        return this;
    }
    public boolean consecutivePair(E e1, E e2){
        this.check();
    }
    
    /* 
    public E getMiddle(){
        int middle = this.size()/2;
        if(!isEmpty()){
            return get(middle);
        }
        else{
            System.out.println("list is empty ...");
            return null;
        }
    }
    public static void main(String[] args){
        ExtArrayList<String> eal = new ExtArrayList<>();
        eal.add("apple");
        eal.add("pear");
        eal.add("orange");
        System.out.println(eal.getMiddle());
    }
    */
}