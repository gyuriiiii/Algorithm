import java.util.*;

public class Main {
    static int N, K;
    static int[] time; // 소요 시간
    static int minTime = Integer.MAX_VALUE;

    static HashMap<Integer, Integer> map = new HashMap<>();
    static String result = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 수빈이 위치
        K = sc.nextInt(); // 동생 위치

        if (N >= K) {
            System.out.println(N - K);

            for (int i = N; i >= K; i--) {
                System.out.print(i + " ");
            }
            return;
        }

        time = new int[100001];

        bfs(N);
        System.out.println(minTime);
        System.out.println(result);
    }

    private static void bfs(int n) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(n);

        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (time[now] >= minTime) continue;

            for (int i = 0; i < 3; i++) {
                int nx = 0;

                if (i == 0) { // 걷기 (x -1)
                    nx = now - 1;
                }
                if (i == 1) { // 걷기 (x + 1)
                    nx = now + 1;
                }
                if (i == 2) { // 순간이동 (2 * x)
                    nx = now * 2;
                }

                if (nx < 0 || nx >= K + 2) {
                    continue;
                }

                if (nx == K) {
                    minTime = time[now] + 1;
                    map.put(nx, now);

                    ArrayList<Integer> route = new ArrayList<>();
                    route.add(K);

                    for (int j = 0; j < minTime; j++) {
                        route.add(map.get(nx));
                        nx = map.get(nx);
                    }

                    String s = "";
                    for (int j = route.size() - 1; j >= 0; j--) {
                        s = s + " " + route.get(j);
                    }
                    result = s.trim();
                }

                if (time[nx] == 0 || time[nx] >= time[now] + 1) {
                    time[nx] = time[now] + 1;
                    map.put(nx, now);
                    dq.add(nx);
                }
            }
        }
    }
}