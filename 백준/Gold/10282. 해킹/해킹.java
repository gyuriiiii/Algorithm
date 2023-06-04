import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int INF = 987654321;
    static int[] time;
    static ArrayList<Node>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt(); // 컴퓨터 개수
            int d = sc.nextInt(); // 의존성 개수
            int c = sc.nextInt(); // 해킹당한 컴퓨터 번호

            time = new int[n + 1]; // 감염되는데 걸리는 시간
            Arrays.fill(time, INF);

            list = new ArrayList[n + 1];
            for (int j = 1; j < n + 1; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < d; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();

                list[b].add(new Node(a, s));
            }

            int totalNum = 0; // 총 감염된 컴퓨터 수
            int lastTime = 0;

            dijkstra(c);

            for (int j = 1; j < n + 1; j++) {
                if (time[j] != INF) {
                    totalNum++;
                    lastTime = Math.max(lastTime, time[j]);
                }
            }
            sb.append(totalNum + " " + lastTime).append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.sec, o2.sec)));

        pq.add(new Node(start, 0));
        time[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : list[now.num]) {
                if (time[next.num] > time[now.num] + next.sec) {
                    time[next.num] = time[now.num] + next.sec;
                    pq.add(new Node(next.num, time[next.num]));
                }
            }
        }
    }

    static public class Node {
        int num;
        int sec;

        public Node(int num, int sec) {
            this.num = num;
            this.sec = sec;
        }
    }
}