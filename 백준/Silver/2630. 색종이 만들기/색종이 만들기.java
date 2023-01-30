import java.util.Scanner;

public class Main {
    static int N;
    static int[][] arr;
    static int white;
    static int blue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void partition(int a, int b, int size) {
        if (checkColor(a, b, size)) {
            if (arr[a][b] == 0) {
                white++;
            } 
            else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        partition(a, b, newSize);
        partition(a, b + newSize, newSize);
        partition(a + newSize, b, newSize);
        partition(a + newSize, b + newSize, newSize);
    }

    private static boolean checkColor(int a, int b, int len) {
        int tmp = arr[a][b];

        for (int i = a; i < a + len; i++) {
            for (int j = b; j < b + len; j++) {
                if (arr[i][j] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }
}