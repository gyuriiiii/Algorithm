import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Character> queue = new ArrayDeque<>();
        String s = br.readLine();

        boolean flag = false; // 태그 여부
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<' || c == '>') {
                flag = true;
            }

            // 태그인 경우
            if (flag) {
                queue.offer(s.charAt(i));

                if (s.charAt(i) == '>') {
                    flag = false;
                    for (Character result : queue) {
                        sb.append(result);
                    }
                    queue.clear();
                }
            } 
            
            // 태그 아닌 경우
            else {
                if (s.charAt(i) == ' ') { // 공백인 경우
                    queue.offerLast(' ');
                    for (Character result : queue) {
                        sb.append(result);
                    }
                    queue.clear();
                }

                else {
                    queue.offerFirst(s.charAt(i));
                }
            }
        }
        for (Character result : queue) {
            sb.append(result);
        }
        System.out.println(sb);
    }
}