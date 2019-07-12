public class main {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        ReadFiles dictionary = new ReadFiles();
        dictionary.readDictionary();
        dictionary.readTextFile();
        dictionary.readStopList();
        dictionary.removal();
        System.out.println(dictionary.textFile+"\n");

        dictionary.highestFrequency();
        System.out.println();
        dictionary.lowestFrequency();
        System.out.println();
        // Of course there are many words that have occurrence of one
        // but to print all of them would take a lot of time and memory
        // Instead here we have our 5 of the most and least frequently occurring words


        // Time complexity of course is O(n) because every iteration is one for loop
        //      running through all words in a file or extended data structure
        // Efficiency is lowered due to use of HashSets and HashMap, but the time
        //      complexity is much lower since the program takes four seconds to run
        // If there was much more data to go through HashSet would not be much better
        //      than say an ArrayList

        long time2 = System.currentTimeMillis();
        System.out.println("Time taken was " + ((time2-time1)/1000.0) + " seconds");
    }
}
