import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[11];
        
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
            int n = sc.nextInt();

            for(int j=4; j<=n; j++) {
                arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
            }
            System.out.println(arr[n]);
        }
    }
}