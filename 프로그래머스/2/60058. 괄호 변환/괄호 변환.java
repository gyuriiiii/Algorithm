import java.util.ArrayDeque;

public class Solution {
    static public String solution(String p) {
        if (check(p)) {
            return p;
        }
        return separate(p);
    }

    private static String separate(String s) {
        if (s.length() == 0) {
            return "";
        }

        String u = "";
        String v = "";

        int num1 = 0;
        int num2 = 0;

        String tmp = "";
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                num1++;
                tmp += '(';
            }
            //
            else if (s.charAt(i) == ')') {
                num2++;
                tmp += ')';
            }

            if (num1 == num2) {
                u = tmp;
                flag = true;
            }

            if (flag && num1 != num2) {
                break;
            }
        }

        v = s.substring(u.length());

        if (check(u)) {
            return u + separate(v);
        }
        else {
            String s2 = "(";
            s2 += separate(v);
            s2 += ')';
            u = u.substring(1, u.length() - 1);
            s2 += reverse(u);
            return s2;
        }
    }

    private static String reverse(String s) {
        String reverseS2 = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                reverseS2 += ')';
            }
            else {
                reverseS2 += '(';
            }
        }
        return reverseS2;
    }

    private static boolean check(String s) {
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dq.addLast('(');
            }
            else if (s.charAt(i) == ')') {
                if (dq.isEmpty()) {
                    return false;
                }
                dq.pollLast();
            }
        }
        return dq.isEmpty();
    }
}