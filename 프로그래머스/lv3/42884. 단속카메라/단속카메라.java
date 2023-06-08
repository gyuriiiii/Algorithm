import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int answer = 1;
        int tmp = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= tmp) {
                continue;
            }
            tmp = routes[i][1];
            answer++;
        }
        
        return answer;
    }
}