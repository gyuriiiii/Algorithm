import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static int pos = 3; // 뱀의 초기 방향 => 오른쪽
    static HashMap<Integer, String> changePos = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 보드의 크기
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        K = sc.nextInt(); // 사과의 개수
        for (int i = 0; i < K; i++) {
            map[sc.nextInt()][sc.nextInt()] = 1;
        }

        int L = sc.nextInt(); // 뱀의 방향 변환 횟수
        for (int i = 0; i < L; i++) {
            int X = sc.nextInt();
            String C = sc.next();

            changePos.put(X, C);
        }

        ArrayDeque<Snake> snake = new ArrayDeque<>();
        snake.add(new Snake(1, 1)); // 뱀의 초기 위치 저장
        visited[1][1] = true;

        int time = 0;
        while (true) {
            int x = snake.peekLast().x;
            int y = snake.peekLast().y;

            // 방향 변환해야 하는 경우
            if (changePos.containsKey(time)) {
                String op = changePos.get(time);

                if (op.equals("L")) {
                    if (pos == 3) {
                        pos = 0;
                    }
                    else {
                        pos++;
                    }
                }
                else if (op.equals("D")) {
                    if (pos == 0) {
                        pos = 3;
                    }
                    else {
                        pos--;
                    }
                }
            }

            // 기존 방향대로 이동해야 하는 경우
            int nx = x + dx[pos];
            int ny = y + dy[pos];

            // 벽인 경우
            if (nx < 1 || ny < 1 || nx > N || ny > N) {
                break;
            }

            // 자기 자신과 부딪힌 경우
            if (visited[nx][ny]) {
                break;
            }

            snake.addLast(new Snake(nx, ny)); // 몸길이 늘려 머리 위치 바꾸기
            visited[nx][ny] = true; // 머리 위치 표시

            // 해당 위치에 사과 있는 경우
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0; // 사과 제거
            }

            // 해당 칸에 사과 없는 경우
            // 머리는 해당 위치로 가고, 꼬리가 위치한 칸은 비워짐
            else {
                visited[snake.peekFirst().x][snake.peekFirst().y] = false; // 꼬리
                snake.pollFirst(); // 꼬리 위치 비우기
            }

            time++;
        }
        System.out.println(time + 1);
    }

    public static class Snake {
        int x;
        int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}