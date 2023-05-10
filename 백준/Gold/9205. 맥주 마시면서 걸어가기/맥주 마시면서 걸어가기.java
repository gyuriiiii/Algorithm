import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            ArrayList<Node> list = new ArrayList<>();
            for (int j = 0; j < n + 2; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(new Node(x, y));
            }

            int[][] arr = new int[n + 2][n + 2];
            for (int j = 0; j < n + 2; j++) {
                for (int k = j + 1; k < n + 2; k++) {
                    if (getDistance(list.get(j), list.get(k)) <= 1000) {
                        arr[j][k] = 1;
                        arr[k][j] = 1;
                    }
                }
            }

            for (int k = 0; k < n + 2; k++) {
                for (int j = 0; j < n + 2; j++) {
                    for (int l = 0; l < n + 2; l++) {
                        if (arr[j][k] == 1 && arr[k][l] == 1) {
                            arr[j][l] = 1;
                        }
                    }
                }
            }

            if (arr[0][n + 1] == 1) {
                System.out.println("happy");
            }
            else {
                System.out.println("sad");
            }
        }
    }

    private static int getDistance(Node n1, Node n2) {
        return Math.abs(n2.x - n1.x) + Math.abs(n2.y - n1.y);
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