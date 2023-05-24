import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M, D;
    static int[][] map, tmp;
    static int result;
    static ArrayList<Node> archers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();

        map = new int[N + 1][M + 1];
        tmp = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        locateArcher(1, 0);
        System.out.println(result);
    }

    private static void locateArcher(int idx, int num) {
        if (num == 3) {
            init();
            attackEnemy();
            return;
        }

        for (int i = idx; i <= M; i++) {
            archers.add(new Node(N + 1, i));
            locateArcher(i + 1, num + 1);
            archers.remove(archers.size() - 1);
        }
    }

    private static void attackEnemy() {
        int removeNum = 0;

        for (int i = 1; i <= N; i++) {
            boolean[][] visited = new boolean[N + 1][M + 1];

            for (int j = 0; j < archers.size(); j++) {
                Node archer = archers.get(j);

                int minDis = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;

                for (int k = 1; k <= N; k++) {
                    for (int l = 1; l <= M; l++) {
                        if (tmp[k][l] == 1) { // 적이 있는 경우
                            int dis = getDistance(archer.x, archer.y, k, l);

                            if (dis > D) {
                                continue;
                            }

                            if (minDis >= dis) {
                                if (minDis > dis) {
                                    minDis = dis;
                                    minX = k;
                                    minY = l;
                                }
                                else {
                                    if (l < minY) {
                                        minX = k;
                                        minY = l;
                                    }
                                }
                            }
                        }
                    }
                }

                if(minDis != Integer.MAX_VALUE) {
                    visited[minX][minY] = true;
                }
            }

            // 궁수에게 공격당한 적 제거
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if (visited[j][k]) {
                        tmp[j][k] = 0; // 빈칸으로 처리
                        removeNum++;
                    }
                }
            }

            // 성 윗칸의 적 모두 제거
            for (int j = 1; j <= M; j++) {
                tmp[N][j] = 0;
            }

            // 적 한 칸씩 아래로 이동
            for (int j = N; j >= 1; j--) {
                for (int k = 1; k <= M; k++) {
                    tmp[j][k] = tmp[j - 1][k];
                }
            }
        }
        result = Math.max(result, removeNum);
    }

    private static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    private static void init() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                tmp[i][j] = map[i][j];
            }
        }
    }

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}