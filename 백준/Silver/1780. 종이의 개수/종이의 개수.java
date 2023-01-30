import java.util.Scanner;

public class Main {
    static int N;
    static int[][] arr;

    static int cntM1 = 0;
    static int cnt0 = 0;
    static int cnt1 = 0;

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
        System.out.println(cntM1);
        System.out.println(cnt0);
        System.out.println(cnt1);
    }

    private static void partition(int a, int b, int size) {
        if (check(a, b, size)) {
            if (arr[a][b] == -1) {
                cntM1++;
            } 
            else if (arr[a][b] == 0) {
                cnt0++;
            } 
            else {
                cnt1++;
            }
            return;
        }

        int newSize = size / 3;

        partition(a, b, newSize);
        partition(a, b + newSize, newSize);
        partition(a, b + (2*newSize), newSize);
        
        partition(a + newSize, b, newSize);
        partition(a + newSize, b + newSize, newSize);
        partition(a + newSize, b + (2*newSize), newSize);

        partition(a + (2*newSize), b, newSize);
        partition(a + (2*newSize), b + newSize, newSize);
        partition(a + (2*newSize), b + (2*newSize), newSize);
    }

    private static boolean check(int a, int b, int size) {
        int tmp = arr[a][b];

        for (int i = a; i < a + size; i++) {
            for (int j = b; j < b + size; j++) {
                if (arr[i][j] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }
}