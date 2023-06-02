import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[col - 1] == o2[col - 1]) {
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(o1[col - 1], o2[col - 1]);
            }
        });

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = row_begin; i <= row_end; i++) {
            int[] arr = data[i - 1];

            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += (arr[j] % i);
            }
            list.add(sum);
        }

        for (int i = 0; i < list.size(); i++) {
            answer ^= list.get(i);
        }
        return answer;
    }
}