import java.util.Scanner;

public class 별찍기5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) { // 1 2 3 4 5
            for (int k = n-i; k > 0; k--) { // 4 3 2 1 0
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");                
            }
            System.out.println();
        }
    }
}
