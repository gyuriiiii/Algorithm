import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int cnt = 0; // 맞춘 개수
        int zero = 0; // 0 개수

        ArrayList<Integer> win = new ArrayList<>();
        for (int i : win_nums) {
            win.add(i);
        }

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
            }

            if (win.contains(lottos[i])) {
                cnt++;
            }
        }

        answer[0] = check(cnt + zero);
        answer[1] = check(cnt);

        return answer;
    }

    private static int check(int num) {
        int rank = 0;
        switch (num) {
            case 6:
                rank = 1;
                break;
            case 5:
                rank = 2;
                break;
            case 4:
                rank = 3;
                break;
            case 3:
                rank = 4;
                break;
            case 2:
                rank = 5;
                break;
            default:
                rank = 6;
                break;
        }
        return rank;
    }
}