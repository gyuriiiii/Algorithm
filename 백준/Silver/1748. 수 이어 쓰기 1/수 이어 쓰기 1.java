import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int result = 0; 
        int plus = 1; 
        int divide = 10;

        for (int i = 1; i <= N; i++) {
            if (i % divide == 0) {
                plus++;
                divide *= 10;
            }
            result += plus;
        }
        System.out.println(result);
    }
}