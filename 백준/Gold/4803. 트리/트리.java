import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 1;

        while (true) {
            int n = sc.nextInt(); // 정점 개수
            int m = sc.nextInt(); // 간선 개수

            if (n == 0 && m == 0) {
                break;
            }

            adjList = new ArrayList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adjList[a].add(b);
                adjList[b].add(a);
            }

            visited = new boolean[n + 1];

            int tree = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (checkTree(i)) {
                        tree++;
                    }
                }
            }

            if (tree == 0) {
                System.out.printf("Case %d: No trees.\n", T++);
            }
            else if (tree == 1) {
                System.out.printf("Case %d: There is one tree.\n", T++);
            }
            else {
                System.out.printf("Case %d: A forest of %d trees.\n", T++, tree);
            }
        }
    }

    private static boolean checkTree(int idx) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(idx);

        int node = 0;
        int edge = 0;

        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            node++;

            for (int next : adjList[now]) {
                edge++;
                if (!visited[next]) {
                    dq.add(next);
                }
            }
        }

        // 트리인 경우
        if (edge == (node - 1) * 2) {
            return true;
        }
        return false;
    }
}