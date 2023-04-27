import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 재료의 수
        int M = sc.nextInt(); // 갑옷 만드는데 필요한 수

        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        int left = 0;
        int right = 1;

        int answer = 0;

        while (right < num.length) {
            while (right < num.length) {
                int sum = num[left] + num[right];
                if (sum < M) {
                    right++;
                }
                else if (sum == M) {
                    answer++;
                    left++;
                    right = left + 1;
                }
                else if(sum > M) {
                    left++;
                    right = left + 1;
                }
            }
            left++;
            right = left + 1;
        }
        System.out.println(answer);
    }
}