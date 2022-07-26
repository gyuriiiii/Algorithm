import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum1 = 0;
        int sum2 = 0;
        // 영식 요금제
        for(int i=0; i<n; i++) {
            int sal = arr[i]/30;
            sum1 += 10 + sal*10;
        }

        // 민식 요금제
        for(int i=0; i<n; i++) {
            int sal = arr[i]/60;
            sum2 += 15 + sal*15;
        }

        if(sum1 > sum2) {
            System.out.print("M " + sum2);
        }
        if(sum1 < sum2) {
            System.out.print("Y " + sum1);
        }
        if(sum1 == sum2) {
            System.out.print("Y M " + sum1);
        }
    }
}
