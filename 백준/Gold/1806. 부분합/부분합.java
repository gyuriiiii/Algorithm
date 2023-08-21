import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();


        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        int result = Integer.MAX_VALUE;

        while (left <= right && right <= N) {
            if (sum < S) {
                sum += arr[right++];
            }
            else {
                result = Math.min(result, right - left);
                sum -= arr[left++];
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(result);
        }
    }
}