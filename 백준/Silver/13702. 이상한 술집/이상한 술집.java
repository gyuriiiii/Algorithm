import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        long low = 0;
        long high = (int) Math.pow(2, 31) - 1;
        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            int sum = 0;
            for (int a : arr) {
                sum += a / mid;
            }

            if (sum < K) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}