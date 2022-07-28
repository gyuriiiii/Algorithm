import java.util.Scanner;

public class Main {
    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = factorial(n) / (factorial(k)*factorial(n-k));
        System.out.println(result);
    }

    static int factorial(int n) {
        int fac = 1;
        for(int i=1; i<=n; i++) {
            fac *= i;
        }
        return fac;
    }
}