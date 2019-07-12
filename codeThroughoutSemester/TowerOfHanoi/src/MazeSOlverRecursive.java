public class MazeSOlverRecursive {
    private static int[][] maze = new int[4][4];
    private static boolean[][] visited = new boolean[4][4];
    private static int[][] visitedC = new int[4][4];
    public static void main(String[] args) {
        maze[0][0] = 1;maze[0][1] = 1;maze[0][2] = 0;maze[0][3] = 0;
        maze[1][0] = 0;maze[1][1] = 0;maze[1][2] = 0;maze[1][3] = 1;
        maze[2][0] = 0;maze[2][1] = 1;maze[2][2] = 1;maze[2][3] = 1;
        maze[3][0] = 1;maze[3][1] = 0;maze[3][2] = 1;maze[3][3] = 1;
        visited[0][0] = false;visited[0][1] = false;visited[0][2] = false;visited[0][3] = false;
        visited[1][0] = false;visited[1][1] = false;visited[1][2] = false;visited[1][3] = false;
        visited[2][0] = false;visited[2][1] = false;visited[2][2] = false;visited[2][3] = false;
        visited[3][0] = false;visited[3][1] = false;visited[3][2] = false;visited[3][3] = false;
        visitedC[0][0] = 0;visitedC[0][1] = 0;visitedC[0][2] = 0;visitedC[0][3] = 0;
        visitedC[1][0] = 0;visitedC[1][1] = 0;visitedC[1][2] = 0;visitedC[1][3] = 0;
        visitedC[2][0] = 0;visitedC[2][1] = 0;visitedC[2][2] = 0;visitedC[2][3] = 0;
        visitedC[3][0] = 0;visitedC[3][1] = 0;visitedC[3][2] = 0;visitedC[3][3] = 0;
//        solveMaze(0, 0);
//        printSolution();
        MazeRecursive maze1 = new MazeRecursive(4, maze);
        maze1.solveMaze(0,0);
        maze1.printSolution();
    }

    public static void printSolution(){
        if(visited[3][3] == false){
            System.out.println("No Solution was found");
        }
        for(int i=0;i<4;i++){
            for(int j=0; j<4; j++){
                if (visited[j][i] == true) {
                    System.out.print("X ");
                    continue;
                }
                System.out.print(maze[j][i] + " ");
            }
            System.out.print("\n");
        }
    }
    public static boolean isSafe(int x, int y){
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
    public static boolean solveMaze(int x, int y) {
        if((x == (3))&&(y==(3))) {
            visited[x][y]=true;
            return true;
        }
        else {
            if (isSafe(x, y)) {
                if(visitedC[x][y] > 4){
                    return false;
                }
                if(visited[x][y] == true){
                    visitedC[x][y]++;
                }
                visited[x][y] = true;
                try {
                    if ((y < (3)) && (x < (3))) {
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
                    if (y == (3)) {
                        if (solveMaze(x + 1, y)) { //south
                            return true;
                        }
                        if (solveMaze(x - 1, y)) { //north
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    if (x == (3)) {
                        if (solveMaze(x, y + 1)) { //east
                            return true;
                        }
                        if (solveMaze(x, y - 1)) { //west
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
        //System.out.println("Pizza");
        return false;
    }


//    public static void printSolution() {
//        if(visited[3][3] == false){
//            System.out.println("No Solution was found");
//        }
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if ((visited[j][i] == true)) {
//                    System.out.print("X ");
//                    continue;
//                }
//                System.out.print(maze[j][i] + " ");
//            }
//            System.out.print("\n");
//        }
//    }
//
//    public static boolean isSafe(int x, int y) {
//        if (maze[x][y] == 1) {
//            return true;
//        }
//        if (maze[x][y] == 0) {
//            return false;
//        } else {
//            System.out.println("Weird");
//            return false;
//        }
//    }
//    public static boolean solveMaze(int x, int y) {
//        if ((x == 3) && (y == 3)) {
//            visited[x][y] = true;
//            return true;
//        } else {
//            if (isSafe(x, y)) {
//                try {
//                    visited[x][y] = true;
//                    if (solveMaze(x, y + 1)) { //east
//                        return true;
//                    }
//                    if (solveMaze(x + 1, y)) { //south
//                        return true;
//                    }
//                    if (solveMaze(x, y - 1)) { //west
//                        return true;
//                    }
//                    if (solveMaze(x - 1, y)) { //north
//                        return true;
//                    }
//                }
//                catch (Exception e) {
//                    return false;
//                }
//            }
//            else {
//                return false;
//            }
//            return false;
//        }
//    }
}