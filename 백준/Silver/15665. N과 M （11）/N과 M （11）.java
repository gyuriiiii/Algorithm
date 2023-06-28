import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] numArr;
    static int[] arr;
    static HashSet<String> set =  new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        numArr = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int cnt) {
        if (cnt == M) {
            String s = "";
            for (int i = 0; i < M; i++) {
                s = s + " " + numArr[i];
            }
            s = s.trim();

            if (!set.contains(s)) {
                set.add(s);
                sb.append(s).append("\n");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            numArr[cnt] = arr[i];
            dfs(cnt + 1);
        }
    }
}