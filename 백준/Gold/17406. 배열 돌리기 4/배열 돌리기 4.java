import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int K;
    static int[][] map;
    static int[][] tmpMap;
    static boolean[] visited;

    static ArrayList<XY> list = new ArrayList<>();
    static ArrayList<char[]> order = new ArrayList<>();

    public static class XY {
        int x1;
        int y1;
        int x2;
        int y2;

        public XY(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt(); // 회전 연산의 개수

        map = new int[N + 1][M + 1];
        tmpMap = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[K];

        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();

            int x1 = r - s;
            int y1 = c - s;
            int x2 = r + s;
            int y2 = c + s;

            list.add(new XY(x1, y1, x2, y2));
        }

        // 회전 연산순서의 모든 경우의 수 구하기
        dfs(0, " ");

        int min = Integer.MAX_VALUE; // 배열의 최솟값
        for (int i = 0; i < order.size(); i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < M + 1; k++) {
                    tmpMap[j][k] = map[j][k];
                }
            }

            char[] o = order.get(i);

            for (int j = 0; j < o.length; j++) {
                int x1 = list.get(Integer.parseInt(o[j] + "")).x1;
                int y1 = list.get(Integer.parseInt(o[j] + "")).y1;
                int x2 = list.get(Integer.parseInt(o[j] + "")).x2;
                int y2 = list.get(Integer.parseInt(o[j] + "")).y2;

                while (x1 < x2 && y1 < y2) {
                    rotate(x1, y1, x2, y2);

                    x1++;
                    y1++;
                    x2--;
                    y2--;
                }
            }
            min = Math.min(min, getSum());
        }
        System.out.println(min);
    }

    private static int getSum() {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            int sum = 0;
            for (int j = 1; j < M + 1; j++) {
                sum += tmpMap[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    private static void dfs(int cnt, String s) {
        if (cnt == K) {
            order.add(s.trim().toCharArray());
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cnt + 1, s + i);
                visited[i] = false;
            }
        }
    }

    private static void rotate(int x1, int y1, int x2, int y2) {
        int tmp = tmpMap[x1][y1];

        // 위
        for (int i = x1 + 1; i <= x2; i++) {
            tmpMap[i - 1][y1] = tmpMap[i][y1];
        }

        // <-
        for (int i = y1; i <= y2 - 1; i++) {
            tmpMap[x2][i] = tmpMap[x2][i + 1];
        }

        // 아래
        for (int i = x2; i >= x1 + 1; i--) {
            tmpMap[i][y2] = tmpMap[i - 1][y2];
        }

        // ->
        for (int i = y2; i >= y1 + 1; i--) {
            tmpMap[x1][i] = tmpMap[x1][i - 1];
        }

        tmpMap[x1][y1 + 1] = tmp;
    }
}