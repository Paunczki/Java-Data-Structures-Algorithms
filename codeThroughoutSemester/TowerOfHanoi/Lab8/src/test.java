public class test {
    public static void main(String[] args){
        long time1 = System.currentTimeMillis();
        MovieDataBase m = new MovieDataBase();
        m.readMovieInfo();
        System.out.println("Number of unique movies: " + m.movies.size());
        System.out.println("Number of unique actors: " + m.actors.size());
        System.out.println("Number of edges: " + m.movieGraph.numEdge);
        System.out.println("Number of vertexes: " + m.movieGraph.numVertex);
        System.out.println("Bale, Christian 's movies: "+m.getMovies("Bale, Christian"));
        System.out.println("ndaionoand's movies: "+m.getMovies("ndaionoand"));
//        System.out.println("\n\n");
//        m.coCast(13);
        System.out.println("\n\n");
        System.out.println("Actors that have worked together...");
        m.coCast(15);
        // Lynn Sherry(I), McGowan,Mickie Have acted in the most movies together at 15 movies

        long time2 = System.currentTimeMillis();
        System.out.println("Program took " + ((time2-time1)/1000.0) + " seconds");
    }
}
