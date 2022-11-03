import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M;
    static int N;
    static int K;
    
    static int [][] arr;
    static int [][] visited;
    
    
    static Queue<int[]> queue;
    static int cnt;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
            M = sc.nextInt(); // 배추밭 가로길이
            N = sc.nextInt(); // 배추밭 세로길이 
            K = sc.nextInt(); // 배추 심어져 있는 위치 개수

            cnt = 0;

            arr = new int[M][N];
            visited = new int[M][N];
            queue = new LinkedList<>();
            
            for(int j=0; j<K; j++) {
                int s1 = sc.nextInt();
                int s2 = sc.nextInt();

                arr[s1][s2] = 1; // 심어진 배추는 1
            }

            for(int k=0; k<arr.length; k++) {
                for(int f=0; f<arr[k].length; f++) {
                    if(visited[k][f] == 0 && arr[k][f] == 1) {
                        bfs(k, f);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int k, int f) {
        queue.add(new int[] {k, f}); // 큐에 넣기
        visited[k][f] = 1;

        // 인접 배추 검사
        while(!queue.isEmpty())  {
            int[] q = queue.poll();

            int qx = q[0];
            int qy = q[1];

            for(int i=0; i<4; i++) {
                int x = qx + dx[i];
                int y = qy + dy[i];

                if(x < 0 || y < 0 || x >= M || y >= N) {
                    continue;
                }

                if(visited[x][y] == 0 && arr[x][y] == 1) { // 아직 방문하지 않은 경우
                    visited[x][y] = 1; // 방문 표시
                    queue.add(new int[] {x, y}); // 큐에 넣기
                }
            }
        }
    }
}