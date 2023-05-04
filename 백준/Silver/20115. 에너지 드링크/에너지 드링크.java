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

        double a = 0;
        double b = arr[N - 1];

        for (int i = 0; i < N - 1; i++) {
            a = arr[i];
            b = b + (a / 2);
        }

        System.out.println(b);
    }
}