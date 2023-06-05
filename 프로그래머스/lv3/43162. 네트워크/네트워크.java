import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    static int[] parent;

    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            set.add(find(i));
        }
        return set.size();
    }

    static private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        parent[x] = y;
    }

    static private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
}