import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next(); // 연두 이름
        int yL = name.length() - name.replace("L", "").length();
        int yO = name.length() - name.replace("O", "").length();
        int yV = name.length() - name.replace("V", "").length();
        int yE = name.length() - name.replace("E", "").length();

        int N = sc.nextInt(); // 팀 이름 후보 개수

        int max = -1;
        String winTeam = ""; // 이긴 팀 이름
        for (int i = 0; i < N; i++) {
            String team = sc.next();

            int cntL = yL + team.length() - team.replace("L", "").length();
            int cntO = yO + team.length() - team.replace("O", "").length();
            int cntV = yV + team.length() - team.replace("V", "").length();
            int cntE = yE + team.length() - team.replace("E", "").length();

            int total = ((cntL + cntO) * (cntL + cntV) * (cntL + cntE) * (cntO + cntV) * (cntO + cntE) * (cntV + cntE))
                    % 100;

            if (max < total) {
                max = total;
                winTeam = team;
            } 
            else if (max == total) {
                if (winTeam.compareTo(team) > 0) {
                    winTeam = team;
                }
            }
        }
        System.out.println(winTeam);
    }
}