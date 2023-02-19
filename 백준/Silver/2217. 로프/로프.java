import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        for (int j = 1; j <= N; j++) {
            max = Math.max(arr[N - j] * j, max);
        }
        System.out.println(max);
    }
}