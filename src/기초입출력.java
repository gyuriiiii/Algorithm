import java.util.Scanner;

public class 기초입출력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt(); // 테스트 케이스 개수
        for (int i = 1; i <= num; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("Case #" + i + ": " + a + " + " + b + " = " + (a+b));
        }
        sc.close();
    }
}
