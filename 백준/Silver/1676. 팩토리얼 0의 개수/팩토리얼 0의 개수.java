import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        BigInteger sum = new BigInteger("1");
        for(int i=1; i<=n; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }

        int result = 0;
        while(true) {
            BigInteger num = sum.remainder(new BigInteger("10"));

            if(num.equals(new BigInteger("0"))) {
                result++;
            }
            else {
                break;
            }
            sum = sum.divide(new BigInteger("10"));
        }
        System.out.println(result);
    }
}