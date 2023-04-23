import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] words = new String[N];

        int maxCnt = 0;
        String[] answer = new String[2];

        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int cnt = 0;

                int min = Math.min(words[i].length(), words[j].length());
                for (int k = 0; k < min; k++) {
                    if(words[i].charAt(k) == words[j].charAt(k)) {
                        cnt++;
                    }
                    else {
                        break;
                    }
                }

                if(maxCnt < cnt) {
                    maxCnt = cnt;

                    answer[0] = words[i];
                    answer[1] = words[j];
                }
            }
        }

        if(maxCnt == 0) System.out.println("");
        else {
            for (String s : answer) {
                System.out.println(s);
            }
        }
    }
}