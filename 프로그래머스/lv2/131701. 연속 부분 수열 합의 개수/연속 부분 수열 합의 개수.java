import java.util.HashSet;

class Solution {
    static HashSet<Integer> set = new HashSet();

    public int solution(int[] elements) {
        for (int start = 0; start < elements.length; start++) {
            int step = 1;

            while (true) {
                int sum = 0;

                for (int i = start; i < start + step; i++) {
                    int idx = i;
                    if (i >= elements.length) {
                        idx = i - elements.length;
                    }
                    sum += elements[idx];
                }

                set.add(sum);
                step++;

                if (step > elements.length) {
                    break;
                }
            }
        }
        return set.size();
    }
}