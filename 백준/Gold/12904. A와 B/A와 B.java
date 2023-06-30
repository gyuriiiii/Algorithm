import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String T = sc.next();

        while (S.length() < T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            }
            else if (T.charAt(T.length() - 1) == 'B') {
                String tmp = T.substring(0, T.length() - 1);

                T = "";
                for (int i = 0; i < tmp.length(); i++) {
                    T += tmp.charAt(tmp.length() - 1 - i);
                }
            }
        }

        if (T.equals(S)) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}