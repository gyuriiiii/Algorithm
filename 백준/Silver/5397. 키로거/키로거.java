import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String s = sc.next();

            ArrayDeque<Character> left = new ArrayDeque<>();
            ArrayDeque<Character> right = new ArrayDeque<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.addLast(left.pollLast());
                    }
                }
                else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.addLast(right.pollLast());
                    }
                }
                else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                }
                else {
                    left.addLast(c);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!left.isEmpty()) {
                sb.append(left.pollFirst());
            }

            while (!right.isEmpty()) {
                sb.append(right.pollLast());
            }

            System.out.println(sb);
        }
    }
}