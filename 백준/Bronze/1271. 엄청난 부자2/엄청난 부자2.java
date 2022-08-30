import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger(); // 조교가 가진 돈
        BigInteger m = sc.nextBigInteger(); // 생명체의 수
        
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}
