import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] day = new int[n];

            for (int j = 0; j < n; j++) {
                day[j] = sc.nextInt();
            }

            int max = day[n - 1];
            long sum = 0;

            for (int j = n - 2; j >= 0; j--) {
                if (day[j] > max) {
                    max = day[j];
                }
                else {
                    sum += (max - day[j]);
                }
            }
            System.out.println(sum);
        }
    }
}