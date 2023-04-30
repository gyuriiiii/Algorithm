import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N;
    static int K;
    static int[] time;

    static int minTime = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 수빈이 위치
        K = sc.nextInt(); // 동생 위치
        time = new int[100001];

        if (N >= K) {
            System.out.println(N-K + "\n" + "1");
            return;
        }

        bfs(N);
        System.out.println(minTime + "\n" + cnt);
    }

    private static void bfs(int n) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.add(n); // 큐에 추가
        time[n] = 1;

        while (!dq.isEmpty()) { // 큐 빌 때 까지
            int now = dq.poll();

            if (minTime < time[now]) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int next = 0;

                if (i == 0) next = now - 1;
                else if (i == 1) next = now + 1;
                else if (i == 2) next = now * 2;

                if (next < 0 || next >= K + 2)
                    continue;


                if (next == K) { // 동생 위치에 도착
                    minTime = time[now];
                    cnt++;
                }

                if (time[next] == 0 || time[next] >= time[now] + 1) {
                    time[next] = time[now] + 1;
                    dq.add(next);
                }
            }
        }
    }
}