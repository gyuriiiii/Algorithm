import java.util.Scanner;

public class Main {
    static String num;
    static String newNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;

        int result = N;
        while (true) {
            result = (result % 10) * 10 + (result / 10 + result % 10) % 10;
            cnt++;

            if (result == N) {
                break;
            }
        }
        System.out.println(cnt);
    }
}