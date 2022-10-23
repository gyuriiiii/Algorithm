import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수
        int V = sc.nextInt(); // 탐색 시작할 정점 번호

        int [][] arr = new int[N+1][N+1];
        boolean [] check = new boolean[N+1];

        for(int i=0; i<M; i++) {
            int e1 = sc.nextInt();
            int e2=  sc.nextInt();

            arr[e1][e2] = 1;
            arr[e2][e1] = 1;
        }
        System.out.println(dfs(arr, check, V));
        
        boolean [] check2 = new boolean[N+1];
        System.out.println(bfs(arr, check2, V));
    }

    static StringBuilder dfs(int[][] arr, boolean[] check, int v) {
        sb1.append(v).append(" ");

        check[v] = true;

        for(int i=1; i<arr.length; i++) {
            if(arr[v][i]==1 && !check[i]) { 
                dfs(arr, check, i);
            }
        }
        return sb1;
    }   

    static StringBuilder bfs(int[][] arr, boolean[] check2, int v) {
        check2[v] = true;
        sb2.append(v).append(" ");
        queue.add(v);

        while(queue.size() > 0) {
            v = queue.poll();

            for(int i=1; i<arr.length; i++) {
                if(arr[v][i]==1 & !check2[i]) {
                    check2[i] = true;
                    sb2.append(i).append(" ");
                    queue.add(i);
                }
            }
        }
        return sb2;
    }
}