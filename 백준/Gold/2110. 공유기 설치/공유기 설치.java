import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int C;
    static int N;
    static int[] home;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 집의 개수
        C = sc.nextInt(); // 공유기의 개수

        home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = sc.nextInt();
        }
        Arrays.sort(home);


        int low = 1;
        int high = home[N - 1] - home[0];

        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            // mid 거리로 공유기 C개를 다 설치할 수 있는 지 검사
            if (check(mid)) {
                low = mid + 1;
                result = mid;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int mid) {
        int cnt = 1;

        int idx = 1;
        for (int i = idx - 1; i < N; i++) {
            while (idx < N && idx > i) {
                if (home[idx] - home[i] >= mid) {
                    cnt++;
                    idx++;
                    i = idx - 1;
                }
                else {
                    idx++;
                }
            }
        }

        return cnt >= C;
    }
}