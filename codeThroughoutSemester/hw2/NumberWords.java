import java.util.*;  // for the Scanner class
public class NumberWords{
    public int counter =0;
    public static void main (String[] args){
        new NumberWords().run();
    } // main
    
    public void run(){        
        final String NUMBER_WORDS_MESSAGE = "\nAnswer: ";
        
        //Scanner sc = new Scanner ("805 17\n22z2\n-7\n395\nx 5\n0");
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<3; i++){
            
        }
        while ((sc.hasNext())&&(counter<3)){      
            System.out.println (NUMBER_WORDS_MESSAGE + getNumberWords (sc)); 
        }
    } // method run
    
    public String getNumberWords (Scanner sc){            
      try{
            String[ ] digitWords = {"zero ", "one ", "two ", "three ", "four ", 
                                    "five ", "six ", "seven ", "eight ", "nine "};                        
            
            int number = sc.nextInt(),
                saveNumber = number,
                digit;
            String sign = "",
                   numberWords = "";
            
            if (number < 0){
                sign = "minus ";
                number = -number;
            } // if negative number
            if (number == 0)
                numberWords = "zero ";                        
                                       
            while (number > 0){
                digit = number % 10;
                number = number / 10;  
                numberWords = digitWords [digit] + numberWords;               
            } // while
            counter=0;
            return Integer.toString (saveNumber) + " is " + sign +
                       numberWords;
      } // try
      catch (InputMismatchException e){
            String next = sc.next();
            if(next.equals("done")){
                System.exit(0);
            }
            counter++;
            if(counter == 3){
                System.out.println("Maximum number of attempts exceeded");
                System.exit(0);
            }
            return  e.toString() + ": " + next +   " is not an int.";      
      } // catch InputMismatchException
    } // method getNumberWords
}  // class NumberWords