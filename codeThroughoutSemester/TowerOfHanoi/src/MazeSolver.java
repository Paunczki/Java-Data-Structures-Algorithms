public class MazeSolver {
    private static int row=0;
    private static int column=0;
    private static int[][] maze = new int[4][4];
    private static boolean[][] visited = new boolean[4][4];
    public static void main(String[] args) {
        maze[0][0] = 1; maze[0][1] = 1; maze[0][2] = 0; maze[0][3] = 1;
        maze[1][0] = 0; maze[1][1] = 1; maze[1][2] = 1; maze[1][3] = 1;
        maze[2][0] = 0; maze[2][1] = 0; maze[2][2] = 0; maze[2][3] = 1;
        maze[3][0] = 0; maze[3][1] = 1; maze[3][2] = 0; maze[3][3] = 1;
        visited[0][0] = false; visited[0][1] = false; visited[0][2] = false; visited[0][3] = false;
        visited[1][0] = false; visited[1][1] = false; visited[1][2] = false; visited[1][3] = false;
        visited[2][0] = false; visited[2][1] = false; visited[2][2] = false; visited[2][3] = false;
        visited[3][0] = false; visited[3][1] = false; visited[3][2] = false; visited[3][3] = false;
        printMaze(maze);
    }
    public static void printSolution(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                //if(visited[j][i] == )
            }
        }
    }
    public static void printMaze(int [][] array) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((row == i) && (column == j)) {
                    System.out.print("X ");
                    continue;
                }
                System.out.print(array[j][i] + " ");
            }
            System.out.print("\n");
        }
    }
    public boolean solveMaze(int x, int y){
        while(isSafe(x,y)){
            visited[x][y] = true;
            if(isSafe(x,y+1)){ //East

            }
            if(isSafe(x+1,y)){ //South

            }
            if(isSafe(x,y-1)){ //West

            }
            if(isSafe(x-1,y)){ //North

            }



        }
        return true;
    }
    public boolean isSafe(int x, int y){
        if(maze[x][y] == 1){
            return true;
        }
        if(maze[x][y] == 0){
            return false;
        }
        else{
            System.out.println("Weird");
            return false;
        }
    }

}
