public class Watch {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();

        // Time Complexity throughout is O(n) because looping through set values --> O(1)
        // Stack is O(1) for all functions
        // Checking through each if/else statement and parse string to int or vice versa --> O(1)
        // the while loop that loops through all elements in my stack is O(1440)
        // because this is max combinations of time and overall O(1)

        Solution solve = new Solution();
        System.out.println(solve.solution("11:01")); // 11:00
        System.out.println(solve.solution("11:10")); // 11:01
        System.out.println(solve.solution("11:13")); // 11:11
        System.out.println(solve.solution("22:22")); // 22:22
        System.out.println(solve.solution("23:41")); // 23:34
        System.out.println(solve.solution("00:00")); // 00:00
        System.out.println(solve.solution("23:59")); // 23:55
        System.out.println(solve.solution("12:14")); // 12:12
        System.out.println(solve.solution("06:23")); // 06:22



        long time2 = System.currentTimeMillis();
        System.out.println("Program took " + ((time2-time1)/1000.0) + " seconds");
    }
}
