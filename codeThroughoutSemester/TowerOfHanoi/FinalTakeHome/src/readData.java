import java.util.*;
import java.io.*;
public class readData {
    private String fileName;
    private HashMap<Integer, ArrayList<Integer>> votePos;
    private HashMap<Integer, ArrayList<Integer>> voteNeu;
    private HashMap<Integer, ArrayList<Integer>> voteOpp;
    private HashMap<Integer, Stack<Integer>> nominators;
    private HashMap<Integer, String> screenNames;
    private HashMap<Integer, ArrayList<Integer>> promotion;
    public readData(){
        fileName = "/Users/JohnMikos/IdeaProjects/TowerOfHanoi/FinalTakeHome/wikiElec.txt";
        votePos = new HashMap<>();
        voteNeu = new HashMap<>();
        voteOpp = new HashMap<>();
        screenNames = new HashMap<>();
        nominators = new HashMap<>();
        promotion = new HashMap<>();
        read();
    }
    public void read(){
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            String temp = ""; String test = "";
            while (scanner.hasNextLine()) {
                temp = scanner.nextLine();
                test=temp.substring(0,1);
                String[] apple = temp.split("\t");
                int success = -1;
                try {
                    success = Integer.parseInt(apple[1]);
                }
                catch(Exception e){
                    continue;
                }
                if(test.equals("E")){
                    String temp2 = ""; String test2 = "";
                    int voted; int idInfo; String sN = ""; int forPromotion = -2;
                    while(scanner.hasNextLine()) {
                        temp2 = scanner.nextLine();
                        try {
                            test2 = temp2.substring(0, 1);
                        } catch (Exception e) {
                            break;
                        }
                        String[] apples = temp2.split("\t");
                        if (test2.equals(" ")) break;
                        if (test2.equals("T")) continue;
                        if (test2.equals("U")) {
                            forPromotion = Integer.parseInt(apples[1]);
                            screenNames.put(forPromotion, apples[2]);
                            nominators.put(forPromotion, new Stack<>());
                            promotion.put(forPromotion, new ArrayList<>());
                            promotion.get(forPromotion).add(success);
                            promotion.get(forPromotion).add(0);
                            promotion.get(forPromotion).add(0);
                            promotion.get(forPromotion).add(0);
                        }
                        if (test2.equals("N")) {
                            if (forPromotion == -2) {
                                System.out.println("Error 2");
                                break;
                            }
                            int nominator = Integer.parseInt(apples[1]);
                            nominators.get(forPromotion).push(nominator);
                            screenNames.put(nominator, apples[2]);
                        }
                        if (test2.equals("V")) {
                            if (forPromotion == -2) {
                                System.out.println("Error 4");
                                break;
                            }
                            voted = Integer.parseInt(apples[1]);
                            idInfo = Integer.parseInt(apples[2]);
                            sN = apples[4];
                            screenNames.put(idInfo, sN);
                            if (voted == 1) {
                                if (votePos.containsKey(idInfo)) {
                                    votePos.get(idInfo).add(forPromotion);
                                } else {
                                    votePos.put(idInfo, new ArrayList<>());
                                    votePos.get(idInfo).add(forPromotion);
                                }
                                int voteAdd1 = (promotion.get(forPromotion).get(1))+1;
                                promotion.get(forPromotion).set(1,voteAdd1);
                            }
                            if (voted == 0) {
                                if (voteNeu.containsKey(idInfo)) {
                                    voteNeu.get(idInfo).add(forPromotion);
                                } else {
                                    voteNeu.put(idInfo, new ArrayList<>());
                                    voteNeu.get(idInfo).add(forPromotion);
                                }
                                int voteAdd2 = (promotion.get(forPromotion).get(2))+1;
                                promotion.get(forPromotion).set(2,voteAdd2);
                            }
                            if (voted == -1) {
                                if (voteOpp.containsKey(idInfo)) {
                                    voteOpp.get(idInfo).add(forPromotion);
                                } else {
                                    voteOpp.put(idInfo, new ArrayList<>());
                                    voteOpp.get(idInfo).add(forPromotion);
                                }
                                int voteAdd3 = (promotion.get(forPromotion).get(3))+1;
                                promotion.get(forPromotion).set(3,voteAdd3);
                            }
                        }
                    }
                }
                else{
                    continue;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error 1");
        }
    }
    public void question1(int userID){
        String sN = screenNames.get(userID);
        int posVotes; int neuVotes; int oppVotes;
        if(votePos.get(userID) == null){
            posVotes = 0;
        }
        else posVotes = votePos.get(userID).size();
        if(voteNeu.get(userID) == null){
            neuVotes = 0;
        }
        else neuVotes = voteNeu.get(userID).size();
        if(voteOpp.get(userID) == null){
            oppVotes = 0;
        }
        else oppVotes = voteOpp.get(userID).size();
        System.out.println(sN + " has voted positively " + posVotes + " times, " +" neutrally " + neuVotes
                + " times, and opposingly " + oppVotes + " times");
    }
    public void question2(int userID){
        String sN = screenNames.get(userID);
        if(nominators.containsKey(userID)){
            System.out.print(sN + " was nominated by ");
            int counter = 0; String nominate;
            while(!nominators.get(userID).isEmpty()){
                nominate = screenNames.get(nominators.get(userID).peek());
                if(counter>0){
                    System.out.print(", " + nominate);
                }
                else{
                    System.out.print(nominate);
                }
                nominators.get(userID).pop();
                counter++;
            }
            System.out.print("\n");
        }
        else{
            System.out.println("The person was never nominated");
        }
    }
    public void question3(String sN){
        int neededKey = -2;
        for(int key: screenNames.keySet()){
            if(screenNames.get(key).equals(sN)){
                neededKey = key;
            }
        }
        if(neededKey == -2){
            System.out.println(sN + " was never considered for a promotion");
        }
        else{
            int promoted = promotion.get(neededKey).get(0);
            String answer= "N/A";
            if(promoted == 0){
                answer = "was not promoted";
            }
            if(promoted == 1){
                answer = "was promoted";
            }
            int posV = promotion.get(neededKey).get(1);
            int neuV = promotion.get(neededKey).get(2);
            int oppV = promotion.get(neededKey).get(3);
            System.out.println(sN + " received " + posV + " votes in support, " + neuV + " neutral votes, and "
                    + oppV + " votes in opposition. " + sN + " " + answer);
        }
    }
    public void question4(){
        ArrayList<Integer> vots= new ArrayList<>();
        for(int key: screenNames.keySet()){
            try {
                if (voteOpp.get(key).size() > 0) {
                    vots.add(key);
                }
            }
            catch(NullPointerException e){
                continue;
            }
        }
        String p; String r; String pair; int counter=0;
        ArrayList<String> pairs = new ArrayList<>();
        for(int q: vots){
            p = screenNames.get(q);
            for(int v: vots){
                r = screenNames.get(v);
                if(p.compareTo(r) < 0) {
                    if((voteOpp.get(q).contains(v))&&(voteOpp.get(v).contains(q))){
                        pair = p + " and " + r;
                        counter++;
                        pairs.add(pair);
                    }
                }
            }
        }
        System.out.println("The pairs of users who voted against each other are... ");
        int counter2 = 0;
        for(int i=0; i<pairs.size(); i++){
            if(counter2>0){
                System.out.print((", ")+pairs.get(i));
            }
            else{
                System.out.print(pairs.get(i));
            }
            counter2++;
        }
        System.out.println("\nIn total there are " + counter + " pairs of users who voted against each other");

    }
}

