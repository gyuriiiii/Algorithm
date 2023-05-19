import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num1 = 0;
        int num2 = 0;
        int result = Integer.MAX_VALUE;

        int low = 0;
        int high = N - 1;

        while (low < high) {
            int sum = arr[low] + arr[high];

            if (result > Math.abs(0 - sum)) {
                result = Math.abs(0 - sum);

                num1 = arr[low];
                num2 = arr[high];
            }

            if (sum < 0) {
                low++;
            }
            else {
                high--;
            }
        }
        System.out.println(num1 + " " + num2);
    }
}