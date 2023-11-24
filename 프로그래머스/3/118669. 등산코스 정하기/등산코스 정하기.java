import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static final int INF = 987654321;
    static ArrayList<Node>[] list;
    static int[] intensity;
    static ArrayDeque<Node> dq = new ArrayDeque<>();
    static int[] answer;

    static public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        answer = new int[2];

        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int i = path[0];
            int j = path[1];
            int w = path[2];

            if (isGate(i, gates) || isSummit(j, summits)) {
                list[i].add(new Node(j, w));
            }
            else if (isGate(j, gates) || isSummit(i, summits)) {
                list[j].add(new Node(i, w));
            }
            else {
                list[i].add(new Node(j, w));
                list[j].add(new Node(i, w));
            }
        }

        intensity = new int[n + 1];
        Arrays.fill(intensity, INF);

        for (int gate : gates) {
            dq.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        dijkstra(n, gates, summits);

        return answer;
    }

    private static void dijkstra(int n, int[] gates, int[] summits) {
        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.cost > intensity[now.end]) {
                continue;
            }

            for (Node next : list[now.end]) {
                int dis = Math.max(now.cost, next.cost);

                if (intensity[next.end] > dis) {
                    intensity[next.end] = dis;
                    dq.add(new Node(next.end, dis));
                }
            }
        }

        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;
        
        Arrays.sort(summits);

        for (int s : summits) {
            if (intensity[s] < minIntensity) {
                minIntensity = intensity[s];
                minSummit = s;
            }
        }

        answer[0]=minSummit;
        answer[1] = minIntensity;
    }

    private static boolean isGate(int num, int[] gates) {
        for (int g : gates) {
            if (num == g) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSummit(int num, int[] summits) {
        for (int s : summits) {
            if (num == s) {
                return true;
            }
        }
        return false;
    }

    static private class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}