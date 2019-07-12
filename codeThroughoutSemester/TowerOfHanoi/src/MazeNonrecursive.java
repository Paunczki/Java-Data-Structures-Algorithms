import java.util.*;
public class MazeNonrecursive {
    private static int[][] maze;
    private static boolean[][] visited;
    private static int[][] visitedCounter;
    private int N;
    public MazeNonrecursive(int size, int[][] array){
        if(size >=4){
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
            System.out.println("Not a sufficiently sized maze");
        }
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

    Stack<Integer> cellStack = new Stack<Integer>();
    public boolean solveMaze(int x, int y) {
        while (isSafe(x, y)) {
            if (visitedCounter[x][y] > 4) { // 4 for the 4 directions you can go
                y = cellStack.pop();
                x = cellStack.pop();
                continue;
            }
            if (visited[x][y] == true) {
                visitedCounter[x][y]++;
            }
            visited[x][y] = true;
            if ((x == 0) && (y == 0)) {
                if (isSafe(x, y + 1)) { //east
                    cellStack.push(x);
                    cellStack.push(y + 1);
//                    y++;
//                    continue;
                }
                if (isSafe(x + 1, y)) { //south
                    cellStack.push(x + 1);
                    cellStack.push(y);
//                    x++;
//                    continue;
                }
            }
            if ((x == 0) && ((y > 0) && (y < N - 1))) {
                if (isSafe(x, y + 1)) { //east
                    cellStack.push(x);
                    cellStack.push(y + 1);
//                    y++;
//                    continue;
                }
                if (isSafe(x + 1, y)) { //south
                    cellStack.push(x + 1);
                    cellStack.push(y);
//                    x++;
//                    continue;
                }
                if (isSafe(x, y - 1)) { //west
                    cellStack.push(x);
                    cellStack.push(y - 1);
//                    y--;
//                    continue;
                }
            }
            if ((y == 0) && ((x > 0) && (x < N - 1))) {
                if (isSafe(x, y + 1)) { //east
                    cellStack.push(x);
                    cellStack.push(y + 1);
//                    y++;
//                    continue;
                }
                if (isSafe(x + 1, y)) { //south
                    cellStack.push(x + 1);
                    cellStack.push(y);
//                    x++;
//                    continue;
                }
                if (isSafe(x - 1, y)) { //north
                    cellStack.push(x - 1);
                    cellStack.push(y);
//                    x--;
//                    continue;
                }
            }
            if (((x < N - 1) && (y < N - 1)) && ((x > 0) && (y > 0))) {
                if (isSafe(x, y + 1)) { //east
                    cellStack.push(x);
                    cellStack.push(y + 1);
//                    y++;
//                    continue;
                }
                if (isSafe(x + 1, y)) { //south
                    cellStack.push(x + 1);
                    cellStack.push(y);
//                    x++;
//                    continue;
                }
                if (isSafe(x, y - 1)) { //west
                    cellStack.push(x);
                    cellStack.push(y - 1);
//                    y--;
//                    continue;
                }
                if (isSafe(x - 1, y)) { //north
                    cellStack.push(x - 1);
                    cellStack.push(y);
//                    x--;
//                    continue;
                }
            }
            if ((y == N - 1) && ((x >= 0) && (x < N - 1))) {
                if (isSafe(x + 1, y)) { //south
                    cellStack.push(x + 1);
                    cellStack.push(y);
//                    x++;
//                    continue;
                }
                if (isSafe(x, y - 1)) { //west
                    cellStack.push(x);
                    cellStack.push(y - 1);
//                    y--;
//                    continue;
                }
                if (x != 0) {
                    if (isSafe(x - 1, y)) { //north
                        cellStack.push(x - 1);
                        cellStack.push(y);
//                        x--;
//                        continue;
                    }
                }
            }
            if ((x == N - 1) && ((y >= 0) && (y < N - 1))) {
                if (isSafe(x, y + 1)) { //east
                    cellStack.push(x);
                    cellStack.push(y + 1);
//                    y++;
//                    continue;
                }
                if (y != 0) {
                    if (isSafe(x, y - 1)) { //west
                        cellStack.push(x);
                        cellStack.push(y - 1);
//                        y--;
//                        continue;
                    }
                }
                if (isSafe(x - 1, y)) { //north
                    cellStack.push(x - 1);
                    cellStack.push(y);
//                    x--;
//                    continue;
                }
            }
            if (cellStack.isEmpty()) {
                return false;
            }
            if (!cellStack.isEmpty()) {
                while(!visited[x][y]){
                    y = cellStack.pop();
                    x = cellStack.pop();
                }
            }
            if ((x == (N - 1)) && (y == (N - 1))) {
                visited[x][y] = true;
                return true;
            }
        }
        return false;
    }
}
