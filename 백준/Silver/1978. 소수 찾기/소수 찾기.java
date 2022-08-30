import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            
            int num = arr[i];
            if (num == 1) continue;
            if (num == 2) {
                result++;
                continue;
            }

            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) result++;
        }
        System.out.println(result);
    }
}