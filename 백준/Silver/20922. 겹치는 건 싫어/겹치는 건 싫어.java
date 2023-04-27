import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];
        int left = 0;
        int right = 0;

        int answer = 0;
        while (left <= right) {
            if (right >= N) {
                break;
            }

            if (cnt[arr[right]] < K) {
                cnt[arr[right]]++;
                right++;
            }
            else if (cnt[arr[right]] == K) {
                cnt[arr[left]]--;
                left++;
            }
            answer = Math.max(answer, right - left);
        }
        System.out.println(answer);
    }
}