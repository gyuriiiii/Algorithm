import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 과목 개수
        double[] score = new double[n];
        for(int i=0; i<n; i++) {
            score[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(score); // 오름차순 정렬
        double max = score[n-1]; // 최고점
        for(int j=0; j<score.length; j++) {
            score[j] = (score[j]/max)*100;
        }

        double result = 0;
        for (double k : score) {
            result += k;
        }

        System.out.println(result/n);
    }
}