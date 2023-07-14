import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, D;
    static int[] dis;
    static ArrayList<Node>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        D = sc.nextInt();

        dis = new int[D + 1];
        for (int i = 0; i < D + 1; i++) {
            dis[i] = i;
        }

        list = new ArrayList[D + 1];
        for (int i = 0; i < D + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            if (start > D || end > D)
                continue;

            list[start].add(new Node(end, cost));
        }

        dijkstra(0);
        System.out.println(dis[D]);
    }

    private static void dijkstra(int start) {
        if (start >= D) {
            return;
        }

        for (Node next : list[start]) {
            if (dis[next.end] > dis[start] + next.cost) {
                dis[next.end] = dis[start] + next.cost;
            }
        }

        if (dis[start + 1] > dis[start] + 1) {
            dis[start + 1] = dis[start] + 1;
        }

        dijkstra(start + 1);
    }

    static public class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}