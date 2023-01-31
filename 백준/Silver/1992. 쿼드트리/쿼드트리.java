import java.util.Scanner;

public class Main {
    static int N;
    static int[][] arr;
    static int newSize;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
        partition(0, 0, N);
        System.out.println(sb);
    }

    private static void partition(int a, int b, int size) {
        // 압축 가능한 경우
        if (check(a, b, size)) {
            sb.append(arr[a][b]);

            return;
        }
        
        sb.append('(');

        int newSize = size / 2;
        
        partition(a, b, newSize);
        partition(a, b + newSize, newSize);
        partition(a + newSize, b, newSize);
        partition(a + newSize, b + newSize, newSize);
        
        sb.append(')');
    }

    private static boolean check(int a, int b, int size) {
        int tmp = arr[a][b];

        for (int i = a; i < a + size; i++) {
            for (int j = b; j < b + size; j++) {
                if (tmp != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}