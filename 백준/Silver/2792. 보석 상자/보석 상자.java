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

        int answer = 0;

        int low = 0;
        int high = max;

        while (low <= high) {
            int mid = (low + high) / 2; // 질투심
            int sum = 0; // 나눠줄 수 있는 학생 수

            int idx = 0;
            int tmp = arr[idx];

            boolean flag = false;
            while (idx < arr.length) {
                if (tmp > 0) {
                    tmp -= mid;
                    sum++;

                    if (sum > N) {
                        flag = true;
                        break;
                    }
                }
                else {
                    idx++;
                    if (idx >= arr.length) {
                        break;
                    }
                    tmp = arr[idx];
                }
            }

            if (flag) {
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