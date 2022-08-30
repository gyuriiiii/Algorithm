import java.util.Scanner;

public class 소수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = 2; j <= num; j++) {
                for (int h = 2 * i; h <= Math.sqrt(j); h++) {
                    if (num % h == 0) { // 소수 x
                        continue;
                    }
                    else {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
