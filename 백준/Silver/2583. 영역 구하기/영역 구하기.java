import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int lx, ly, rx, ry;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int size;
    static ArrayList<Integer> sizeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[M][N];
        visited = new boolean[M][N];

        // 직사각형의 왼쪽 아래 꼭짓점 & 오른쪽 위 꼭짓점
        for (int i = 0; i < K; i++) {
            lx = sc.nextInt();
            ly = sc.nextInt();
            rx = sc.nextInt();
            ry = sc.nextInt();

            // 직사각형 부분 = -1로 채우기
            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    map[M - j - 1][k] = -1;
                }
            }
        }

        sizeList = new ArrayList<>(); // 영역의 크기

        // 직사각형 내부를 제외한 분리된 영역의 개수와 크기 구하기
        int cnt = 0; // 영역의 개수
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    size = 0;
                    dfs(i, j);
                    cnt++;
                    sizeList.add(size);
                }
            }
        }
        Collections.sort(sizeList);

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (int s : sizeList) {
            sb.append(s).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true; // 방문 표시
        size++; // 영역 크기 + 1

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // map 벗어남
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                continue;
            }

            // 직사각형 내부인 경우 & 이미 방문한 경우
            if (map[nx][ny] == -1 || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}