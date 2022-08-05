import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[9][9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 최댓값 구하기
        int max = arr[0][0];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        sb.append(max).append('\n');

        // 최댓값 몇 행 몇 열에 위치한 수인지 구하기
        int n = 0; // 행
        int m = 0; // 열

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(max == arr[i][j]) {
                    n = i;
                    m = j;
                }
            }
        }
        sb.append(n+1).append(' ').append(m+1);
        System.out.println(sb);
    }        
}