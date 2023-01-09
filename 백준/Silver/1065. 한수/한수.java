import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int num = 0;

        // 100보다 작은 경우
        // 1~99는 한수
        if (N < 100) {
            num += N;
        }

        else {
            num += 99;

            for (int i = 100; i <= N; i++) {
                int n = i;
                int[] arr = new int[3];

                arr[0] = n / 100;
                n %= 100;
                arr[1] = n / 10;
                arr[2] = n % 10;

                if (arr[1] - arr[0] == arr[2] - arr[1]) {
                    num++;
                }
            }
        }

        System.out.println(num);
    }
}