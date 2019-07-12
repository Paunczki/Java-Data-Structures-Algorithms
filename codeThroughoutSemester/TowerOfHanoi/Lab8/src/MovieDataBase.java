import java.util.*;
import java.io.*;

public class MovieDataBase {
    GraphType<String>movieGraph;
    HashSet<String> actors;
    HashSet<String> movies;
    String fileName;

    public MovieDataBase() {
        movieGraph = new GraphType();
        actors = new HashSet<>();
        movies = new HashSet<>();
        fileName = "/Users/JohnMikos/IdeaProjects/TowerOfHanoi/Lab8/movies.txt";
    }

    public void readMovieInfo() {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            String temp;
            while (scanner.hasNextLine()) {
                temp = scanner.nextLine();
                String[] s = temp.split("/");
                String movie = s[0];
                movieGraph.addVertex(movie);
                movies.add(movie);
                String actor;
                for (int i = 1; i < s.length; i++) {
                    actor = s[i];
                    if (!actors.contains(actor)) {
                        actors.add(actor);
                        movieGraph.addVertex(actor);
                    }
                    movieGraph.addEdge(movie, actor);
                }
            }
        } catch (Exception FileNotFoundException) {
            System.out.println("File Not Found");
        }
    }
    public ArrayList<String> getMovies(String cast) {
        if (actors.contains(cast)){
            return movieGraph.getEdges(cast);
        }
        else{
            return null;
        }
    }
    public ArrayList<String> commonMovies(ArrayList<String> al1, ArrayList<String> al2){
        ArrayList<String> common = new ArrayList<>();
        for(String s:al1){
            if(al2.contains(s)){
                common.add(s);
            }
        }
        return common;
    }
    public void coCast(int minMovies) {
        ArrayList<String> castMin = new ArrayList<>();
        for(String s: actors) {
            if (movieGraph.graph.get(s).size() >= minMovies) {
                castMin.add(s);
            }
        }
        for(String p:castMin){
            for(String r: castMin){
                if(p.compareTo(r)<0){
                    // intersect the arrayList of movies featuring p and r
                    ArrayList<String> al = commonMovies(movieGraph.graph.get(p), movieGraph.graph.get(r));
                    if(al.size()>=minMovies){
                        System.out.println("Cast members are " + p +", "+r);
                        System.out.println(al);
                        System.out.println();
                    }
                }
            }
        }
    }
}