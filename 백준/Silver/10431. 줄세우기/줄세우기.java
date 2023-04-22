import java.util.Scanner;

public class Main {
    static int[] student;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();

            student = new int[20];
            for (int j = 0; j < 20; j++) {
                student[j] = sc.nextInt();
            }

            int cnt = 0;
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if (student[j] < student[k]) {
                        cnt++;
                    }
                }
            }
            sb.append(num + " " + cnt + "\n");
        }
        System.out.println(sb);
    }
}