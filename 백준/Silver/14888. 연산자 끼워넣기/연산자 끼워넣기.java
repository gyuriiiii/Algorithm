import java.util.Scanner;

public class Main {
    static int N;
    static int[] number; // 숫자 배열
    static int[] op; // 연산자 배열

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 수의 개수
        number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }
        
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(num, MAX);
            MIN = Math.min(num, MIN);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) { // 연산자 남아있는 경우
                op[i]--;

                switch (i) {
                    case 0:
                        dfs(num + number[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - number[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * number[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / number[idx], idx + 1);
                        break;
                }
                op[i]++; // 연산자 개수 복구
            }
        }
    }
}