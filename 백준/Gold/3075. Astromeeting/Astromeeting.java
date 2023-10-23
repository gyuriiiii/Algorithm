import java.util.Scanner;

public class Main {
    static final int INF = 987654321;
    static int[][] dis;
    static int n, p, q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            n = sc.nextInt(); // 사람 수
            p = sc.nextInt(); // 은하 수
            q = sc.nextInt(); // 은하간의 길 수

            int[] pos = new int[n];

            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                pos[j] = num;
            }

            dis = new int[p + 1][p + 1];
            for (int i = 1; i < p + 1; i++) {
                for (int j = 1; j < p + 1; j++) {
                    if (i != j) {
                        dis[i][j] = INF;
                    }
                }
            }

            for (int j = 0; j < q; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int d = sc.nextInt();
                dis[x][y] = Math.min(dis[x][y], d);
                dis[y][x] = Math.min(dis[y][x], d);
            }

            // 모든 은하 사이 최단 거리 구하기
            floyd();

            int minIdx = 1;
            long minSum = Long.MAX_VALUE;

            for (int star = 1; star <= p; star++) {
                boolean flag = true;

                long sum = 0;
                for (int j = 0; j < n; j++) {
                    int personPos = pos[j];
                    
                    // 해당 은하로 갈 수 없는 사람이 있는 경우
                    if(dis[personPos][star] == INF) {
                        flag = false;
                        break;
                    }
                    sum += Math.pow(dis[personPos][star], 2);
                }

                if(!flag) {
                    continue;
                }
                
                if (minSum > sum) {
                    minSum = sum;
                    minIdx = star;
                }
            }

            System.out.println(minIdx + " " + minSum);
        }
    }

    private static void floyd() {
        for (int k = 1; k < p + 1; k++) {
            for (int i = 1; i < p + 1; i++) {
                for (int j = 1; j < p + 1; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
    }
}