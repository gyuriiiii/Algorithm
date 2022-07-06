import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // 테스트 케이스 개수
        int[] answer = new int[t]; // 결과값 저장

        for (int num = 0; num < t; num++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int arr[][] = new int[k + 1][n + 1];

            for(int i=1; i<=n; i++) {
                arr[0][i] = i;
            }

            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr[i].length; j++) {
                    for (int l = 1; l <= j; l++) {
                        arr[i][j] += arr[i - 1][l];
                    }               
                }
            }
            answer[num] = arr[k][n];   
        }
        sc.close();

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
