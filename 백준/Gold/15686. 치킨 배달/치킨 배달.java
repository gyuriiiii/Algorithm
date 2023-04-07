import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;

    static ArrayList<int[]> home;
    static ArrayList<int[]> chicken;
    static boolean[] closed;

    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt(); // 폐업시키지 않을 치킨집 개수

        map = new int[N][N];

        home = new ArrayList<>(); // 집 위치
        chicken = new ArrayList<>(); // 치킨집 위치

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) { // 집
                    home.add(new int[]{i, j});
                }

                if (map[i][j] == 2) { // 치킨집
                    chicken.add(new int[]{i, j});
                }
            }
        }
        closed = new boolean[chicken.size()]; // 치킨집 폐업 여부

        result = Integer.MAX_VALUE;

        dfs(0, 0, chicken.size() - M);
        System.out.println(result);
    }

    // close = 현재 폐업한 가게 개수
    // total = 최대로 폐업 가능한 가게 개수
    private static void dfs(int start, int close, int total) {
        if (close == total) {
            int sum = 0;

            for (int i = 0; i < home.size(); i++) {
                int dis = Integer.MAX_VALUE;
                int h[] = home.get(i);

                for (int j = 0; j < chicken.size(); j++) {
                    if (!closed[j]) { // 치킨집 폐업하지 않은 경우만
                        int c[] = chicken.get(j);

                        dis = Math.min(dis, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                    }
                }
                sum += dis;
            }
            result = Math.min(sum, result);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!closed[i]) {
                closed[i] = true; // 치킨집 폐업

                dfs(i + 1, close + 1, total);
                closed[i] = false; // 치킨집 복구
            }
        }
    }
}