import java.util.Scanner;

public class 별찍기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        for(int i=0; i<n; i++) { // 0 1 2 3 4 
            for(int k=0; k<n-i-1; k++) { // 4 3 2 1 0
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
