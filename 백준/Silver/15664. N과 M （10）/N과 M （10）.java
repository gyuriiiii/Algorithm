import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] numArr;
    static int[] arr;
    static ArrayList<String> list = new ArrayList<>();

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

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int cnt, int start) {
        if (cnt == M) {
            String s = "";
            for (int i = 0; i < M; i++) {
                s = s + " " + numArr[i];
            }
            s = s.trim();

            if (!list.contains(s)) {
                list.add(s);
                sb.append(s).append("\n");
            }
            return;
        }

        for (int i = start; i < N; i++) {
            numArr[cnt] = arr[i];
            dfs(cnt + 1, i + 1);
        }
    }
}