import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt(); // 테스트 케이스 개수

        for (int j = 0; j < C; j++) {
            int N = sc.nextInt(); // 학생 수

            int[] arr = new int[N];
            int sum = 0;

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            double num = 0;
            for (int i : arr) {
                if (i > sum / N) { // 평균 넘는 학생
                    num++;
                }
            }
            double result = num * 100 / N;
            System.out.printf(String.format("%.3f", result));
            System.out.println("%");
        }
    }
}