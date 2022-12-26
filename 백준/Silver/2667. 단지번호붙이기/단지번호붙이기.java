import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = { -1, 1, 0, 0 }; 
    static int[] dy = { 0, 0, -1, 1 }; 
    static int N;
    static int[][] arr;
    static boolean[][] check;
    static int[] apart;
    static int apartNum = 0; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); 

        arr = new int[N][N];
        check = new boolean[N][N];
        apart = new int[N*N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();

            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 1 && !check[i][j]) {
                    apartNum++;
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(apartNum);
        Arrays.sort(apart);
        for (int i : apart) {
            if(i!=0) {
                System.out.println(i);
            }
        }
    }

    private static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { a, b }); // 큐에 추가
        check[a][b] = true; // 방문 여부 표시
        apart[apartNum]++;

        while (!queue.isEmpty()) {          
            int[] k = queue.poll();
            int kx = k[0];
            int ky = k[1];

            for (int i = 0; i < 4; i++) {
                int curx = kx + dx[i];
                int cury = ky + dy[i];

                if (curx < 0 || cury < 0 || curx >= N || cury >= N)
                    continue;

                if (arr[curx][cury] == 0 || check[curx][cury] == true)
                    continue;

                queue.add(new int[] {curx, cury});
                check[curx][cury] = true;
                apart[apartNum]++;
            }
        }
    }
}