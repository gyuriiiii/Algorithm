import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        int min = Integer.MAX_VALUE;
        int water1 = 0;
        int water2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int tmp = Math.abs(sum);

            if (tmp < min) {
                min = tmp;
                water1 = arr[left];
                water2 = arr[right];
            }

            if (sum > 0) {
                right--;
            }
            else {
                left++;
            }
        }
        System.out.println(water1 + " " + water2);
    }
}