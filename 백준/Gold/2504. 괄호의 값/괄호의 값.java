import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        ArrayDeque<Character> dq = new ArrayDeque<>();
        boolean flag = true;

        int result = 0;
        int tmp = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dq.addLast(s.charAt(i));
                tmp *= 2;
            }
            else if (s.charAt(i) == '[') {
                dq.addLast(s.charAt(i));
                tmp *= 3;
            }
            else {
                if (s.charAt(i) == ')') {
                    if (dq.isEmpty() || dq.peekLast() != '(') {
                        flag = false;
                        break;
                    }

                    if (s.charAt(i - 1) == '(') {
                        result += tmp;
                    }
                    dq.removeLast();
                    tmp /= 2;
                }
                else if (s.charAt(i) == ']') {
                    if (dq.isEmpty() || dq.peekLast() != '[') {
                        flag = false;
                        break;
                    }

                    if (s.charAt(i - 1) == '[') {
                        result += tmp;
                    }
                    dq.removeLast();
                    tmp /= 3;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }

        if (!flag || !dq.isEmpty()) {
            System.out.println(0);
            return;
        }
        else {
            System.out.println(result);
        }
    }
}