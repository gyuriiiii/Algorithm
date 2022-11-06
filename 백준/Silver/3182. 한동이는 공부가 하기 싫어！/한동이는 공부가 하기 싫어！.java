import java.util.Scanner;

public class Main {
    static int cnt;
    static int maxNum;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        int [] arr = new int[N+1];

        for(int i=0; i<N; i++) {
            arr[i+1] = sc.nextInt(); // 각 선배가 알려준 선배 번호 저장
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<N; i++) {
            cnt = 0;
            visited = new int[N+1]; // 선배 만남 여부

            int num = dfs(arr, visited, i);

            if(max < num) {
                max = num;
                maxNum = i;
            }
        }
        System.out.println(maxNum);
    }

    private static int dfs(int[] arr, int[] visited, int n) {
        visited[n] = 1; // 방문 표시
        cnt++;
        
        if(visited[arr[n]] == 0) { // 아직 방문 안 했다면
            visited[arr[n]] = 1; // 방문 표시
            dfs(arr, visited, arr[n]); 
        }
        return cnt;
    }
}