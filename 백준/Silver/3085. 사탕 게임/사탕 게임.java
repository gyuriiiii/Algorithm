import java.util.Scanner;

public class Main {
    static int N;
    static char[][] map;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    check_arr();
                    swap(i, j, i, j + 1);
                }

                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    check_arr();
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void swap(int i, int j, int i2, int j2) {
        char tmp = map[i][j];
        map[i][j] = map[i2][j2];
        map[i2][j2] = tmp;
    }

    private static void check_arr() {
        // 가로 중 가장 큰 사탕 개수 찾기
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                answer = Math.max(answer, cnt);
            }
        }

        // 세로 중 가장 큰 사탕 개수 찾기
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                answer = Math.max(answer, cnt);
            }
        }
    }
}