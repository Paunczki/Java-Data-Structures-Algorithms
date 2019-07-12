public class MazeRecursive {
    private int[][] maze;
    private boolean[][] visited;
    private int[][] visitedCounter;
    private int N;

    MazeRecursive(int size, int[][] array){ // This is for general case
        if(size>=4){
            N = size;
            maze = new int[N][N];
            visited = new boolean[N][N];
            visitedCounter = new int[N][N];
            for(int i=0; i<N;i++){
                for(int j=0; j<N; j++){
                    maze[j][i] = array[j][i];
                    visited[j][i] = false;
                    visitedCounter[j][i] = 0;
                }
            }
        }
        else{
            System.out.println("Not a valid size, must be >= 4");
        }
        // Here we can add the data for our maze
    }
    public void printSolution(){
        if(visited[N-1][N-1] == false){
            System.out.println("No Solution was found");
        }
        for(int i=0;i<N;i++){
            for(int j=0; j<N; j++){
                if (visited[j][i] == true) {
                    System.out.print("X ");
                    continue;
                }
                System.out.print(maze[j][i] + " ");
            }
            System.out.print("\n");
        }
    }
    public boolean isSafe(int x, int y){
        if(maze[x][y] == 1){
            return true;
        }
        if(maze[x][y] == 0){
            return false;
        }
        else {
            System.out.println("Weird");
            return false;
        }
    }
    public boolean solveMaze(int x, int y){
        if((x == (N-1))&&(y==(N-1))) {
            visited[x][y]=true;
            return true;
        }
        else {
            if (isSafe(x, y)) {
                if(visitedCounter[x][y] > 4){ // 4 for the 4 directions you can go
                    return false;
                }
                if(visited[x][y] == true){
                    visitedCounter[x][y]++;
                }
                visited[x][y] = true;
                try {
                    if ((y < (N - 1)) && (x < (N - 1))) {
                        if (solveMaze(x, y + 1)) { //east
                            return true;
                        }
                        if (solveMaze(x + 1, y)) { //south
                            return true;
                        }
                        if (solveMaze(x, y - 1)) { //west
                            return true;
                        }
                        if (solveMaze(x - 1, y)) { //north
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    if (y == (N - 1)) {
                        if (solveMaze(x + 1, y)) { //south
                            return true;
                        }
                        if (solveMaze(x - 1, y)) { //north
                            return true;
                        }
                        if (solveMaze(x, y - 1)) { //west
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    if (x == (N - 1)) {
                        if (solveMaze(x, y + 1)) { //east
                            return true;
                        }
                        if (solveMaze(x, y - 1)) { //west
                            return true;
                        }
                        if (solveMaze(x - 1, y)) { //north
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                }
                catch(Exception e){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return false;
    }
}
