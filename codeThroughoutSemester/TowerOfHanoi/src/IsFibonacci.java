import java.math.BigInteger;
public class IsFibonacci {
    public boolean isFibonacci(int k){
        // Assumption, k is not negative
        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        // will use max index of 10000 because it is way out of range of int value for Fibonnaci
        for(int i=0; i<10000; i++) {
            if ((n2.intValue()) > k) {
                return false;
            }
            if (n2.intValue() == k) {
                return true;
            }
            sum = n1.add(n2);
            n1 = n2;
            n2 = sum;
        }
        return false;
    }
}
