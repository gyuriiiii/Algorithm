import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, K, M;
    static int result = -1;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        M = Integer.toString(N).length();

        visited = new boolean[1000001][K + 1];

        bfs(N);
        System.out.println(result);
    }

    private static void bfs(int n) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(n, 0));
        visited[n][0] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.cnt == K) {
                result = Math.max(result, now.num);
                continue;
            }

            for (int i = 0; i < M; i++) {
                for (int j = i + 1; j < M; j++) {
                    int num = swap(now.num, i, j);

                    if (Integer.toString(num).length() < M) {
                        continue;
                    }

                    if (!visited[num][now.cnt + 1]) {
                        visited[num][now.cnt + 1] = true;
                        dq.add(new Node(num, now.cnt + 1));
                    }
                }
            }
        }
    }

    private static int swap(int now, int i, int j) {
        char[] num = Integer.toString(now).toCharArray();

        char tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;

        return Integer.parseInt(new String(num));
    }

    static public class Node {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}