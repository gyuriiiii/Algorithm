import java.util.Scanner;

public class Main {
    static int N;

    static int cnt;
    static boolean[][] check;

    static char[][] arr;
    static char[][] arr2;

    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();

        arr = new char[N][N];
        arr2 = new char[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);

                arr[i][j] = c;

                // 적록색약인 경우 R을 G로 바꿔서 저장
                if (c == 'R') {
                    arr2[i][j] = 'G';
                    continue;
                }
                arr2[i][j] = c;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    dfs(arr, i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt + " ");

        check = new boolean[N][N];
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    dfs(arr2, i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }

    private static void dfs(char[][] arr, int i, int j) {
        check[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int curx = i + dx[k];
            int cury = j + dy[k];

            if (curx < 0 || cury < 0 || curx >= N || cury >= N) {
                continue;
            }

            if (!check[curx][cury] && arr[i][j] == arr[curx][cury]) {
                dfs(arr, curx, cury);
                check[curx][cury] = true;
            }
        }
    }
}