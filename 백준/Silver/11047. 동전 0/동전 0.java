import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 동전 종류
        int K = sc.nextInt(); // 만들려는 가치의 합

        
        int[] money = new int[N];
        for(int i=0; i<N; i++) {
            money[N-i-1] = sc.nextInt();
        }

        int result = 0; // 필요한 동전 개수
        
        // N개의 동전 가치 주어짐
        for(int i=0; i<N; i++) {
            int num = money[i];
            if(K==0) break;
            
            if(num > K) continue;
        
            else {
                int n = K/num;
                result += n; // 동전 개수 더해주기
                K -= (num*n);
            }
        }
        System.out.println(result);
    }
}