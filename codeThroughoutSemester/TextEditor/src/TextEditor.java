import java.util.*;
import java.io.*;
public class TextEditor {
    private ArrayList<String> textFile;
    private ArrayList<String> wordList;
    private String dictionaryFile = "EnglishWordList.txt";
    private String textFileName = "BillyGoatGruff.txt";
    private int response;
    private String saveFileName;
    public static void main(String[] args) throws IOException {
        fileDictionary();
        TextEditor t1 = new TextEditor();
        t1.navigation();
        TextEditor t2 = new TextEditor("alcott-little-261.txt");
        t2.navigation();
    }

    public TextEditor() throws IOException {
        textFile = new ArrayList<>();
        wordList = new ArrayList<>();
        readTextFile("BillyGoatGruff.txt");
        saveFileName = "saveFile.txt";
    }
    public TextEditor(String file) throws IOException{
        textFile = new ArrayList<>();
        wordList = new ArrayList<>();
        readTextFile(file);
        saveFileName = "saveFile";
    }

    private static ArrayList<String> words = new ArrayList<>();
    private static int duplicates = 0;
    public static void fileDictionary(){
        Scanner reader = null;
        try{
            reader = new Scanner(new File("EnglishWordList.txt"));
        }
        catch (FileNotFoundException ex){
            System.out.println(ex + " file not found ");
        }
        while(reader.hasNext()){
            String str = reader.nextLine();
            if(!words.contains(str)){
                words.add(str);
            }
            else{
                duplicates++;
            }
        }
    }
    public void readTextFile(String t) {
        String line = null;
        String textFileName = t;
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(textFileName));
            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                String[] wordsInLine = line.split(" ");
                for (int i = 0; i < wordsInLine.length; i++) {
                    textFile.add(wordsInLine[i]);
                }
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        for(int i=0; i<textFile.size(); i++){
            String temp;
            temp = textFile.get(i).toLowerCase();
            String s;
            s = temp.replaceAll("[\\[\\]_:\"'`?;\\”0-9—;“()-/.,*! ]", "").trim().toLowerCase();
            wordList.add(s);
        }
    }

    public void navigation() throws FileNotFoundException {
        boolean pizza = true;
        while(pizza) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Hello User, welcome to a basic text editor. \n" +
                    "Please enter the number designated to the command you would like to completed. \n" +
                    "1. find\n" +
                    "2. findReplace \n" +
                    "3. findReplaceAll \n" +
                    "4. findInsert \n" +
                    "5. delete \n" +
                    "6. spellCheck \n" +
                    "7. spellCheckAll \n" +
                    "8. save \n" +
                    "9. print \n" +
                    "10.quit \n");
            setResponse(keyboard.next());
            if (getResponse() == 1) {
                System.out.print("What word are you searching for: ");
                String input = keyboard.next();
                find(input);
            }
            if (getResponse() == 2) {
                System.out.println("This will only replace the first instance of your desired word");
                System.out.print("What word are you looking to replace: ");
                String input1 = keyboard.next();
                System.out.print("What word do you want to replace it with: ");
                String input2 = keyboard.next();
                findReplace(input1, input2);
            }
            if (getResponse() == 3) {
                System.out.println("This will replace all instances of your desired word");
                System.out.print("What word are you looking to replace: ");
                String input1 = keyboard.next();
                System.out.print("What word do you want to replace it with: ");
                String input2 = keyboard.next();
                findReplaceAll(input1, input2);
            }
            if (getResponse() == 4) {
                System.out.print("What word do you want to insert: ");
                String input1 = keyboard.next();
                System.out.print("Where do you want to insert the word (will insert your desired word " +
                        "after the first occurrence of this word): ");
                String input2 = keyboard.next();
                findInsert(input2, input1);
            }
            if (getResponse() == 5) {
                System.out.println("This will only delete the first instance of your desired word");
                System.out.print("What word do you want to delete: ");
                String input = keyboard.next();
                delete(input);
            }
            if (getResponse() == 6) {
                spellCheck();
            }
            if (getResponse() == 7) {
                spellCheckAll();
            }
            if (getResponse() == 8) {
                save();
            }
            if (getResponse() == 9) {
                print();
            }
            if (getResponse() == 10) {
                pizza = false;
            }
        }
    }

    public boolean find(String x){
        //  Looks for a word "x" in the file and returns true if found or false otherwise
        for(int i=0; i<textFile.size(); i++){
            if(textFile.get(i).equals(x)){
                System.out.println(x + " was found!");
                return true;
            }
        }
        System.out.println(x + " was not found");
        return false;
    }
    public boolean findReplace(String x, String y){
        //  looks for the first occurrence of word "x" in the file and replaces it with word "y"
        //  if found returning true, false otherwise
        for(int i=0; i<textFile.size(); i++){
            if(textFile.get(i).equals(x)){
                textFile.remove(i);
                textFile.add(i,y);
                System.out.println(x + " was found! And replaced with " + y);
                return true;
            }
        }
        System.out.println(x + " was not found, no replacement done");
        return false;
    }
    public boolean findReplaceAll(String x, String y){
        //  looks for all occurrences of word "x" in the file and replace each with word "y"
        //  if found returning true, false otherwise
        int instance = 0;
        for(int i=0; i<textFile.size(); i++){
            if(textFile.get(i).equals(x)){
                textFile.remove(i);
                textFile.add(i,y);
                instance++;
            }
        }
        if(instance > 0){
            System.out.println("All " + x + " was found! And replaced with " + y);
            return true;
        }
        System.out.println(x + " was not found, no replacement done");
        return false;
    }
    public boolean findInsert(String x, String y){
        //  looks for the first occurrence of word "x" in the file and then insert "y" right after "x",
        //  if x is found, returning true, false otherwise
        for(int i=0; i<textFile.size(); i++){
            if(textFile.get(i).equals(x)){
                textFile.add((i+1),y);
                System.out.println(y + " was inserted after " + x);
                return true;
            }
        }
        System.out.println(x + " was not found, no insertion completed");
        return false;
    }
    public boolean delete(String x){
        //  looks for the first occurrence of word "x" in the file and deletes it from the file,
        //  returning true if x is found, returning false otherwise.
        for(int i=0; i<textFile.size(); i++){
            if(textFile.get(i).equals(x)){
                textFile.remove(i);
                System.out.println(x + " was found, deletion completed");
                return true;
            }
        }
        System.out.println(x + " was not found");
        return false;
    }
    public String spellCheck(){
        //  finds the first occurrence of spelling error and returns the misspelled word
        //  If no word is misspelled returns "Spell Check Passed"
        for(int i=0; i<wordList.size(); i++){
            if(!words.contains(wordList.get(i))){
                System.out.println("Misspelled word found: " + textFile.get(i));
                return wordList.get(i);
            }
        }
        System.out.println("Spell Check Passed");
        return "Spell Check Passed";
    }
    public void spellCheckAll(){
        //  find all misspelled words and output them to the screen
        int k=0;
        String misspelled = "";
        for(int i=0; i<wordList.size(); i++){
            if(!words.contains(wordList.get(i))){
                misspelled += wordList.get(i) + " ";
            }
        }
        System.out.println("Misspelled words present... ");
        System.out.print(misspelled);
    }
    public void save() {
        //  saves file with the changes made.
        FileWriter fw;
        try{
            fw = new FileWriter(new File(saveFileName));
            int instances = 0;
            for(int l=0; l<textFile.size(); l++){
                fw.write((textFile.get(l)) + " ");
                instances++;
                if(instances > 10){
                    instances = 0;
                    fw.write("\n");
                }
            }
            System.out.println("File was saved");
            fw.close();
        }
        catch (IOException e){
            System.out.println("File was not saved :(");
            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("File was not completely saved");
        }
    }
    public void print() {
        //  saves file with the changes and outputs the contents of the file to the screen
        save();
        int instances = 0;
        for(int k=0; k<textFile.size(); k++){
            System.out.print(textFile.get(k) + " ");
            instances++;
            if(instances > 10){
                System.out.println("");
                instances = 0;
            }
        }
    }
    public void quit() {
        save();
        System.exit(0);
        //  should save() the file and exit
    }

    public void setResponse(String s) throws NumberFormatException {
        Scanner key = new Scanner(System.in);
        boolean pizza = false;
        while(!pizza) {
            try {
                s = "0"+s;
                int w = Integer.parseInt(s);
                if((w < 1)||(w > 10)) {
                    while ((w < 1)||(w > 10)) {
                        System.out.println("Not a valid response");
                        System.out.print("Please try again: ");
                        s = key.next();
                        s = "0"+s;
                        w = Integer.parseInt(s);
                    }
                    response = w;
                    pizza = true;
                }
                if((w >= 1)&&(w <= 10)) {
                    response = w;
                    pizza = true;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a integer: ");
                s = key.next();
                continue;
            }
        }
    }
    public int getResponse() {
        return response;
    }
}
