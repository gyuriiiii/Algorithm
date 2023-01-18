import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer> list[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
        list[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int i) {
        visited[i] = true;

        for (int j : list[i]) {
            if (!visited[j]) {
                parent[j] = i;
                dfs(j);
            }
        }
    }
}