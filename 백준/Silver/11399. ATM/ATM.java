import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람의 수
        int[] P = new int[N];

        // 각 사람이 돈 인출하는데 걸리는 시간
        for(int i=0; i<N; i++) {
            P[i] = sc.nextInt();
        }

        // 각 사람이 돈 인출하는데 필요한 시간의 합의 최솟값 구하기
        Arrays.sort(P);
        
        int sum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<=i; j++) {
                sum += P[j];
            }
        }
        System.out.println(sum);
    }
}