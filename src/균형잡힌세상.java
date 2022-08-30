import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        while(true) {
            String s = st.nextToken();
            if(s == ".") {
                System.out.println("yes");
                break;
            }
            
            if(s.contains(("("))) {
                stack.push("(");
            }
            if(s.contains((")"))) {
                if(stack.isEmpty()) {
                    System.out.println("no");
                    break;
                }
                stack.pop();
            }
            
            if(s.contains(("["))) {
                stack2.push("[");
            }
            if(s.contains(("]"))) {
                if(stack2.isEmpty()) {
                    System.out.println("no");
                    break;
                }
                stack2.pop();
            }

            if(s.contains(".")) {
                if(stack.size()==0 && stack2.size()==0) {
                    System.out.println("yes");
                }
            }
        }
    }
}
