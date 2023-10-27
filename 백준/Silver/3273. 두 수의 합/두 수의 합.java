import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        int answer = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {
                answer++;
                end--;
            }
            else if (sum < x) {
                start++;
            }
            else if (sum > x) {
                end--;
            }
        }

        System.out.println(answer);
    }
}