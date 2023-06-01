import java.util.ArrayList;

class Solution {
    static int[][] powers;
    static ArrayList<Integer> mineralOrder;
    static int answer = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        powers = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

        int pickNum = 0; // 곡괭이 개수
        for (int pick : picks) {
            pickNum += pick;
        }

        mineralOrder = new ArrayList<>();
        for (String mineral : minerals) {
            switch (mineral) {
                case "diamond":
                    mineralOrder.add(0);
                    break;
                case "iron":
                    mineralOrder.add(1);
                    break;
                case "stone":
                    mineralOrder.add(2);
                    break;
            }
        }

        int[] order = new int[pickNum];
        backtracking(0, order, picks);

        return answer;
    }

    private static void backtracking(int num, int[] order, int[] picks) {
        if (num == order.length) {
            answer = Math.min(answer, checkPower(order));
            return;
        }

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                order[num] = i;
                backtracking(num + 1, order, picks);
                picks[i]++;
            }
        }
    }

    private static int checkPower(int[] order) {
        int power = 0;

        int mineralIdx = 0;
        for (int i : order) {
            int cnt = 5;
            while (cnt > 0) {
                if (mineralIdx > mineralOrder.size() - 1) {
                    return power;
                }
                power += powers[i][mineralOrder.get(mineralIdx++)];
                cnt--;
            }
        }

        return power;
    }
}