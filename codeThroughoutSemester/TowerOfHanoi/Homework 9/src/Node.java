public class Node<E> {
    private Node<E> left;
    private Node<E> right;
    private  Node<E> parent;
    private  E value;

    public Node() {
        left =null;
        right=null;
        parent=null;
        value=null;
    }
    public Node(Node<E> l, Node<E> r, Node<E> p, E v) {
        left=l;
        right=r;
        parent=p;
        value=v;
    }
    public void setValue(E v) {
        this.value=v;
    }
    public void setLeft(Node<E> l) {
        this.left=l;
    }
    public void setRight(Node<E> r) {
        this.right=r;
    }
    public void setParent(Node<E> p) {
        this.parent=p;
    }
    public Node<E> getLeft(){
        return this.left;
    }
    public Node<E> getRight(){
        return this.right;
    }
    public Node<E> getParent(){
        return this.parent;
    }

}
