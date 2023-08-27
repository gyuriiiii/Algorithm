import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, M;
    static char[][] map;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static boolean[][][][] visited;

    static Node red, blue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'R') {
                    red = new Node(i, j, 0, 0, 0);
                } else if (map[i][j] == 'B') {
                    blue = new Node(0, 0, i, j, 0);
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(red.redX, red.redY, blue.blueX, blue.blueY, 1));
        visited[red.redX][red.redY][blue.blueX][blue.blueY] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.cnt > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int redNX = now.redX;
                int redNY = now.redY;
                int blueNX = now.blueX;
                int blueNY = now.blueY;

                boolean redHole = false;
                boolean blueHole = false;

                while (map[redNX + dx[i]][redNY + dy[i]] != '#') {
                    redNX += dx[i];
                    redNY += dy[i];

                    if (map[redNX][redNY] == 'O') {
                        redHole = true;
                        break;
                    }
                }

                while (map[blueNX + dx[i]][blueNY + dy[i]] != '#') {
                    blueNX += dx[i];
                    blueNY += dy[i];

                    if (map[blueNX][blueNY] == 'O') {
                        blueHole = true;
                        break;
                    }
                }

                if (blueHole) {
                    continue;
                }

                if (!blueHole && redHole) {
                    return now.cnt;
                }

                if (redNX == blueNX && redNY == blueNY) {
                    // 위
                    if (i == 0) {
                        if (now.redX < now.blueX) {
                            blueNX -= dx[i];
                        }
                        else {
                            redNX -= dx[i];
                        }

                    }
                    // 아래
                    else if (i == 1) {
                        if (now.redX < now.blueX) {
                            redNX -= dx[i];
                        }
                        else {
                            blueNX -= dx[i];
                        }
                    }
                    // 왼쪽
                    else if (i == 2) {
                        if (now.redY < now.blueY) {
                            blueNY -= dy[i];
                        }
                        else {
                            redNY -= dy[i];
                        }
                    }
                    // 오른쪽
                    else if (i == 3) {
                        if (now.redY < now.blueY) {
                            redNY -= dy[i];
                        }
                        else {
                            blueNY -= dy[i];
                        }
                    }
                }

                if (!visited[redNX][redNY][blueNX][blueNY]) {
                    visited[redNX][redNY][blueNX][blueNY] = true;
                    dq.add(new Node(redNX, redNY, blueNX, blueNY, now.cnt + 1));
                }
            }
        }
        return -1;
    }

    static private class Node {
        int redX;
        int redY;
        int blueX;
        int blueY;
        int cnt;

        public Node(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }
}