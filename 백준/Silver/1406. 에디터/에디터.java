import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            left.add(s.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String op = st.nextToken();

            if (op.equals("L")) {
                if (!left.isEmpty()) {
                    right.add(left.pop());
                }
            }
            else if (op.equals("D")) {
                if (!right.isEmpty()) {
                    left.add(right.pop());
                }
            }
            else if (op.equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            }
            else  {
                String word = st.nextToken();
                left.add(word.charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!left.isEmpty()){
            right.add(left.pop());
        }

        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}