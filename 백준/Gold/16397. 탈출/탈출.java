import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, T, G;
    static int[] cnt;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = sc.nextInt();
        G = sc.nextInt();

        cnt = new int[100000];
        visited = new boolean[100000];

        bfs(N);
        if (result == Integer.MAX_VALUE) {
            System.out.println("ANG");
        }
        else {
            System.out.println(result);
        }
    }

    private static void bfs(int n) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(n);
        visited[n] = true;

        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (now == G) {
                result = cnt[now];
                return;
            }

            if (cnt[now] + 1 > T) {
                continue;
            }

            for (int i = 0; i < 2; i++) {
                if (i == 0) { // 버튼 A
                    int next = now + 1;
                    if (next >= 100000 || visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    dq.add(next);
                    cnt[next] = cnt[now] + 1;
                }

                else { // 버튼 B
                    int next = now * 2;
                    if (next == 0 || next >= 100000) {
                        continue;
                    }

                    next = (int) (next - Math.pow(10, Integer.toString(next).length() - 1));
                    if(!visited[next]) {
                        visited[next] = true;
                        dq.add(next);
                        cnt[next] = cnt[now] + 1;
                    }
                }
            }
        }
    }
}