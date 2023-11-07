import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String s = sc.next();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.add(left.pop());
                    }
                }
                else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.add(right.pop());
                    }
                }
                else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                }
                else {
                    left.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!left.isEmpty()) {
                right.add(left.pop());
            }

            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            System.out.println(sb);
        }
    }
}