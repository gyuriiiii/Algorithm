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

        int locate = 0;

        for (int i = 1; i < N; i++) {
            if(home[i] - home[locate] >= mid) {
                cnt++;
                locate = i;
            }
        }

        return cnt >= C;
    }
}