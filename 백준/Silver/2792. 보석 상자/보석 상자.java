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

        int[] arr = new int[M];
        int max = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int low = 1;
        int high = max;

        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2; // 질투심
            int sum = 0; // 나눠줄 수 있는 학생 수

            for (int i = 0; i < M; i++) {
                if (arr[i] % mid == 0) {
                    sum += arr[i] / mid;
                }
                else {
                    sum += arr[i] / mid + 1;
                }
            }

            if (sum > N) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}