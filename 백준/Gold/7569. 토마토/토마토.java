import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int H, N, M;
    static int[][][] map;
    static int day;

    static ArrayDeque<Node> tomato = new ArrayDeque<>();

    static int[] dx = new int[]{-1, 1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        map = new int[H][N][M];

        boolean flag = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = sc.nextInt();

                    if (map[i][j][k] == 0) {
                        flag = true;
                    }

                    if (map[i][j][k] == 1) {
                        tomato.add(new Node(i, j, k));
                    }
                }
            }
        }

        // 이미 다 익어있는 경우
        if (!flag) {
            System.out.println(0);
            return;
        }

        bfs();
        if (checkTomato()) {
            System.out.println(day);
        }
        else {
            System.out.println(-1);
        }
    }

    private static boolean checkTomato() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void bfs() {
        while (!tomato.isEmpty()) {
            int size = tomato.size();

            boolean flag = false;
            for (int j = 0; j < size; j++) {
                Node now = tomato.poll();

                for (int i = 0; i < 6; i++) {
                    int nf = now.floor + dz[i];
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nf < 0 || nf >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (map[nf][nx][ny] == 0) {
                        map[nf][nx][ny] = 1;
                        tomato.add(new Node(nf, nx, ny));
                        flag = true;
                    }
                }
            }
            if(flag) {
                day++;
            }
        }
    }

    static public class Node {
        int floor;
        int x;
        int y;

        public Node(int floor, int x, int y) {
            this.floor = floor;
            this.x = x;
            this.y = y;
        }
    }
}