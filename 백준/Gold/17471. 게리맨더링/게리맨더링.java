import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] people, area;
    static boolean[][] connect;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        people = new int[N + 1]; // 각 구역의 인원수
        area = new int[N + 1]; // 각 구역에 할당된 선거구
        connect = new boolean[N + 1][N + 1]; // 구역 간 연결 표시 배열

        for (int i = 1; i < N + 1; i++) {
            people[i] = sc.nextInt();
        }

        for (int i = 1; i < N + 1; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                int n = sc.nextInt();
                connect[i][n] = connect[n][i] = true;
            }
        }

        dfs(1);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static void dfs(int k) {
        if (k == N + 1) {
            int area1 = 0;
            int area2 = 0;

            for (int i = 1; i < N + 1; i++) {
                if (area[i] == 1)
                    area1 += people[i];
                else if (area[i] == 2)
                    area2 += people[i];
            }

            visited = new boolean[N + 1];
            int link = 0; // 선거구 개수

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i]) {
                    bfs(i);
                    link++;
                }
            }

            if (link == 2) {
                answer = Math.min(answer, Math.abs(area1 - area2));
            }
            return;
        }

        // 1번 선거구 할당
        area[k] = 1;
        dfs(k + 1);

        // 2번 선거구 할당
        area[k] = 2;
        dfs(k + 1);
    }

    private static void bfs(int idx) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(idx);
        visited[idx] = true;

        while (!dq.isEmpty()) {
            int now = dq.poll();

            for (int i = 1; i < N + 1; i++) {
                if (visited[i])
                    continue;

                if (connect[now][i] && area[i] == area[idx]) {
                    visited[i] = true;
                    dq.add(i);
                }
            }
        }
    }
}