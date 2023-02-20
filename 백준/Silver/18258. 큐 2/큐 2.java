import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int num = Integer.parseInt(st.nextToken());

                dq.offerLast(num);
            } 
            else if (cmd.equals("pop")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } 
                else {
                    sb.append(dq.pollFirst()).append("\n");
                }
            } 
            else if (cmd.equals("size")) {
                sb.append(dq.size()).append("\n");
            } 
            else if (cmd.equals("empty")) {
                if (dq.isEmpty()) {
                    sb.append("1").append("\n");
                } 
                else {
                    sb.append("0").append("\n");
                }
            } 
            else if (cmd.equals("front")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } 
                else {
                    sb.append(dq.peekFirst()).append("\n");
                }
            } 
            else if (cmd.equals("back")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                } 
                else {
                    sb.append(dq.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}