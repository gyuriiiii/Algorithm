import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[][] board;
    static ArrayList<Node> zeroList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String s = sc.next();
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(s.charAt(j) + "");

                if (board[i][j] == 0)
                    zeroList.add(new Node(i, j));
            }
        }

        puzzle(0, zeroList.size());
    }

    private static void puzzle(int depth, int size) {
        if (depth == size) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        Node node = zeroList.get(depth);
        boolean[] check = new boolean[10];

        // 각 행 검사
        for (int j = 0; j < 9; j++) {
            if (board[node.x][j] != 0) {
                check[board[node.x][j]] = true;
            }
        }

        // 각 열 검사
        for (int j = 0; j < 9; j++) {
            if (board[j][node.y] != 0) {
                check[board[j][node.y]] = true;
            }
        }

        // 3x3 사각형 범위 검사
        int nx = (node.x / 3) * 3;
        int ny = (node.y / 3) * 3;

        for (int j = nx; j < nx + 3; j++) {
            for (int k = ny; k < ny + 3; k++) {
                if (board[j][k] == 0)
                    continue;

                check[board[j][k]] = true;
            }
        }

        for (int j = 1; j <= 9; j++) {
            if (!check[j]) {
                board[node.x][node.y] = j;
                puzzle(depth + 1, size);
                board[node.x][node.y] = 0;
            }
        }

    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}