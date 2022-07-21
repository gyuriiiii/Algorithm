import java.util.Scanner;

public class Main {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        System.out.print(Math.abs(n-m));
    }
}
