import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] a = new int[N];
        Integer[] b = new Integer[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        for (int i = 0; i < N; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (a[i] * b[i]);
        }
        System.out.println(sum);
    }
}