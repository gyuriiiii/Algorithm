import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    

        int n = sc.nextInt(); // 사람 수
        int[][] arr = new int[n][2]; // 몸무게, 키
        for(int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            int rank = 1;
            for(int j=0; j<n; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}