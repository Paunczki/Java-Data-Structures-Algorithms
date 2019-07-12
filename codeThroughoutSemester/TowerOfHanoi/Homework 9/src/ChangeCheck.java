import java.io.*;
import java.util.*;

public class ChangeCheck {
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println(rangeCheck(10179,1506000000));
        // 27170
    }
    public static boolean rangeCheck(int a, int b) throws FileNotFoundException {
        File file = new File("/Users/JohnMikos/IdeaProjects/TowerOfHanoi/Homework 9/writeReferences5");
        Scanner scanner = new Scanner(file);
        String temp = "";
        HashMap<Double, Integer> map = new HashMap<>();;
        boolean pizza = false;
        while(scanner.hasNextLine()) {
            temp = scanner.nextLine();
            String[] split = temp.split("  |  ");
            if((Double.parseDouble(split[2]) < a)||(Double.parseDouble(split[2]) > b)) {
                continue;
            }
            if(map.containsKey(Double.parseDouble(split[2]))) {
                int n = map.get(Double.parseDouble(split[2]))+1;
                map.put(Double.parseDouble(split[2]), n);
            }
            else {
                map.put(Double.parseDouble(split[2]), 1);
            }
//			for(int i=2; i<split.length; i++) {
//				if((Double.parseDouble(split[2]) > a) && (Double.parseDouble(split[2]) < b)) {
//					System.out.println(split[2]);
//					pizza =true;
//				}
//			}
        }
        System.out.println(map.size());
        return true;
    }
}
