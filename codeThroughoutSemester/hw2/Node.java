public class Node<E>{
    E item;
    Node<E> next;
    
    public Node(E val, Node<E> n){
        item = val;
        next = n;   
    }
    public Node(){
        item = null;
        next = null;
    }
}