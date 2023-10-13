import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < count; j++) {
                int tmp = map[j][j];

                // 왼
                for (int k = j; k < M - j - 1; k++) {
                    map[j][k] = map[j][k + 1];
                }

                // 위
                for (int k = j; k < N - j - 1; k++) {
                    map[k][M - j - 1] = map[k + 1][M - j - 1];
                }

                // 오
                for (int k = M - j - 1; k > j; k--) {
                    map[N - j - 1][k] = map[N - j - 1][k - 1];
                }

                // 아래
                for (int k = N - j - 1; k > j; k--) {
                    map[k][j] = map[k - 1][j];
                }

                map[j + 1][j] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}