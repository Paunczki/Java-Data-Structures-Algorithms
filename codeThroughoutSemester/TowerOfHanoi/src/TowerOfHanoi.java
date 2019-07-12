import java.util.*;

public class TowerOfHanoi {
    public static void TOH(int n, char origin, char temp, char dest) {
        if (n==1) System.out.println("move "+ origin+" to "+dest);
        else {
            TOH(n-1, origin, dest, temp);
            System.out.println("move "+ origin+" to "+dest);
            TOH(n-1, temp, origin, dest);
        }
    }



}