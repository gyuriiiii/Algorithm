import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        int sum = 0;
        int min = Integer.MAX_VALUE;

        int sqrt = (int) Math.sqrt(N);

        for (int i = 2; i <= sqrt; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if(sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum + "\n" + min);
    }
}