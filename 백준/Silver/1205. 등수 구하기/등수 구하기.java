import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rank = 1;

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int score = sc.nextInt();
        int P = sc.nextInt();

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        if (N >= P) {
            if (scores[N - 1] >= score) {
                rank = -1;
                System.out.println(rank);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            if (scores[i] > score) {
                rank++;
            }
            else {
                break;
            }
        }
        System.out.println(rank);
    }
}