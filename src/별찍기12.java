import java.util.Scanner;

public class 별찍기12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();           
        for (int i = 1; i <= n; i++) { 
            for (int k = n-i; k >= 1; k--) { 
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }       

        for (int i = n-1; i >= 1; i--) { 
            for (int k = n-i; k >= 1; k--) { 
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
