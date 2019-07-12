import java.util.*;
public class GraphType<E>{
    int numVertex;
    int numEdge;
    HashMap<E, ArrayList<E>> graph;
    public GraphType(){
        numVertex = 0;
        numEdge = 0;
        graph = new HashMap<>();
    }
    public void addVertex(E v){
        ArrayList<E> al = new ArrayList<E>();
        graph.put(v,al);
        numVertex++;
    }
    public ArrayList<E> getEdges(E u){
        return graph.get(u);
    }
    public boolean edgePresent(E u, E v){
        return (graph.get(u).contains(v));
    }
    public void addEdge(E u, E v){
        // lets assume that the vertices are already created.
        // In other words, u and v are already created
        if(!edgePresent(u,v)){
            graph.get(u).add(v);
        }
        if(!edgePresent(v,u)){
            graph.get(v).add(u);
        }
        numEdge++;
    }
}