import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int result = 0; 

        for (int i = 0; i < n; i++) {
            int sum = 0;
            sum += i;

            int num = i;
            while(num>0) {
                sum += num%10;
                num/=10;
            }

            if(sum == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
