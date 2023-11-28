import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
    static String s;
    static int answer, change;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            s = st.nextToken();
            change = Integer.parseInt(st.nextToken());
            visited = new boolean[1000000][11];
            answer = 0;

            bfs(s);
            System.out.println("#" + (i + 1) + " " + answer);
        }
    }

    private static void bfs(String start) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start, 0));

        int len = start.length();
        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.cnt == change) {
                answer = Math.max(answer, Integer.parseInt(now.num));
                continue;
            }

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (i != j) {
                        String change = reverse(i, j, now.num);

                        if (!visited[Integer.parseInt(change)][now.cnt + 1]) {
                            visited[Integer.parseInt(change)][now.cnt + 1] = true;
                            dq.add(new Node(change, now.cnt + 1));
                        }
                    }
                }
            }
        }
    }

    private static String reverse(int i, int j, String num) {
        StringBuilder sb = new StringBuilder(num);
        char tmp = num.charAt(i);
        sb.setCharAt(i, num.charAt(j));
        sb.setCharAt(j, tmp);
        return sb.toString();
    }

    private static class Node {
        String num;
        int cnt;

        public Node(String num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}