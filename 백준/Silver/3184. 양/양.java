import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int R, C;
    static char[][] map;
    static ArrayList<Node> pos = new ArrayList<>();
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int sheep, wolf;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'o' || map[i][j] == 'v') {
                    pos.add(new Node(i, j));
                }
            }
        }

        for (Node p : pos) {
            if (!visited[p.x][p.y]) {
                bfs(p);
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(Node start) {
        // 같은 영역 list
        ArrayList<Node> area = new ArrayList<>();
        area.add(start);

        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start.x][start.y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                if (map[nx][ny] == '#') {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    area.add(new Node(nx, ny));
                }
            }
        }

        checkNum(area);
    }

    private static void checkNum(ArrayList<Node> area) {
        int oNum = 0;
        int vNum = 0;

        for (Node node : area) {
            if (map[node.x][node.y] == 'o') {
                oNum++;
            }
            else if (map[node.x][node.y] == 'v') {
                vNum++;
            }
        }

        if (oNum > vNum) {
            sheep += oNum;
        }
        else {
            wolf += vNum;
        }
    }

    static private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}