import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int[] cnt = new int[101];

        for (int i = 0; i < 3; i++) {
            int arrive = sc.nextInt();
            int leave = sc.nextInt();

            for (int j = arrive; j < leave; j++) {
                cnt[j]++;
            }
        }

        int sum = 0;
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == 0) {
                continue;
            }

            switch (cnt[i]) {
                case 1:
                    sum += A;
                    break;
                case 2:
                    sum += (2 * B);
                    break;
                case 3:
                    sum += (3 * C);
                    break;
            }
        }
        System.out.println(sum);
    }
}