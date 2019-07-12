//Question 4
public class Matrices {
    public void rowSums(int[][] arr){
        for(int i=0; i<arr.length; i++){
            int temp = 0;
            for(int j=0; j<arr[i].length; j++){
                temp += arr[i][j];
            }
            if(i == arr.length-1){
                System.out.print(temp + "\n");
            }
            else {
                System.out.print(temp + ", ");
            }
        }
    }
    public void columnMins(int[][] arr){
        for(int i=0; i<arr.length; i++){
            int smallest = Integer.MAX_VALUE;
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] < smallest){
                    smallest = arr[i][j];
                }
            }
            if(i == arr.length-1){
                System.out.print(smallest + "\n");
            }
            else {
                System.out.print(smallest + ", ");
            }
        }
    }
}
