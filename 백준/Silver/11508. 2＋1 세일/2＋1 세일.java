import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            arr[i] = c;
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = n - 1; i >= 0; i -= 3) {
            for (int j = 0; j < 3; j++) {
                if (i - j < 0) {
                    break;
                }
                if (j != 2) {
                    answer += arr[i - j];
                }
            }
        }
        System.out.println(answer);
    }
}