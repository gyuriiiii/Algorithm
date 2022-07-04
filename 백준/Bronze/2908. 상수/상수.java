import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        String reA = "";
        String reB = "";
        while(a>0 && b>0) {
            reA += a%10;
            a/=10;
            reB += b%10;
            b/=10;
        }

        if(Integer.parseInt(reA) > Integer.parseInt(reB)) {
            System.out.println(reA);
        }
        else {
            System.out.println(reB);
        }
    }
}
