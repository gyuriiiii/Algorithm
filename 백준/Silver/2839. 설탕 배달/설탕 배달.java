import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;

        while (true) {
            if (n == 4 || n == 7) {
                result = -1;
                System.out.println(result);
                break;
            }
            if (n % 5 == 0) {
                result = n / 5;
                System.out.println(result);
                break;
            }
            if (n % 5 == 1 || n % 5 == 3) {
                result = (n / 5) + 1;
                System.out.println(result);
                break;
            }
            if (n % 5 == 2 || n % 5 == 4) {
                result = (n / 5) + 2;
                System.out.println(result);
                break;
            }
        }
    }
}