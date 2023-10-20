import java.util.Scanner;

public class Main {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        dfs(1, A, B);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static void dfs(int cnt, long a, long b) {
        if (a > b) {
            return;
        }

        if (a == b) {
            answer = cnt;
            return;
        }

        dfs(cnt + 1, a * 2, b);
        dfs(cnt + 1, a * 10 + 1, b);
    }
}