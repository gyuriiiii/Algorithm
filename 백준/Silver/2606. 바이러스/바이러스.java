import java.util.Scanner;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int pair = sc.nextInt();

        int arr[][] = new int[num+1][num+1]; // 그래프 인접행렬로 구현
        boolean check[] = new boolean[num+1]; // 정점 방문 여부 배열

        for(int i=0; i<pair; i++) {
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();

            arr[e1][e2] = 1;
            arr[e2][e1] = 1;
        }   
        dfs(arr, check, 1); // dfs 수행
        System.out.println(cnt-1);
    }

    static void dfs(int[][] arr, boolean[] check, int v) {
        check[v] = true;
        cnt++;

        for(int i=1; i<arr.length; i++) {
            if(arr[v][i] == 1 && !check[i]) { // 인접정점이고 방문하지 않았으면
                dfs(arr, check, i);
            }
        }
    }
}