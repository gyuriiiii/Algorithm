import java.util.Scanner;

public class Main {
    static int n;
    static int arr[];
    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 계단 개수

        arr = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i < n+ 1; i++) {
            arr[i] = sc.nextInt(); // 계단 점수
        }

        dp[1] = arr[1];

        for (int i = 2; i < n + 1; i++) {
            if (i == 2) {
                dp[2] = dp[1] + arr[2];
            } 
            else if (i == 3) {
                dp[3] = Math.max(arr[1], arr[2]) + arr[3];
            } 
            else {
                dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];
            }
        }
        System.out.println(dp[n]);
    }
}