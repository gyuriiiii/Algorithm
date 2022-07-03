import java.util.Scanner;

public class 별찍기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for (int i = n; i >= 1; i--) { // 5 4 3 2 1
            for (int j = 1; j <= n-i; j++) { // 0 1 2 3 4
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print("*");                
            }
            System.out.println();
        }
    }
}
