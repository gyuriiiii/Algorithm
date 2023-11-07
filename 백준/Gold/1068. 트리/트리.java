import java.util.Scanner;

public class Main {
    static int N;
    static int[] parent;
    static boolean[] root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        root = new boolean[N];
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == -1) {
                root[i] = true;
            }
            parent[i] = num;
        }

        int remove = sc.nextInt();
        dfs(remove);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (parent[i] != -2) {
                if (checkChild(i)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean checkChild(int idx) {
        for (int i = 0; i < N; i++) {
            if (parent[i] == idx) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int remove) {
        parent[remove] = -2; //노드 삭제

        for (int i = 0; i < N; i++) {
            if (parent[i] == remove) {
                dfs(i);
            }
        }
    }
}