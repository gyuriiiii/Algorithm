import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] tips = new Integer[N];
        for (int i = 0; i < N; i++) { 
            tips[i] = sc.nextInt();
        }
        Arrays.sort(tips, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int tip = tips[i] - i;

            if (tip > 0) {
                sum += tip;
            }
        }
        System.out.println(sum);
    }
}