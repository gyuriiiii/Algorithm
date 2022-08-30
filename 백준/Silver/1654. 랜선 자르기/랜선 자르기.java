import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(checkNum(arr, N));
    }

    public static long checkNum(int[] arr, int N) {
        long start = 1;
        long end = arr[arr.length - 1];
        long mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < arr.length; i++) {
                sum += (arr[i] / mid);
            }

            if (sum >= N) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }
        return end;
    }
}