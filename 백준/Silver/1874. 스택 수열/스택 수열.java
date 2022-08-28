import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        int lastIdx = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num > lastIdx) { // 오름차순인 경우
                for (int j = lastIdx+1; j <= num; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                lastIdx = num;
            }
            else {
                if(stack.peek() != num) {
                    System.out.println("NO");
                    return;
                }
            }
            stack.pop();
            sb.append('-').append('\n');            
        }
        System.out.print(sb);
    }
}