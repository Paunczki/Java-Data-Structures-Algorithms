import java.math.BigInteger;
public class Fibonacci {
    public static void main(String[] args){
        System.out.println(recFib(6));
        System.out.println(recBigFib(6));
    }
    public static long Fib(int n){
        //yourBigInteger.add();
        //then .toString();
        long prev1 = 1;
        long prev2 = 1;
        long next = 0;
        for(int i=2; i<=n; i++){
            next = prev1 + prev2;
            prev1 = prev2;
            prev2 = next;
        }
        return next;
    }
    public static String BigFib(int n){
        BigInteger prev1 = new BigInteger("1");
        //BigInteger prev1 = BigInteger.ONE;
        BigInteger prev2 = BigInteger.ONE;
        BigInteger next = BigInteger.ZERO;
        for(int i=2; i<=n; i++) {
            next = prev1.add(prev2);
            prev1 = prev2;
            prev2 = next;
        }
        return next.toString();
    }
    public static int recFib(int n){
        if(n<2){
            return 1;
        }
        else{
            return (recFib(n-1)+recFib(n-2));
        }
    }
    public static BigInteger recBigFib(int n){
        if(n<2){
            return (BigInteger.ONE);
        }
        else{
            return (recBigFib(n-1).add(recBigFib(n-2)));
        }
    }
}
