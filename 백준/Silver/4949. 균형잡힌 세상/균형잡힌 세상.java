import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String word = sc.nextLine();

            if (word.equals(".")) {
                break;
            }

            System.out.println(check(word));
        }
    }

    public static String check(String word) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            }

            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }
                stack.pop();
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }
                stack.pop();
            }
        }
        if (stack.size() == 0) {
            return "yes";
        } 
        else {
            return "no";
        }
    }
}