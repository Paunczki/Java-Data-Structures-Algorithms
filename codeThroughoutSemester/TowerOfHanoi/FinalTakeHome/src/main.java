public class main {
    public static void main(String[] args){
        long time1 = System.currentTimeMillis();

        readData r = new readData();
        r.question1(7397);
        r.question1(8263);
        System.out.println();
        r.question2(32);
        r.question2(10);
        System.out.println();
        r.question3("sam_vimes");
        r.question3("gromlakh");
        System.out.println();
        r.question4();
        System.out.println();

        long time2 = System.currentTimeMillis();
        System.out.println("Program took " + ((time2-time1)/1000.0) + " seconds");
    }
}
