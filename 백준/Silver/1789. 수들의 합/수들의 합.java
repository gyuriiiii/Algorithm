import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();
        long sum = 0;
        long result = 0;

        for (int i = 1; i <= S; i++) {
            sum += i;

            if (sum > S) {
                break;
            }
            result = i;
        }

        System.out.println(result);
    }
}