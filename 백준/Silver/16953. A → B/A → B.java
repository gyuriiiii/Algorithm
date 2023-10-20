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

    private static void dfs(int cnt, long a,long b) {
        if (a > b) {
            return;
        }

        if (a == b) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                dfs(cnt + 1, a * 2, b);
            }
            else {
                a = Long.parseLong(Long.toString(a) + "1");
                dfs(cnt + 1, a, b);
            }
        }
    }
}