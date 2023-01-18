import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int answer; // 배정된 예산 중 가장 큰 값
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 지방의 수
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int total = sc.nextInt();

        int low = 0;
        int high = arr[N-1];

        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;
            
            for(int i=0; i<N; i++) {
                if (arr[i] < mid) { // 상한액보다 작은 경우
                    sum += arr[i]; // 요청금액 그대로 주기
                }
                else { 
                    sum += mid; // 상한액 주기
                }
            }

            if(sum > total) { // 초과하는 경우 (상한액 내리기)
                high = mid - 1;
            }
            else { // 상한액 올리기
                low = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }
}