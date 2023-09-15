import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextInt();
        long Y = sc.nextInt();
        long Z = Y * 100 / X;

        long low = 0;
        long high = 1_000_000_000;
        long answer = -1;

        while (low <= high) {
            long mid = (low + high) / 2; // 이긴 횟수

            long totalGame = X + mid;
            long winNum = Y + mid;
            long winPercent = (winNum * 100) / totalGame;

            if (winPercent > 100) {
                high = mid - 1;
                continue;
            }

            if (winPercent <= Z) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}