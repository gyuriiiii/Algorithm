import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        int[] alpha = new int[26];

        for (int i = 0; i < S.length(); i++) {
            alpha[S.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alpha[i]).append(" ");
        }
        System.out.println(sb);
    }
}