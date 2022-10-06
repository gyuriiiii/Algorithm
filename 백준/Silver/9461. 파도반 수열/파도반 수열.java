import java.util.Scanner;

public class Main {
    static long[] p = new long[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        p[0] = 0;
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            System.out.println(dp(N));
        }
    }

    public static long dp(int n) {
        if (p[n] == 0) {
            p[n] = dp(n - 2) + dp(n - 3);
        }
        return p[n];
    }
}