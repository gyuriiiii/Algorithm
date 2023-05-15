import java.util.Scanner;

public class Main {
    static int N, K;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] words;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if (K < 5) { 
            System.out.println("0");
            return;
        }
        if (K == 26) { // 모든 알파벳 다 읽을 수 있는 경우
            System.out.println(N);
            return;
        }

        words = new String[N];
        visited = new boolean[26];

        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            tmp = tmp.replace("anta", "");
            tmp = tmp.replace("tica", "");
            words[i] = tmp;
        }

        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['t' - 'a'] = true;

        K -= 5;

        backtracking(0, 0);
        System.out.println(max);
    }

    private static void backtracking(int idx, int num) {
        if (num == K) {
            int cnt = 0;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                boolean flag = true;
                for (int j = 0; j < word.length(); j++) {
                    if (!visited[word.charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, num + 1);
                visited[i] = false;
            }
        }
    }
}