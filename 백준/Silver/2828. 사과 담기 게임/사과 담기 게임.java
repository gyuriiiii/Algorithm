import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 스크린
        int m = sc.nextInt(); // 바구니
        int j = sc.nextInt();

        int basket = 1; 
        int move = 0;

        for (int i = 0; i < j; i++) {
            int drop = sc.nextInt();

            if (drop > basket + m - 1) {
                move += (drop - basket - m + 1);
                basket = drop - m + 1;
            }
            else if (drop < basket) {
                move += (basket - drop);
                basket = drop;
            }
        }

        System.out.println(move);
    }
}