public class Test {
    public static int[][] maze = new int[5][5];
    public static void main(String[] args){
        maze[0][0] = 1;maze[0][1] = 0;maze[0][2] = 1;maze[0][3] = 0;maze[0][4] = 1;
        maze[1][0] = 0;maze[1][1] = 1;maze[1][2] = 0;maze[1][3] = 0;maze[1][4] = 1;
        maze[2][0] = 1;maze[2][1] = 1;maze[2][2] = 1;maze[2][3] = 1;maze[2][4] = 1;
        maze[3][0] = 1;maze[3][1] = 0;maze[3][2] = 1;maze[3][3] = 0;maze[3][4] = 1;
        maze[4][0] = 0;maze[4][1] = 1;maze[4][2] = 1;maze[4][3] = 1;maze[4][4] = 1;
        MazeRecursive maze1 = new MazeRecursive(5, maze);
        maze1.solveMaze(0,0);
        maze1.printSolution();
        System.out.println(" ");
        MazeNonrecursive maze2 = new MazeNonrecursive(5,maze);
        maze2.solveMaze(0,0);
        maze2.printSolution();
    }
}
