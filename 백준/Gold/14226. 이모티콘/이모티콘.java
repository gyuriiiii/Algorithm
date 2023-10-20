import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int S;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextInt();
        visited = new boolean[1001][1001];

        bfs();
    }

    private static void bfs() {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(1, 0, 0));
        visited[1][0] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.emotion == S) {
                System.out.println(now.time);
                return;
            }

            // 복사
            dq.add(new Node(now.emotion, now.time + 1, now.emotion));

            // 붙여넣기
            if (now.board > 0 && now.emotion + now.board <= S && !visited[now.emotion + now.board][now.board]) {
                visited[now.emotion + now.board][now.board] = true;
                dq.add(new Node(now.emotion + now.board, now.time + 1, now.board));
            }

            // 삭제
            if (now.emotion > 0 && !visited[now.emotion - 1][now.board]) {
                visited[now.emotion - 1][now.board] = true;
                dq.add(new Node(now.emotion - 1, now.time + 1, now.board));
            }
        }
    }

    private static class Node {
        int emotion;
        int time;
        int board;

        public Node(int emotion, int time, int board) {
            this.emotion = emotion;
            this.time = time;
            this.board = board;
        }
    }
}