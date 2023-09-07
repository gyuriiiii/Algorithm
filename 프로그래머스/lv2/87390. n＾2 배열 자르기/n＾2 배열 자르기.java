import java.util.ArrayList;

public class Solution {
    static public ArrayList<Long> solution(int n, long left, long right) {
        ArrayList<Long> list = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            list.add(Math.max(row, col) + 1);
        }

        return list;
    }
}