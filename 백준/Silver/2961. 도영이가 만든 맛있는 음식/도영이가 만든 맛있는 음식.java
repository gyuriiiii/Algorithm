import java.util.Scanner;

public class Main {
    static int N;
    static Flavor[] flavor;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        flavor = new Flavor[N];

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int B = sc.nextInt();
            flavor[i] = new Flavor(S, B);
        }

        for (int i = 1; i <= N; i++) {
            arr = new int[i];
            backtracking(0, i, 0);
        }

        System.out.println(answer);
    }

    private static void backtracking(int cnt, int num, int idx) {
        if (cnt == num) {
            answer = Math.min(answer, calculate());
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[cnt] = i;
            backtracking(cnt + 1, num, i + 1);
        }
    }

    private static int calculate() {
        int sum_s = 1;
        int sum_b = 0;

        for (int i = 0; i < arr.length; i++) {
            sum_s *= flavor[arr[i]].S;
            sum_b += flavor[arr[i]].B;
        }

        return Math.abs(sum_s - sum_b);
    }

    private static class Flavor {
        int S;
        int B;

        public Flavor(int s, int b) {
            S = s;
            B = b;
        }
    }
}