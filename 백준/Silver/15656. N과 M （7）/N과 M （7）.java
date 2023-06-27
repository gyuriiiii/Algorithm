import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] numArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        numArr = new int[M];

        dfs(0, arr, M);
        System.out.println(sb);
    }

    private static void dfs(int num, int[] arr, int m) {
        if (num == m) {
            for (int i = 0; i < m; i++) {
                sb.append(numArr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            numArr[num] = arr[i];
            dfs(num + 1, arr, m);
        }
    }
}