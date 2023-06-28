import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MAX = 123456 * 2;
    static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        checkPrime();

        while (true) {
            int n = sc.nextInt();

            if (n == 0) break;

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }

    private static void checkPrime() {
        isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        int sqrt = (int) Math.sqrt(MAX);

        for (int i = 2; i <= sqrt; i++) {
            for (int j = i * i; j <= MAX; j++) {
                if (j % i == 0) {
                    isPrime[j] = false;
                }
            }
        }
    }
}