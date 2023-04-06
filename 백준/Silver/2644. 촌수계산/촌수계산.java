import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] relate;
    static boolean[] visited;

    static int p2;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 전체 사람 수
        relate = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        int p1 = sc.nextInt();
        p2 = sc.nextInt();

        int m = sc.nextInt(); // 부모-자식 관계 개수
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(); // 부모 
            int y = sc.nextInt(); // 자식

            relate[x][y] = 1;
            relate[y][x] = 1;
        }

        bfs(p1);
        if (result[p2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result[p2]);
        }
    }

    // p1 과 p2의 촌수 계산
    private static void bfs(int person) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        visited[person] = true;
        dq.add(person);

        while (!dq.isEmpty()) {
            int p = dq.poll();

            if (p == p2) {
                break;
            }

            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }

                if (relate[p][i] == 1) {
                    visited[i] = true;
                    dq.add(i);
                    result[i] = result[p] + 1;
                }
            }
        }
    }
}