import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(max, arr[i]);
        }

        int low = max;
        int high = 10_000 * 100_000;

        while (low <= high) {
            int mid = (low + high) / 2;

            int num = 0; // 블루레이 개수
            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += arr[i];

                if (sum > mid) {
                    num++;
                    sum = arr[i];
                }
            }

            if (num < M) {
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}