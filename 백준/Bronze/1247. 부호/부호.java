import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int n = sc.nextInt();
            
            BigInteger sum = new BigInteger("0");

            for (int j = 0; j < n; j++) {
                sum = sum.add(sc.nextBigInteger());
            }

            if(sum.compareTo(BigInteger.ZERO) == 0) {
                sb.append("0").append('\n');
            }
            else if(sum.compareTo(BigInteger.ZERO) == -1) {
                sb.append("-").append('\n');
            }
            else {
                sb.append("+").append('\n');
            }
        }
        System.out.print(sb);
    }
}