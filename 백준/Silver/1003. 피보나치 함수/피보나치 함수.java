import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[][] = new int[41][2]; // 0과 1이 나온 개수

        arr[0][0] = 1; 
        arr[0][1] = 0; 
        arr[1][0] = 0; 
        arr[1][1] = 1; 

        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
            int N = sc.nextInt();

            for(int j=2; j<=N; j++) {
                arr[j][0] = arr[j-1][0] + arr[j-2][0];
                arr[j][1] = arr[j-1][1] + arr[j-2][1];
            }
            System.out.println(arr[N][0] + " " + arr[N][1]);
        }
    }
}