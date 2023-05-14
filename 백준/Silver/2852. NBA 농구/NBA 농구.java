import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 골 들어간 횟수

        int score[] = new int[3]; // 현 스코어
        int time[] = new int[3]; // 각 팀의 이기고 있던 시간

        int win = 0; 
        int beforeWin = 0; 
        int tmpTime = 0;

        for (int i = 0; i < N; i++) {
            int teamNum = sc.nextInt();
            String winTime = sc.next(); 

            int min = Integer.parseInt(winTime.split(":")[0]); 
            int sec = Integer.parseInt(winTime.split(":")[1]); 

            score[teamNum]++; 

            // 동점인 경우
            if (score[1] == score[2]) {
                int winning = (min * 60 + sec) - tmpTime; 
                time[win] += winning;
                win = 0;
                tmpTime = 0;
            }

            // 동점이 아닌 경우
            else {
                if (beforeWin != 0 && win == beforeWin) {
                    continue;
                }

                if (score[1] > score[2]) {
                    win = 1;
                }
                else {
                    win = 2;
                }

                tmpTime = min * 60 + sec;
                beforeWin = win;
            }
        }

        if (win != 0) {
            int winning = 48 * 60 - tmpTime;
            time[win] += winning;
        }

        for (int i = 1; i < 3; i++) {
            int t = time[i];

            int min = t / 60;
            int sec = t % 60;
            System.out.printf("%02d:%02d\n", min, sec);
        }
    }
}