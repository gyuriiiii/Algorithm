import java.util.Scanner;

public class Main {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();
        long max = Math.max(n, m);
        long min = Math.min(n, m);

        System.out.print(max-min);
    }
}
