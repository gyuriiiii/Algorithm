import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;

    static boolean[][] check;
    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = sc.next();
            
            for(int j=0; j<M; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        
        check = new boolean[N][M];
        
        bfs();
        System.out.println(arr[N-1][M-1]);
    }
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {0, 0}); // (0,0) 추가
        check[0][0] = true; // 방문 표시

        while(!queue.isEmpty()) { 
            // 현 위치
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0; i<4; i++) {
                // 다음 위치
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                
                if(check[nextX][nextY] || arr[nextX][nextY] == 0) { // 이미 방문했거나 이동 불가한 경우
                    continue;
                }

                // 그 외
                queue.add(new int[] {nextX, nextY});
                check[nextX][nextY] = true;
                arr[nextX][nextY] = arr[curX][curY] + 1;
            }
        }
    }
}