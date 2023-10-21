import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 기차 개수
        int M = sc.nextInt();

        int[][] seat = new int[N + 1][21]; // 각 기차의 좌석 상태

        for (int t = 0; t < M; t++) {
            int opNum = sc.nextInt();
            int i = sc.nextInt();

            if (opNum == 1) {
                int x = sc.nextInt();
                seat[i][x] = 1;
            }

            else if (opNum == 2) {
                int x = sc.nextInt();
                seat[i][x] = 0;
            }

            else if (opNum == 3) {
                // i번째 기차 사람들 한칸씩 뒤로
                for (int j = 20; j > 1; j--) {
                    seat[i][j] = seat[i][j - 1];
                }
                seat[i][1] = 0;
            }

            else if (opNum == 4) {
                // i번째 기차 사람들 한칸씩 앞으로
                for (int j = 1; j < 20; j++) {
                    seat[i][j] = seat[i][j + 1];
                }
                seat[i][20] = 0;
            }
        }

        HashSet<String> set = new HashSet<>();
        for (int i = 1; i < seat.length; i++) {
            set.add(Arrays.toString(seat[i]));
        }
        System.out.println(set.size());
    }
}