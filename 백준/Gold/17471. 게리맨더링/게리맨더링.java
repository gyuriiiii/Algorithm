import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] people;
    static int[] area;
    static int[][] map;

    static boolean[] visited;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 구역의 개수

        people = new int[N + 1]; // 구역의 인원수
        area = new int[N + 1]; // 각 구역의 선거구 저장 (1, 2 선거구)
        map = new int[N + 1][N + 1]; // 구역 간 인접 표시 배열

        result = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            people[i] = sc.nextInt();
        }

        // 각 구역과 인접한 구역 정보
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                int n = sc.nextInt();
                // 인접한 구역 1로 표시 (양방향)
                map[i][n] = 1;
            }
        }

        // 선거구 할당
        dfs(1);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }

    // 선거구 할당
    private static void dfs(int k) {
        // 모든 지역 할당한 경우
        if (k == N + 1) {
            int area1 = 0; // 1번 선거구
            int area2 = 0; // 2번 선거구

            // 각 선거구 인원수 구하기
            for (int i = 1; i <= N; i++) {
                if (area[i] == 1) {
                    area1 += people[i];
                }
                else {
                    area2 += people[i];
                }
            }

            visited = new boolean[N + 1]; // 각 구역 방문 여부 배열
            int link = 0; // 선거구 개수

            // 선거구의 구역들이 모두 연결돼있는지 확인
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) { // 아직 방문하지 않은 구역
                    bfs(i, area[i]);
                    link++;
                }
            }

            if (link == 2) {
                result = Math.min(result, Math.abs(area1 - area2));
            }
            return;
        }

        area[k] = 1;
        dfs(k + 1);

        area[k] = 2;
        dfs(k + 1);
    }

    // 선거구의 구역이 모두 연결돼있는지 확인
    // 선거구 같고, 구역들이 연결돼있어야 함
    private static void bfs(int idx, int areaNum) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        visited[idx] = true;
        dq.add(idx);

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            for (int i = 1; i <= N; i++) {
                if (visited[i]) { // 아직 방문 X
                    continue;
                }

                if (map[cur][i] == 1 && area[i] == areaNum) { // 선거구 같고, 서로 연결된 구역인 경우
                    visited[i] = true; // 방문 표시
                    dq.add(i);
                }
            }
        }
    }
}