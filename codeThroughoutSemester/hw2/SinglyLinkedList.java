
public class SinglyLinkedList<E>{
    Node<E> first;
    Node<E> last;
    int size;
    //empty linked list
    public SinglyLinkedList(){
        first = null;
        last = null;
        size = 0;
    }
    public boolean isEmpty(){
        //if (size==0) return true;
        //else return false;
        return (size==0);
    }
    //add method adds to the end of the linked list
    public void add(E val){
        Node<E> temp = new Node<E>(val,null);
        if(isEmpty()){
            first = temp;
            last = temp;
        }
        else {
            last.next = temp;
            last = temp;
        }
        size++;
    }
    //prints the items from the first to the last
    public void printList(){
        if(isEmpty()){
            System.out.println("list is empty ...");
        }
        else{
            Node<E> temp = first;
            for(int i = 0; i < size; i++){
                System.out.println(temp.item);
                temp = temp.next;
            }
        }
    }
}