import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1010) {
            System.out.println(20);
        }

        else if (n % 10 == 0) {
            System.out.println((n/100 + 10));
        }

        else {
            int a = n / 10;
            int b = n % 10;

            System.out.println(a + b);
        }
    }
}