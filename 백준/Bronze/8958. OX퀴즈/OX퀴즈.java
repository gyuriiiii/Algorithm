import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = new String[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        sc.close();

        for (int i = 0; i < arr.length; i++) {
            int score = 0;
            int idx = 0; // 연속으로 맞은 문제 개수

            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == 'O') {
                    idx++;
                } else {
                    idx = 0;
                }
                score += idx;
            }
            System.out.println(score);
        }

    }
}
