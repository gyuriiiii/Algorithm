import java.util.Arrays;

public class Solution {
    static Edge[] edges;
    static int[] parent;
    static int answer;

    public int solution(int n, int[][] costs) {
        edges = new Edge[costs.length];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }

        kruskal();
        
        return answer;
    }

    private static void kruskal() {
        Arrays.sort(edges, ((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                answer += edge.cost;
            }
        }
    }

    private static void union(int start, int end) {
        int x = parent[start];
        int y = parent[end];
        parent[x] = y;
    }

    private static int find(int start) {
        if (parent[start] == start)
            return start;
        return parent[start] = find(parent[start]);
    }

    static public class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}