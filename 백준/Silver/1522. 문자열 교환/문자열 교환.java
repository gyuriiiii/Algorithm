import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                len++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            for (int j = i; j < i + len; j++) {
                if (s.charAt(j % s.length()) == 'b') {
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }
}