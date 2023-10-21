import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] bits = new int[N];
        int alpha = (1 << 27) - 1;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            for (int j = 0; j < word.length(); j++) {
                char w = word.charAt(j);
                bits[i] |= 1 << (w - 'a');
            }
        }

        for (int i = 0; i < M; i++) {
            int o = sc.nextInt();
            char x = sc.next().charAt(0);

            // x 잊는 경우
            if (o == 1) {
                alpha &= ~(1 << (x - 'a'));
            }
            // x 기억하는 경우
            else {
                alpha |= (1 << x - 'a');
            }

            int answer = 0;
            for (int j = 0; j < N; j++) {
                if ((bits[j] & alpha) >= bits[j]) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}