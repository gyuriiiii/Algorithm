import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static ArrayList<Node> list;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();

            list = new ArrayList<>();
            for (int j = 0; j < n + 2; j++) {
                list.add(new Node(sc.nextInt(), sc.nextInt()));
            }

            arr = new int[n + 2][n + 2];
            visited = new boolean[n + 2];
            for (int j = 0; j < n + 2; j++) {
                for (int k = j + 1; k < n + 2; k++) {
                    if (getDistance(list.get(j), list.get(k)) <= 1000) {
                        arr[j][k] = arr[k][j] = 1;
                    }
                }
            }

            if (bfs(0)) {
                System.out.println("happy");
            }
            else {
                System.out.println("sad");
            }
        }
    }

    private static boolean bfs(int idx) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(idx);
        visited[idx] = true;

        while (!dq.isEmpty()) {
            int now = dq.poll();
            if (now == n + 1) { 
                return true;
            }

            for (int i = 0; i < n + 2; i++) {
                if (visited[i]) {
                    continue;
                }

                if (arr[now][i] == 1) {
                    visited[i] = true;
                    dq.add(i);
                }
            }
        }
        return false;
    }

    private static int getDistance(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}