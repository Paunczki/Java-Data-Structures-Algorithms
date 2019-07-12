public class BinTree<E> {
    Node<E> root;
    int size;
    public BinTree() {
        root=null;
        size=0;
    }
    public BinTree(E val) {
        root = new Node(null, null, null,val);
        size=1;
    }
    public void addLeft(Node<E> p, Node<E> child) {
        /*
        child.parent=p;
        p.left=child;
        size++;
        */
        child.setParent(p);
        p.setLeft(child);
        size++;
    }
    public void addRight(Node<E> p, Node<E> child) {
        child.setParent(p);
        p.setRight(child);
        size++;
    }
    public boolean isLeaf(Node<E> p){
        if((p.getLeft() == null) && p.getRight() == null){
            return true;
        }
        return false;
    }
    public boolean isRoot(Node<E> p){
        if(p.getParent() == null){
            return true;
        }
        return false;
    }
    public boolean deleteLeaf(Node<E> p){
        if(isLeaf(p)){
            p.setValue(null);
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        // Here is tree for 2a
        BinTree<Character> tree= new BinTree<>('A');
        Node<Character> n1 = new Node<>(null,null,null,'B');
        tree.addLeft(tree.root,n1);
        Node<Character> n2 = new Node<>(null,null,null,'E');
        tree.addLeft(n1,n2);
        Node<Character> n3 = new Node<>(null,null,null,'C');
        tree.addRight(n1,n3);
        Node<Character> n4 = new Node<>(null,null,null,'F');
        tree.addRight(n2,n4);
        Node<Character> n5 = new Node<>(null,null,null,'D');
        tree.addRight(n3,n5);
        Node<Character> n6 = new Node<>(null,null,null,'G');
        tree.addLeft(n5,n6);
        Node<Character> n7 = new Node<>(null,null,null,'H');
        tree.addRight(n6,n7);

        // for 2b see attached file
    }
}
