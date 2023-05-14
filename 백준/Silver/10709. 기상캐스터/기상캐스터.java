import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int H, W;
    static char[][] map;
    static int[][] time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        H = sc.nextInt();
        W = sc.nextInt();

        map = new char[H][W];
        time = new int[H][W];

        ArrayDeque<Node> dq = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            String s = sc.next();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                time[i][j] = -1;

                if (map[i][j] == 'c') { // 이미 구름 있는 경우 
                    time[i][j] = 0;
                    dq.add(new Node(i, j)); // 구름 위치
                }
            }
        }

        while (!dq.isEmpty()) {
            int size = dq.size();

            for (int i = 0; i < size; i++) {
                Node now = dq.poll();

                int nx = now.x;
                int ny = now.y + 1;

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) { // 범위 벗어남
                    continue;
                }

                if (map[nx][ny] == '.') { // 구름 없는 곳
                    map[nx][ny] = 'c';
                    time[nx][ny] = time[now.x][now.y] + 1;

                    dq.add(new Node(nx, ny));
                }
            }
        }

        for (int i = 0; i < time.length; i++) {
            for (int j = 0; j < time[i].length; j++) {
                System.out.print(time[i][j] + " ");
            }
            System.out.println();
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