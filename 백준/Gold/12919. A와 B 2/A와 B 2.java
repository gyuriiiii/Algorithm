import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String T = sc.next();

        if (dfs(S, T)) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

    private static boolean dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return true;
            }
            return false;
        }

        if (t.charAt(t.length() - 1) == 'A') {
            if(dfs(s, t.substring(0, t.length() - 1))){
                return true;
            }
        }
        if (t.charAt(0) == 'B') {
            String tmp = "";
            for (int i = t.length() - 1; i >= 0; i--) {
                tmp += t.charAt(i);
            }
            t = tmp.substring(0, tmp.length() - 1);

            if(dfs(s, t)) {
                return true;
            }
        }
        return false;
    }
}