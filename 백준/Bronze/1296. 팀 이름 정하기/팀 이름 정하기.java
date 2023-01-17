import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next(); // 연두 이름
        int yL = 0;
        int yO = 0;
        int yV = 0;
        int yE = 0;

        for (int j = 0; j < name.length(); j++) {
            char c = name.charAt(j);

            if (c == 'L') {
                yL++;
            }
            if (c == 'O') {
                yO++;
            }
            if (c == 'V') {
                yV++;
            }
            if (c == 'E') {
                yE++;
            }
        }

        int N = sc.nextInt(); // 팀 이름 후보 개수

        String[] teamName = new String[N]; // 각 팀의 이름
        int[] arr = new int[N]; // 각 팀의 우승 확률
        for (int i = 0; i < N; i++) {
            int cntL = yL;
            int cntO = yO;
            int cntV = yV;
            int cntE = yE;

            String team = sc.next();
            teamName[i] = team;

            // 우승 확률 계산
            for (int j = 0; j < team.length(); j++) {
                char c = team.charAt(j);

                if (c == 'L') {
                    cntL++;
                }
                if (c == 'O') {
                    cntO++;
                }
                if (c == 'V') {
                    cntV++;
                }
                if (c == 'E') {
                    cntE++;
                }

            }
            arr[i] = ((cntL + cntO) * (cntL + cntV) * (cntL + cntE) * (cntO + cntV) * (cntO + cntE) * (cntV + cntE))
                    % 100;
        }

        // 우승 확률 가장 높은 팀 구하기
        int max = arr[0];
        int maxIdx = 0;
        String winTeam = teamName[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= max) {
                if (arr[i] == max) {
                    // 사전순으로 teamName[i]가 앞서면
                    if (teamName[maxIdx].compareTo(teamName[i]) > 0) {
                        max = arr[i];
                        maxIdx = i;
                        winTeam = teamName[maxIdx];
                        continue;
                    }
                } 
                else {
                    max = arr[i];
                    maxIdx = i;
                    winTeam = teamName[i];
                }
            }
        }
        System.out.println(winTeam);
    }
}