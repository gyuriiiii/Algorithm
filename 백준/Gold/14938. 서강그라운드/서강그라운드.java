import java.util.Scanner;

public class Main {
    static final int INF = 987654321;
    static int[][] dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 지역 개수
        int m = sc.nextInt(); // 수색 범위
        int r = sc.nextInt(); // 길의 개수

        int[] item = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            item[i] = sc.nextInt();
        }

        dis = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != j) {
                    dis[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();
            dis[a][b] = l;
            dis[b][a] = l;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        int maxItem = 0;

        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                if (dis[i][j] <= m) {
                    sum += item[j];
                }
            }
            maxItem = Math.max(maxItem, sum);
        }

        System.out.println(maxItem);
    }
}