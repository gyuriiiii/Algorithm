import java.util.Scanner;

public class 나는행복합니다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(k-- == 0) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}