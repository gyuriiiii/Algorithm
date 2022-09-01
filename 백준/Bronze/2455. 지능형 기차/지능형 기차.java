import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            sum -= sc.nextInt();
            sum += sc.nextInt();

            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}