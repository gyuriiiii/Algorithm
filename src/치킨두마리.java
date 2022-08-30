import java.util.Scanner;

public class 치킨두마리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int chicken = sc.nextInt();

        if(A+B >= (chicken*2)) {
            System.out.println(A+B-(chicken*2));
        }
        else {
            System.out.println(A+B);
        }
    }
}