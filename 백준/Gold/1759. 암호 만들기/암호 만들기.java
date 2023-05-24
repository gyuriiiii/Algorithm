import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int L, C;
    static char[] words;
    static boolean[] visited;
    static ArrayList<Character> vowles;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        words = new char[C];
        visited = new boolean[26];

        for (int i = 0; i < C; i++) {
            words[i] = sc.next().charAt(0);
        }
        Arrays.sort(words);

        vowles = new ArrayList<>();
        vowles.add('a');
        vowles.add('e');
        vowles.add('i');
        vowles.add('o');
        vowles.add('u');

        backtracking(0, 0, "");
        System.out.println(sb);
    }

    private static void backtracking(int idx, int num, String s) {
        if (num == L) {
            int vowel = 0; // 모음 개수
            int consonant = 0; // 자음 개수

            for (int i = 0; i < L; i++) {
                if (vowles.contains(s.charAt(i))) {
                    vowel++;
                }
                else {
                    consonant++;
                }
            }

            if (vowel >= 1 && consonant >= 2) {
                sb.append(s).append("\n");
            }

            return;
        }

        for (int i = idx; i < C; i++) {
            if (!visited[words[i] - 'a']) {
                visited[words[i] - 'a'] = true;
                s = s + words[i];
                backtracking(i + 1, num + 1, s);
                s = s.substring(0, s.length() - 1);
                visited[words[i] - 'a'] = false;
            }
        }
    }
}