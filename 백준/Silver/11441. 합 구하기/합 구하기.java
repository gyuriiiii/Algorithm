import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        int[] arr = new int[N+1]; 
        int[] sum = new int[N+1];       
        for(int i=1; i<N+1; i++) {
            arr[i] = sc.nextInt();
            sum[i] = sum[i-1] + arr[i];
        }

        int M = sc.nextInt();
        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(sum[b] - sum[a-1]);
        }
    }
}