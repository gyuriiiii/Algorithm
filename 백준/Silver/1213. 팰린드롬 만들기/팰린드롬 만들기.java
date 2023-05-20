import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        char[] alpha = new char[26];

        for (int i = 0; i < name.length(); i++) {
            alpha[name.charAt(i) - 'A']++;
        }

        int one = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 == 1) {
                one++;
            }
        }

        if (one > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        String result = "";
        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] > 0) {
                int num = alpha[i] / 2;

                char start = (char) (i + 'A');
                char end = (char) (i + 'A');

                if (alpha[i] % 2 == 1) {
                    result = result.substring(0, result.length() / 2) + start + result.substring(result.length() / 2, result.length());
                }

                for (int j = 0; j < num; j++) {
                    result = start + result + end;
                }
            }
        }
        System.out.println(result);
    }
}