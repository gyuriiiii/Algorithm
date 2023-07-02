import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static char[][] map;
    static boolean[] visited;

    static ArrayList<Node> list = new ArrayList<>();
    static ArrayList<Node> teachers = new ArrayList<>();
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.next().charAt(0);

                if (map[i][j] == 'X') {
                    list.add(new Node(i, j));
                }
                else if (map[i][j] == 'T') {
                    teachers.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[list.size()];
        dfs(0, 3);

        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void dfs(int cnt, int max) {
        if (cnt == max) {
            if (checkAllSurvive()) {
                flag = true;
                return;
            }

            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                map[list.get(i).x][list.get(i).y] = 'O';
                dfs(cnt + 1, max);

                if (flag) {
                    break;
                }
                map[list.get(i).x][list.get(i).y] = 'X';
                visited[i] = false;
            }
        }
    }

    private static boolean checkAllSurvive() {
        ArrayDeque<Node> tmpDq = new ArrayDeque<>();
        for (int i = 0; i < teachers.size(); i++) {
            tmpDq.add(teachers.get(i));
        }

        while (!tmpDq.isEmpty()) {
            Node tmp = tmpDq.poll();

            // 위
            for (int i = tmp.x - 1; i >= 0; i--) {
                if (map[i][tmp.y] == 'O') {
                    break;
                }

                else if (map[i][tmp.y] == 'S') {
                    return false;
                }
            }

            // 아래
            for (int i = tmp.x + 1; i < N; i++) {
                if (map[i][tmp.y] == 'O') {
                    break;
                }

                else if (map[i][tmp.y] == 'S') {
                    return false;
                }
            }

            // 오른쪽
            for (int i = tmp.y + 1; i < N; i++) {
                if (map[tmp.x][i] == 'O') {
                    break;
                }

                if (map[tmp.x][i] == 'S') {
                    return false;
                }
            }

            // 왼쪽
            for (int i = tmp.y - 1; i >= 0; i--) {
                if (map[tmp.x][i] == 'O') {
                    break;
                }

                if (map[tmp.x][i] == 'S') {
                    return false;
                }
            }
        }

        return true;
    }

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}